package com.facebook.bookmark.service;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod;
import com.facebook.bookmark.protocol.BookmarkSyncMethod;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.bookmark.service.handler.BookmarkLoadFromDBServiceHandler;
import com.facebook.bookmark.service.handler.BookmarkSaveToDBServiceHandler;
import com.facebook.bookmark.service.handler.BookmarkSetFavoritesDBHandler;
import com.facebook.bookmark.service.handler.BookmarkUpdateUnreadCountDBHandler;
import com.facebook.bookmark.service.handler.BoomarkPerfMonitor;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.handlers.ApiMethodServiceHandler;
import com.facebook.orca.server.handlers.ApiMethodServiceHandler.BaseParamGetter;
import com.facebook.orca.server.handlers.OrcaServiceAggregateHandler;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

class BookmarkServiceModule$BookmarkServiceHandlerProvider extends AbstractProvider<OrcaServiceHandler>
{
  private BookmarkServiceModule$BookmarkServiceHandlerProvider(BookmarkServiceModule paramBookmarkServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink(new BoomarkPerfMonitor((PerformanceLogger)b(PerformanceLogger.class)), c());
  }

  public OrcaServiceHandler c()
  {
    HashMap localHashMap = Maps.a();
    DBBookmarkHelper localDBBookmarkHelper = (DBBookmarkHelper)b(DBBookmarkHelper.class);
    FilterChainLink localFilterChainLink = new FilterChainLink(new BookmarkSaveToDBServiceHandler((BroadcastSender)b(BroadcastSender.class), localDBBookmarkHelper), new ApiMethodServiceHandler((SingleMethodRunner)b(SingleMethodRunner.class), (ApiMethod)b(BookmarkSyncMethod.class), ApiMethodServiceHandler.a, ApiMethodServiceHandler.c));
    localHashMap.put("syncWithServer", localFilterChainLink);
    localHashMap.put("syncWithDB", new FilterChainLink(new BookmarkLoadFromDBServiceHandler(localDBBookmarkHelper, BookmarkServiceModule.c(this.a)), localFilterChainLink));
    localHashMap.put("setFavoriteBookmarks", new FilterChainLink(new BookmarkSetFavoritesDBHandler((BroadcastSender)b(BroadcastSender.class), localDBBookmarkHelper), new ApiMethodServiceHandler((SingleMethodRunner)b(SingleMethodRunner.class), (ApiMethod)b(BookmarkSetFavoritesMethod.class), new ApiMethodServiceHandler.BaseParamGetter("newFavoriteBookmarksGroup"), ApiMethodServiceHandler.b)));
    localHashMap.put("updateUnreadCount", new BookmarkUpdateUnreadCountDBHandler((BroadcastSender)b(BroadcastSender.class), localDBBookmarkHelper));
    return new OrcaServiceAggregateHandler(localHashMap);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule.BookmarkServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */