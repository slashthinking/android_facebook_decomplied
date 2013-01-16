package com.facebook.orca.images;

import android.content.Context;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.media.MediaDownloader;

public class ImageMediaDownloader extends MediaDownloader
{
  private static final Class<?> a = ImageMediaDownloader.class;

  public ImageMediaDownloader(Context paramContext, OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor)
  {
    super(paramContext, paramOrcaHttpRequestProcessor, "image");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageMediaDownloader
 * JD-Core Version:    0.6.2
 */