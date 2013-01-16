package com.facebook.orca.images;

import android.app.ActivityManager;
import android.content.Context;
import com.facebook.common.util.DiskUsageUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.attachments.ImageAttachmentDecoder;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class ImageModule$ImageCacheProvider extends AbstractProvider<ImageCache>
{
  private ImageModule$ImageCacheProvider(ImageModule paramImageModule)
  {
  }

  public ImageCache a()
  {
    ActivityManager localActivityManager = (ActivityManager)b(ActivityManager.class, FromApplication.class);
    return new ImageCache((Context)b(Context.class, FromApplication.class), (MediaAttachmentFactory)b(MediaAttachmentFactory.class), (ImageAttachmentDecoder)b(ImageAttachmentDecoder.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (Clock)b(Clock.class), (DiskUsageUtil)b(DiskUsageUtil.class), localActivityManager.getMemoryClass());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.ImageCacheProvider
 * JD-Core Version:    0.6.2
 */