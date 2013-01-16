package com.facebook.orca.images;

import android.graphics.Bitmap;
import com.facebook.orca.debug.Tracer;
import java.util.concurrent.Callable;

class FetchImageDecodingExecutor$1
  implements Callable<Bitmap>
{
  FetchImageDecodingExecutor$1(FetchImageDecodingExecutor paramFetchImageDecodingExecutor, FetchImageParams paramFetchImageParams)
  {
  }

  public Bitmap a()
  {
    Tracer.b(10L);
    Bitmap localBitmap = FetchImageDecodingExecutor.a(this.b).a(this.a);
    Tracer.b("ImageDecodingExecutor");
    return localBitmap;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageDecodingExecutor.1
 * JD-Core Version:    0.6.2
 */