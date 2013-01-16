package com.facebook.bookmark.client;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.BookmarkManager.BookmarkCallback;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.ipc.BookmarkIpcConstants;
import com.facebook.bookmark.ipc.BookmarkTable.Columns;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.db.Table.Column;
import com.facebook.common.util.Log;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookmarkClient extends BroadcastReceiver
  implements BookmarkManager
{
  private static final Class<BookmarkClient> a = BookmarkClient.class;
  private final Application b;
  private final OrcaServiceOperationFactory c;
  private List<BookmarksGroup> d = Lists.a();
  private Map<Long, Bookmark> e = Maps.a();
  private long f = -1L;
  private int g = 0;
  private AtomicBoolean h = new AtomicBoolean(false);
  private final Handler i;
  private final Set<BookmarkManager.BookmarkCallback> j;
  private final boolean k;

  public BookmarkClient(Application paramApplication, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, boolean paramBoolean)
  {
    this.b = paramApplication;
    this.k = paramBoolean;
    this.j = Sets.a();
    this.c = paramOrcaServiceOperationFactory;
    this.i = new Handler(this.b.getMainLooper());
    IntentFilter localIntentFilter = new IntentFilter(BookmarkIpcConstants.f);
    while (true)
    {
      try
      {
        localIntentFilter.addDataType("vnd.android.cursor.item/vnd.facebook.katana.bookmark");
        localIntentFilter.addDataType("vnd.android.cursor.item/vnd.facebook.katana.favorites");
        localIntentFilter.addDataType("vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count");
        if (this.k)
        {
          LocalBroadcastManager.a(this.b).a(this, localIntentFilter);
          return;
        }
      }
      catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
      {
        throw new RuntimeException(localMalformedMimeTypeException);
      }
      this.b.registerReceiver(this, localIntentFilter, "com.facebook.bookmark.broadcast.access", this.i);
    }
  }

  private void a(Intent paramIntent)
  {
    BookmarksGroup localBookmarksGroup = (BookmarksGroup)paramIntent.getParcelableExtra("bookmark_new_favorites");
    if (localBookmarksGroup == null)
    {
      Log.a(a, "Invalid favorites bookmarks broadcast!");
      return;
    }
    for (int m = 0; ; m++)
      if (m < this.d.size())
      {
        if (Objects.equal(((BookmarksGroup)this.d.get(m)).id, localBookmarksGroup.id))
          this.d.set(m, localBookmarksGroup);
      }
      else
      {
        a(localBookmarksGroup);
        break;
      }
  }

  private void a(FetchBookmarksResult paramFetchBookmarksResult)
  {
    if (paramFetchBookmarksResult.a() == null)
      a(new FetchBookmarksResult(paramFetchBookmarksResult.e(), paramFetchBookmarksResult.f(), ImmutableList.a(this.d)), false);
    while (true)
    {
      return;
      if (!BookmarksGroup.a(this.d, paramFetchBookmarksResult.a()))
      {
        this.d = Lists.a(paramFetchBookmarksResult.a());
        this.e.clear();
        Iterator localIterator1 = this.d.iterator();
        while (localIterator1.hasNext())
        {
          BookmarksGroup localBookmarksGroup = (BookmarksGroup)localIterator1.next();
          Iterator localIterator2 = localBookmarksGroup.a().iterator();
          while (localIterator2.hasNext())
          {
            Bookmark localBookmark2 = (Bookmark)localIterator2.next();
            this.e.put(Long.valueOf(localBookmark2.id), localBookmark2);
          }
          Iterator localIterator3 = localBookmarksGroup.c().iterator();
          while (localIterator3.hasNext())
          {
            Bookmark localBookmark1 = (Bookmark)localIterator3.next();
            this.e.put(Long.valueOf(localBookmark1.id), localBookmark1);
          }
        }
        a(paramFetchBookmarksResult, true);
      }
      else
      {
        a(paramFetchBookmarksResult, false);
      }
    }
  }

  private void a(FetchBookmarksResult paramFetchBookmarksResult, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      if (localIterator.hasNext())
        ((BookmarkManager.BookmarkCallback)localIterator.next()).a(paramFetchBookmarksResult, paramBoolean);
    }
    finally
    {
    }
  }

  private void a(Bookmark paramBookmark)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      if (localIterator.hasNext())
        ((BookmarkManager.BookmarkCallback)localIterator.next()).a(paramBookmark);
    }
    finally
    {
    }
  }

  private void a(BookmarksGroup paramBookmarksGroup)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      if (localIterator.hasNext())
        ((BookmarkManager.BookmarkCallback)localIterator.next()).a(paramBookmarksGroup);
    }
    finally
    {
    }
  }

  private void a(ServiceException paramServiceException)
  {
    this.i.post(new BookmarkClient.1(this, paramServiceException));
  }

  private void a(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof ServiceException))
    {
      ServiceException localServiceException = (ServiceException)paramThrowable;
      Bundle localBundle = localServiceException.b().j();
      if (localBundle != null)
      {
        Log.a(a, paramString + " Failed " + ", " + localBundle.get("originalExceptionMessage") + ", " + localBundle.get("originalExceptionStack"));
        a(localServiceException);
      }
    }
    while (true)
    {
      return;
      Log.a(a, paramString + " Failed ", paramThrowable);
      break;
      Log.b(a, paramString + " Failed for other reasons.", paramThrowable);
    }
  }

  private void b(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("bookmark_fbid", 0L);
    int m = paramIntent.getIntExtra("bookmark_unread_count", -1);
    if ((l == 0L) || (m == -1))
      Log.a(a, "Bookmark unread count update broadcast has invalid data.");
    while (true)
    {
      return;
      Bookmark localBookmark = (Bookmark)this.e.get(Long.valueOf(l));
      if (localBookmark == null)
      {
        Log.a(a, "Bookmark unread count update broadcast has invalid bookmark fbid: " + l);
      }
      else if (localBookmark.a() != m)
      {
        localBookmark.a(m);
        a(localBookmark);
      }
    }
  }

  private void c(Intent paramIntent)
  {
    FetchBookmarksResult localFetchBookmarksResult = (FetchBookmarksResult)paramIntent.getParcelableExtra("bookmark_groups");
    if (localFetchBookmarksResult == null)
      Log.a(a, "Invalid bookmark content broadcast!");
    while (true)
    {
      return;
      this.f = localFetchBookmarksResult.f();
      a(localFetchBookmarksResult);
    }
  }

  public List<BookmarksGroup> a()
  {
    try
    {
      ArrayList localArrayList = Lists.a(this.d);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong(BookmarkTable.Columns.b.a, paramLong);
    localBundle.putInt(BookmarkTable.Columns.h.a, paramInt);
    Futures.a(this.c.a("updateUnreadCount", localBundle).e(), new BookmarkClient.4(this));
  }

  public void a(BookmarkManager.BookmarkCallback paramBookmarkCallback)
  {
    try
    {
      this.j.add(Preconditions.checkNotNull(paramBookmarkCallback));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(List<Long> paramList)
  {
    List localList = Lists.a(paramList, new BookmarkClient.5(this));
    Iterator localIterator = this.d.iterator();
    BookmarksGroup localBookmarksGroup2;
    do
    {
      if (!localIterator.hasNext())
        break;
      localBookmarksGroup2 = (BookmarksGroup)localIterator.next();
    }
    while (!"pinned".equals(localBookmarksGroup2.id));
    for (BookmarksGroup localBookmarksGroup1 = new BookmarksGroup(localBookmarksGroup2.id, localBookmarksGroup2.name, localList.size(), localList); ; localBookmarksGroup1 = null)
    {
      if (localBookmarksGroup1 == null)
        throw new IllegalArgumentException("The favorite bookmark group was not found in BookmarkManager.");
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("newFavoriteBookmarksGroup", localBookmarksGroup1);
      this.c.a("setFavoriteBookmarks", localBundle).e();
      return;
    }
  }

  public void b()
  {
    if (this.h.getAndSet(true));
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      Futures.a(this.c.a("syncWithDB", localBundle).e(), new BookmarkClient.2(this));
    }
  }

  public void b(BookmarkManager.BookmarkCallback paramBookmarkCallback)
  {
    try
    {
      this.j.remove(paramBookmarkCallback);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public FetchBookmarksResult c()
  {
    return new FetchBookmarksResult(e(), this.f, ImmutableList.a(this.d));
  }

  public void d()
  {
    if (this.h.getAndSet(true));
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      Futures.a(this.c.a("syncWithServer", localBundle).e(), new BookmarkClient.3(this));
    }
  }

  public DataFreshnessResult e()
  {
    try
    {
      DataFreshnessResult localDataFreshnessResult;
      if (this.d.isEmpty())
        localDataFreshnessResult = DataFreshnessResult.NO_DATA;
      while (true)
      {
        return localDataFreshnessResult;
        if ((this.f == -1L) || (this.f + this.g < System.currentTimeMillis()))
          localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
        else
          localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
      }
    }
    finally
    {
    }
  }

  public void f()
  {
    try
    {
      this.d.clear();
      this.e.clear();
      this.g = 0;
      this.f = -1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    while (true)
    {
      String str;
      try
      {
        str = paramIntent.getType();
        if ("vnd.android.cursor.item/vnd.facebook.katana.bookmark".equals(str))
        {
          c(paramIntent);
          return;
        }
        if ("vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count".equals(str))
        {
          b(paramIntent);
          continue;
        }
      }
      finally
      {
      }
      if ("vnd.android.cursor.item/vnd.facebook.katana.favorites".equals(str))
        a(paramIntent);
      else
        Log.a(a, "unexpected broadcast type: " + str);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClient
 * JD-Core Version:    0.6.2
 */