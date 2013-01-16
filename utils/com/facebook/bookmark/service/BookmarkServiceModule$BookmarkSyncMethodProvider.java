package com.facebook.bookmark.service;

import com.facebook.bookmark.protocol.BookmarkSyncMethod;
import com.facebook.orca.inject.AbstractProvider;

class BookmarkServiceModule$BookmarkSyncMethodProvider extends AbstractProvider<BookmarkSyncMethod>
{
  private BookmarkServiceModule$BookmarkSyncMethodProvider(BookmarkServiceModule paramBookmarkServiceModule)
  {
  }

  public BookmarkSyncMethod a()
  {
    return new BookmarkSyncMethod();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule.BookmarkSyncMethodProvider
 * JD-Core Version:    0.6.2
 */