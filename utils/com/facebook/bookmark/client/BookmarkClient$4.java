package com.facebook.bookmark.client;

import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class BookmarkClient$4
  implements FutureCallback<OperationResult>
{
  BookmarkClient$4(BookmarkClient paramBookmarkClient)
  {
  }

  public void a(OperationResult paramOperationResult)
  {
  }

  public void a(Throwable paramThrowable)
  {
    BookmarkClient.a(this.a, paramThrowable, "updateBookmarkUnreadCount");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClient.4
 * JD-Core Version:    0.6.2
 */