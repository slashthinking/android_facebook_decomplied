package com.facebook.orca.images;

import android.graphics.Bitmap;
import com.facebook.concurrent.NamedThreadFactory;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;

public class FetchImageDecodingExecutor
{
  private final Class<?> a = FetchImageDecodingExecutor.class;
  private final FetchImageHelper b;
  private final ListeningExecutorService c;
  private final ConcurrentMap<ImageCacheKey, ListenableFuture<Bitmap>> d = new MapMaker().h().n();
  private final Object e = new Object();

  public FetchImageDecodingExecutor(FetchImageHelper paramFetchImageHelper)
  {
    this.b = paramFetchImageHelper;
    this.c = MoreExecutors.a(Executors.newFixedThreadPool(2, new NamedThreadFactory("image-decoding-")));
  }

  public ListenableFuture<Bitmap> a(FetchImageParams paramFetchImageParams)
  {
    ImageCacheKey localImageCacheKey = paramFetchImageParams.d();
    Object localObject1 = this.e;
    ListenableFuture localListenableFuture = null;
    if (localImageCacheKey != null);
    try
    {
      localListenableFuture = (ListenableFuture)this.d.get(localImageCacheKey);
      if (localListenableFuture == null)
      {
        localListenableFuture = this.c.a(new FetchImageDecodingExecutor.1(this, paramFetchImageParams));
        if (localImageCacheKey != null)
        {
          this.d.put(localImageCacheKey, localListenableFuture);
          Futures.a(localListenableFuture, new FetchImageDecodingExecutor.2(this, localImageCacheKey));
        }
      }
      return localListenableFuture;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageDecodingExecutor
 * JD-Core Version:    0.6.2
 */