package com.facebook.bookmark.service.handler;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.bookmark.ipc.BookmarkIpcConstants;
import com.facebook.bookmark.ipc.BookmarkTable.Columns;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.bookmark.service.BroadcastSender;
import com.facebook.common.db.Table.Column;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;

public class BookmarkUpdateUnreadCountDBHandler
  implements OrcaServiceHandler
{
  private final BroadcastSender a;
  private final DBBookmarkHelper b;

  public BookmarkUpdateUnreadCountDBHandler(BroadcastSender paramBroadcastSender, DBBookmarkHelper paramDBBookmarkHelper)
  {
    this.a = paramBroadcastSender;
    this.b = paramDBBookmarkHelper;
  }

  private void a(long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(BookmarkIpcConstants.f);
    localIntent.setType("vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count");
    localIntent.putExtra("bookmark_fbid", paramLong);
    localIntent.putExtra("bookmark_unread_count", paramInt);
    this.a.a(localIntent);
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    long l = localBundle.getLong(BookmarkTable.Columns.b.a);
    int i = localBundle.getInt(BookmarkTable.Columns.h.a);
    if (this.b.a(l, i))
      a(l, i);
    for (OperationResult localOperationResult = OperationResult.b(); ; localOperationResult = OperationResult.a(ErrorCode.OTHER, "Fail to update unread count for bookmark " + l))
      return localOperationResult;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.handler.BookmarkUpdateUnreadCountDBHandler
 * JD-Core Version:    0.6.2
 */