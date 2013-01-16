package com.facebook.orca.images;

import com.facebook.orca.inject.AbstractProvider;

class ImageModule$FetchImageDecodingExecutorProvider extends AbstractProvider<FetchImageDecodingExecutor>
{
  private ImageModule$FetchImageDecodingExecutorProvider(ImageModule paramImageModule)
  {
  }

  public FetchImageDecodingExecutor a()
  {
    return new FetchImageDecodingExecutor((FetchImageHelper)b(FetchImageHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.FetchImageDecodingExecutorProvider
 * JD-Core Version:    0.6.2
 */