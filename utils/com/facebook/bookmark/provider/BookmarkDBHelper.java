package com.facebook.bookmark.provider;

import android.content.Context;
import com.facebook.common.db.DBHelper;
import com.facebook.common.db.Table;
import com.google.common.collect.Lists;

public class BookmarkDBHelper extends DBHelper
{
  public BookmarkDBHelper(Context paramContext)
  {
    this(paramContext, "bookmarks.db");
  }

  public BookmarkDBHelper(Context paramContext, String paramString)
  {
    super(Lists.a(arrayOfTable), paramContext, paramString, null, 1);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.provider.BookmarkDBHelper
 * JD-Core Version:    0.6.2
 */