package com.facebook.bookmark.ipc;

import android.net.Uri;
import com.facebook.base.BuildConstants;

public class BookmarkIpcConstants
{
  public static final String a = BuildConstants.b() + ".provider.BookmarkProvider";
  public static final Uri b = Uri.parse("content://" + a + "/" + "bookmarks");
  public static final Uri c = Uri.parse("content://" + a + "/" + "BookmarkUnreadCount");
  public static final Uri d = Uri.parse("content://" + a + "/" + "bookmark_sync_status");
  public static final Uri e = Uri.parse("content://" + a + "/" + "bookmark_group_order");
  public static final String f = BuildConstants.b() + ".broadcast.bookmarks";
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ipc.BookmarkIpcConstants
 * JD-Core Version:    0.6.2
 */