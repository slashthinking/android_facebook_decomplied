package com.facebook.orca.images;

import android.graphics.Bitmap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

class FetchImageExecutor$1
  implements FutureCallback<Bitmap>
{
  FetchImageExecutor$1(FetchImageExecutor paramFetchImageExecutor, SettableFuture paramSettableFuture, FetchImageParams paramFetchImageParams)
  {
  }

  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      this.a.a_(paramBitmap);
    while (true)
    {
      return;
      Futures.a(FetchImageExecutor.a(this.c, this.b), new FetchImageExecutor.1.1(this), MoreExecutors.a());
    }
  }

  public void a(Throwable paramThrowable)
  {
    this.a.a_(paramThrowable);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageExecutor.1
 * JD-Core Version:    0.6.2
 */