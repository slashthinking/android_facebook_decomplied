package com.facebook.uberbar.resolvers;

import android.content.ContentResolver;
import android.database.Cursor;
import com.google.common.base.Function;
import java.util.concurrent.Callable;

class AsyncCursorReaderUtil$1
  implements Callable<T>
{
  AsyncCursorReaderUtil$1(AsyncCursorReaderUtil paramAsyncCursorReaderUtil, DataQuery paramDataQuery, String[] paramArrayOfString, Function paramFunction)
  {
  }

  public T call()
  {
    Cursor localCursor = AsyncCursorReaderUtil.a(this.d).query(this.a.b(), this.a.a(), this.a.c(), this.b, this.a.d());
    if (localCursor == null)
      throw new Exception("Received null cursor");
    try
    {
      Object localObject2 = this.c.apply(localCursor);
      return localObject2;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.resolvers.AsyncCursorReaderUtil.1
 * JD-Core Version:    0.6.2
 */