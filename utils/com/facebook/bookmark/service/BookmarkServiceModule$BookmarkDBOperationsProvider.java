package com.facebook.bookmark.service;

import android.content.ContentResolver;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class BookmarkServiceModule$BookmarkDBOperationsProvider extends AbstractProvider<DBBookmarkHelper>
{
  private BookmarkServiceModule$BookmarkDBOperationsProvider(BookmarkServiceModule paramBookmarkServiceModule)
  {
  }

  public DBBookmarkHelper a()
  {
    return new DBBookmarkHelper((ContentResolver)b(ContentResolver.class, FromApplication.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule.BookmarkDBOperationsProvider
 * JD-Core Version:    0.6.2
 */