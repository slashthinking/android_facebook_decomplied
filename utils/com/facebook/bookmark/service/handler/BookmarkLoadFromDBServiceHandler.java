package com.facebook.bookmark.service.handler;

import android.os.Bundle;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.common.util.Log;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class BookmarkLoadFromDBServiceHandler
  implements OrcaServiceHandler.Filter
{
  private final DBBookmarkHelper a;
  private final int b;

  public BookmarkLoadFromDBServiceHandler(DBBookmarkHelper paramDBBookmarkHelper, int paramInt)
  {
    this.a = ((DBBookmarkHelper)Preconditions.checkNotNull(paramDBBookmarkHelper));
    if (paramInt <= 0)
      throw new IllegalArgumentException("ExpireTime should be positive");
    this.b = paramInt;
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    long l = this.a.b();
    OperationResult localOperationResult;
    DataFreshnessResult localDataFreshnessResult;
    if (l + this.b < System.currentTimeMillis())
      try
      {
        localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
        if (localOperationResult.c())
        {
          localOperationResult.j().putInt("bookmarks_expire_time", this.b);
          return localOperationResult;
        }
      }
      catch (Exception localException)
      {
        Log.a(BookmarkLoadFromDBServiceHandler.class, "Fail to fetch bookmarks from server while data in db was expired.", localException);
        localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
      }
    while (true)
    {
      localOperationResult = OperationResult.a(new FetchBookmarksResult(localDataFreshnessResult, l, ImmutableList.a(this.a.c())));
      localOperationResult.j().putInt("bookmarks_expire_time", this.b);
      break;
      localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.handler.BookmarkLoadFromDBServiceHandler
 * JD-Core Version:    0.6.2
 */