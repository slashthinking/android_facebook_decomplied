package com.facebook.orca.images;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.orca.common.async.KeyedExecutor;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

public class FetchImageExecutor
{
  private final Class<?> a = FetchImageExecutor.class;
  private final ImageCache b;
  private final KeyedExecutor c;
  private final FetchImageHelper d;
  private final FetchImageDecodingExecutor e;

  public FetchImageExecutor(ImageCache paramImageCache, KeyedExecutor paramKeyedExecutor, FetchImageHelper paramFetchImageHelper, FetchImageDecodingExecutor paramFetchImageDecodingExecutor)
  {
    this.b = paramImageCache;
    this.c = paramKeyedExecutor;
    this.d = paramFetchImageHelper;
    this.e = paramFetchImageDecodingExecutor;
  }

  private int a(Uri paramUri, int paramInt)
  {
    return Math.abs(paramUri.hashCode() % paramInt);
  }

  private ListenableFuture<Bitmap> c(FetchImageParams paramFetchImageParams)
  {
    ImageCacheKey localImageCacheKey1 = paramFetchImageParams.d();
    ListenableFuture localListenableFuture = this.c.a(localImageCacheKey1);
    FetchImageExecutor.2 local2;
    String str1;
    if (localListenableFuture == null)
    {
      UrlImageProcessor localUrlImageProcessor = paramFetchImageParams.b();
      int i = 0;
      if (localUrlImageProcessor != null)
      {
        ImageCacheKey localImageCacheKey2 = paramFetchImageParams.e();
        boolean bool = this.b.c(localImageCacheKey2);
        i = 0;
        if (bool)
          i = 1;
      }
      local2 = new FetchImageExecutor.2(this, paramFetchImageParams);
      if (i == 0)
        break label106;
      str1 = "fetch-image-task-processing";
    }
    while (true)
    {
      String str2 = paramFetchImageParams.a().toString();
      localListenableFuture = this.c.a(str1, localImageCacheKey1, local2, str2);
      return localListenableFuture;
      label106: Uri localUri = paramFetchImageParams.a();
      if (localUri.getAuthority().startsWith("api."))
      {
        int k = a(localUri, 3);
        str1 = "fetch-image-api-" + k;
      }
      else
      {
        int j = a(localUri, 3);
        str1 = "fetch-image-other-" + j;
      }
    }
  }

  public Bitmap a(FetchImageParams paramFetchImageParams)
  {
    return this.d.b(paramFetchImageParams);
  }

  public ListenableFuture<Bitmap> b(FetchImageParams paramFetchImageParams)
  {
    ImageCacheKey localImageCacheKey = paramFetchImageParams.d();
    Object localObject;
    if (localImageCacheKey != null)
      if (this.b.f(localImageCacheKey))
        localObject = Futures.a(new Exception("Cached image failure"));
    while (true)
    {
      return localObject;
      Bitmap localBitmap = (Bitmap)this.b.b(localImageCacheKey);
      if (localBitmap != null)
      {
        localObject = Futures.a(localBitmap);
      }
      else
      {
        localObject = SettableFuture.c();
        Futures.a(this.e.a(paramFetchImageParams), new FetchImageExecutor.1(this, (SettableFuture)localObject, paramFetchImageParams), MoreExecutors.a());
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageExecutor
 * JD-Core Version:    0.6.2
 */