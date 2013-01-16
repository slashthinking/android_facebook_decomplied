package com.facebook.orca.images;

import com.facebook.orca.common.async.KeyedExecutor;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$FetchImageExecutorProvider extends AbstractProvider<FetchImageExecutor>
{
  private ImageModule$FetchImageExecutorProvider(ImageModule paramImageModule)
  {
  }

  public FetchImageExecutor a()
  {
    return new FetchImageExecutor((ImageCache)b(ImageCache.class), (KeyedExecutor)b(KeyedExecutor.class), (FetchImageHelper)b(FetchImageHelper.class), (FetchImageDecodingExecutor)b(FetchImageDecodingExecutor.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.FetchImageExecutorProvider
 * JD-Core Version:    0.6.2
 */