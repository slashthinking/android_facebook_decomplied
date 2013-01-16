package com.facebook.bookmark.client;

import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.atomic.AtomicBoolean;

class BookmarkClient$3
  implements FutureCallback<OperationResult>
{
  BookmarkClient$3(BookmarkClient paramBookmarkClient)
  {
  }

  public void a(OperationResult paramOperationResult)
  {
    BookmarkClient.b(this.a).set(false);
  }

  public void a(Throwable paramThrowable)
  {
    BookmarkClient.b(this.a).set(false);
    BookmarkClient.a(this.a, paramThrowable, "syncWithServer");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClient.3
 * JD-Core Version:    0.6.2
 */