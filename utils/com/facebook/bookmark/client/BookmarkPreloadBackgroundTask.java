package com.facebook.bookmark.client;

import com.facebook.app.UserActivityManager;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.orca.common.util.Clock;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class BookmarkPreloadBackgroundTask extends AbstractBackgroundTask
{
  private final BookmarkManager a;
  private final UserActivityManager b;
  private final Provider<String> c;
  private final Clock d;
  private long e = 0L;

  public BookmarkPreloadBackgroundTask(BookmarkManager paramBookmarkManager, UserActivityManager paramUserActivityManager, Provider<String> paramProvider, Clock paramClock)
  {
    super("BOOKMARKS_MENU");
    this.a = paramBookmarkManager;
    this.b = paramUserActivityManager;
    this.c = paramProvider;
    this.d = paramClock;
  }

  public boolean b()
  {
    boolean bool1 = this.d.a() - this.e < 600000L;
    boolean bool2 = false;
    if (bool1);
    while (true)
    {
      return bool2;
      boolean bool3 = this.b.b();
      bool2 = false;
      if (bool3)
      {
        Object localObject = this.c.b();
        bool2 = false;
        if (localObject != null)
          bool2 = true;
      }
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    this.e = this.d.a();
    this.a.b();
    return Futures.a(new BackgroundResult(true));
  }

  public long h()
  {
    if ((this.b.b()) && (this.c.b() != null));
    for (long l = 600000L + this.d.a(); ; l = -1L)
      return l;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkPreloadBackgroundTask
 * JD-Core Version:    0.6.2
 */