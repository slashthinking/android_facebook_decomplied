package com.facebook.bookmark.client;

import android.os.Bundle;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.common.util.Log;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.atomic.AtomicBoolean;

class BookmarkClient$2
  implements FutureCallback<OperationResult>
{
  BookmarkClient$2(BookmarkClient paramBookmarkClient)
  {
  }

  public void a(OperationResult paramOperationResult)
  {
    BookmarkClient.b(this.a).set(false);
    FetchBookmarksResult localFetchBookmarksResult = (FetchBookmarksResult)paramOperationResult.h();
    BookmarkClient.a(this.a, paramOperationResult.j().getInt("bookmarks_expire_time", -1));
    if (BookmarkClient.c(this.a) < 0)
      Log.a(BookmarkClient.g(), "The expire time is not set or not correct!");
    if (localFetchBookmarksResult.e() != DataFreshnessResult.FROM_SERVER)
    {
      BookmarkClient.a(this.a, localFetchBookmarksResult);
      BookmarkClient.a(this.a, localFetchBookmarksResult.f());
    }
  }

  public void a(Throwable paramThrowable)
  {
    BookmarkClient.b(this.a).set(false);
    BookmarkClient.a(this.a, paramThrowable, "syncWithDb");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClient.2
 * JD-Core Version:    0.6.2
 */