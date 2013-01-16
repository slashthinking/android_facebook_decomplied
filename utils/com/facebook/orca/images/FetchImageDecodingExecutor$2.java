package com.facebook.orca.images;

import android.graphics.Bitmap;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.ConcurrentMap;

class FetchImageDecodingExecutor$2
  implements FutureCallback<Bitmap>
{
  FetchImageDecodingExecutor$2(FetchImageDecodingExecutor paramFetchImageDecodingExecutor, ImageCacheKey paramImageCacheKey)
  {
  }

  public void a(Bitmap paramBitmap)
  {
    synchronized (FetchImageDecodingExecutor.b(this.b))
    {
      FetchImageDecodingExecutor.c(this.b).remove(this.a);
      return;
    }
  }

  public void a(Throwable paramThrowable)
  {
    synchronized (FetchImageDecodingExecutor.b(this.b))
    {
      FetchImageDecodingExecutor.c(this.b).remove(this.a);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageDecodingExecutor.2
 * JD-Core Version:    0.6.2
 */