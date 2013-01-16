package com.facebook.bookmark.service.handler;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.bookmark.ipc.BookmarkIpcConstants;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.bookmark.service.BroadcastSender;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

public class BookmarkSetFavoritesDBHandler
  implements OrcaServiceHandler.Filter
{
  private final BroadcastSender a;
  private final DBBookmarkHelper b;

  public BookmarkSetFavoritesDBHandler(BroadcastSender paramBroadcastSender, DBBookmarkHelper paramDBBookmarkHelper)
  {
    this.a = paramBroadcastSender;
    this.b = paramDBBookmarkHelper;
  }

  private void a(BookmarksGroup paramBookmarksGroup)
  {
    Intent localIntent = new Intent(BookmarkIpcConstants.f);
    localIntent.setType("vnd.android.cursor.item/vnd.facebook.katana.favorites");
    localIntent.putExtra("bookmark_new_favorites", paramBookmarksGroup);
    this.a.a(localIntent);
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    BookmarksGroup localBookmarksGroup = (BookmarksGroup)paramOperationParams.b().getParcelable("newFavoriteBookmarksGroup");
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    this.b.a(localBookmarksGroup);
    a(localBookmarksGroup);
    return localOperationResult;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.handler.BookmarkSetFavoritesDBHandler
 * JD-Core Version:    0.6.2
 */