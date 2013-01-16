package com.facebook.uberbar.resolvers;

import android.content.ContentResolver;
import android.database.Cursor;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;

public class AsyncCursorReaderUtil<T>
{
  private final ContentResolver a;
  private final AndroidThreadUtil b;

  public AsyncCursorReaderUtil(ContentResolver paramContentResolver, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.a = paramContentResolver;
    this.b = paramAndroidThreadUtil;
  }

  public ListenableFuture<T> a(DataQuery paramDataQuery, String[] paramArrayOfString, Function<Cursor, T> paramFunction)
  {
    return this.b.a(new AsyncCursorReaderUtil.1(this, paramDataQuery, paramArrayOfString, paramFunction));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.resolvers.AsyncCursorReaderUtil
 * JD-Core Version:    0.6.2
 */