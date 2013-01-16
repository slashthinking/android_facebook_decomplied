package com.facebook.bookmark.service.handler;

import android.content.Intent;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.ipc.BookmarkIpcConstants;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.bookmark.service.BroadcastSender;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class BookmarkSaveToDBServiceHandler
  implements OrcaServiceHandler.Filter
{
  private final BroadcastSender a;
  private final DBBookmarkHelper b;
  private String c = null;

  public BookmarkSaveToDBServiceHandler(BroadcastSender paramBroadcastSender, DBBookmarkHelper paramDBBookmarkHelper)
  {
    this.a = paramBroadcastSender;
    this.b = paramDBBookmarkHelper;
  }

  private void a(FetchBookmarksResult paramFetchBookmarksResult)
  {
    Intent localIntent = new Intent(BookmarkIpcConstants.f);
    localIntent.setType("vnd.android.cursor.item/vnd.facebook.katana.bookmark");
    localIntent.putExtra("bookmark_groups", paramFetchBookmarksResult);
    this.a.a(localIntent);
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    long l2;
    List localList;
    if (localOperationResult.c())
    {
      String str = localOperationResult.f();
      long l1 = this.b.a();
      l2 = System.currentTimeMillis();
      if ((l1 <= 0L) && (str.equals(this.c)))
        break label123;
      this.c = str;
      localList = JMParser.b(new JsonFactory().createJsonParser(str), BookmarksGroup.class);
      this.b.a(localList, l2);
    }
    label123: for (FetchBookmarksResult localFetchBookmarksResult = new FetchBookmarksResult(DataFreshnessResult.FROM_SERVER, l2, ImmutableList.a(localList)); ; localFetchBookmarksResult = new FetchBookmarksResult(DataFreshnessResult.FROM_SERVER, l2, null))
    {
      a(localFetchBookmarksResult);
      localOperationResult = OperationResult.a(localFetchBookmarksResult);
      return localOperationResult;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.handler.BookmarkSaveToDBServiceHandler
 * JD-Core Version:    0.6.2
 */