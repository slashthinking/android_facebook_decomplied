package com.facebook.bookmark.client;

import com.facebook.annotations.ContextAwareAuthTokenString;
import com.facebook.app.UserActivityManager;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class BookmarkClientModule$BookmarkPreloadBackgroundTaskProvider extends AbstractProvider<BookmarkPreloadBackgroundTask>
{
  private BookmarkClientModule$BookmarkPreloadBackgroundTaskProvider(BookmarkClientModule paramBookmarkClientModule)
  {
  }

  public BookmarkPreloadBackgroundTask a()
  {
    return new BookmarkPreloadBackgroundTask((BookmarkManager)b(BookmarkManager.class), (UserActivityManager)b(UserActivityManager.class), a(String.class, ContextAwareAuthTokenString.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClientModule.BookmarkPreloadBackgroundTaskProvider
 * JD-Core Version:    0.6.2
 */