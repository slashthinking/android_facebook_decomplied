package com.facebook.bookmark.client;

import com.facebook.bookmark.BookmarkManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class BookmarkClientModule$BookmarkClientProvider extends AbstractProvider<BookmarkManager>
{
  private BookmarkClientModule$BookmarkClientProvider(BookmarkClientModule paramBookmarkClientModule)
  {
  }

  public BookmarkManager a()
  {
    return new BookmarkClient(BookmarkClientModule.a(this.a), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), BookmarkClientModule.b(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClientModule.BookmarkClientProvider
 * JD-Core Version:    0.6.2
 */