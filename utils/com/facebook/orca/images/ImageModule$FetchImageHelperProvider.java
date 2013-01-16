package com.facebook.orca.images;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$FetchImageHelperProvider extends AbstractProvider<FetchImageHelper>
{
  private ImageModule$FetchImageHelperProvider(ImageModule paramImageModule)
  {
  }

  public FetchImageHelper a()
  {
    return new FetchImageHelper((ImageCache)b(ImageCache.class), (ImageMediaDownloader)b(ImageMediaDownloader.class), (AnalyticsLogger)b(AnalyticsLogger.class), a(String.class, MeUserId.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.FetchImageHelperProvider
 * JD-Core Version:    0.6.2
 */