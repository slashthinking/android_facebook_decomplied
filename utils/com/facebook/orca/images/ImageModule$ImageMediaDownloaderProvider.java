package com.facebook.orca.images;

import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$ImageMediaDownloaderProvider extends AbstractProvider<ImageMediaDownloader>
{
  private ImageModule$ImageMediaDownloaderProvider(ImageModule paramImageModule)
  {
  }

  public ImageMediaDownloader a()
  {
    return new ImageMediaDownloader(ImageModule.a(this.a), (OrcaHttpRequestProcessor)b(OrcaHttpRequestProcessor.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.ImageMediaDownloaderProvider
 * JD-Core Version:    0.6.2
 */