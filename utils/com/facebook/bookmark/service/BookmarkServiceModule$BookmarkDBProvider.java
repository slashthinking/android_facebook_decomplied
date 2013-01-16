package com.facebook.bookmark.service;

import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.bookmark.provider.BookmarkDBHelper;
import com.facebook.orca.inject.AbstractProvider;

class BookmarkServiceModule$BookmarkDBProvider extends AbstractProvider<SQLiteOpenHelper>
{
  private BookmarkServiceModule$BookmarkDBProvider(BookmarkServiceModule paramBookmarkServiceModule)
  {
  }

  public SQLiteOpenHelper a()
  {
    return new BookmarkDBHelper(BookmarkServiceModule.a(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule.BookmarkDBProvider
 * JD-Core Version:    0.6.2
 */