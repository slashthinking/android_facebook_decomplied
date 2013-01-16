package com.facebook.bookmark.service;

import com.facebook.bookmark.provider.BookmarkDBUserDataCleaner;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.AbstractProvider;

class BookmarkServiceModule$BookmarkUserDataCleanerProvider extends AbstractProvider<BookmarkDBUserDataCleaner>
{
  private BookmarkServiceModule$BookmarkUserDataCleanerProvider(BookmarkServiceModule paramBookmarkServiceModule)
  {
  }

  public BookmarkDBUserDataCleaner a()
  {
    return new BookmarkDBUserDataCleaner((DBBookmarkHelper)b(DBBookmarkHelper.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule.BookmarkUserDataCleanerProvider
 * JD-Core Version:    0.6.2
 */