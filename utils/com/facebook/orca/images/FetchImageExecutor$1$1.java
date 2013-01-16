package com.facebook.orca.images;

import android.graphics.Bitmap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;

class FetchImageExecutor$1$1
  implements FutureCallback<Bitmap>
{
  FetchImageExecutor$1$1(FetchImageExecutor.1 param1)
  {
  }

  public void a(Bitmap paramBitmap)
  {
    this.a.a.a_(paramBitmap);
  }

  public void a(Throwable paramThrowable)
  {
    this.a.a.a_(paramThrowable);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageExecutor.1.1
 * JD-Core Version:    0.6.2
 */