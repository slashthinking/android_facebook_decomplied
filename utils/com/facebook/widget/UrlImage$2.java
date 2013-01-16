package com.facebook.widget;

import android.graphics.Bitmap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

class UrlImage$2
  implements FutureCallback<List<Bitmap>>
{
  UrlImage$2(UrlImage paramUrlImage, ListenableFuture paramListenableFuture)
  {
  }

  public void a(Throwable paramThrowable)
  {
    UrlImage.a(this.b, paramThrowable);
  }

  public void a(List<Bitmap> paramList)
  {
    if (UrlImage.a(this.b) == this.a)
      UrlImage.a(this.b, paramList);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.UrlImage.2
 * JD-Core Version:    0.6.2
 */