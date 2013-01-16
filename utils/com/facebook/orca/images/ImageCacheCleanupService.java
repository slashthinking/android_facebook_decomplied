package com.facebook.orca.images;

import android.app.IntentService;
import android.content.Intent;

public class ImageCacheCleanupService extends IntentService
{
  public ImageCacheCleanupService()
  {
    super("orca:ImageCacheCleanupService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageCacheCleanupService
 * JD-Core Version:    0.6.2
 */