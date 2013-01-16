package com.facebook.orca.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.facebook.common.util.DiskUsageUtil;
import com.facebook.orca.attachments.ImageAttachmentDecoder;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.media.MediaCache;
import com.facebook.orca.media.MediaCacheParams;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.google.common.io.Closeables;
import java.io.File;
import java.io.FileOutputStream;

public class ImageCache extends MediaCache<ImageCacheKey, Bitmap>
{
  private final MediaAttachmentFactory a;
  private final ImageAttachmentDecoder b;
  private final OrcaSharedPreferences c;

  public ImageCache(Context paramContext, MediaAttachmentFactory paramMediaAttachmentFactory, ImageAttachmentDecoder paramImageAttachmentDecoder, OrcaSharedPreferences paramOrcaSharedPreferences, Clock paramClock, DiskUsageUtil paramDiskUsageUtil, int paramInt)
  {
    super(paramContext, paramClock, paramDiskUsageUtil, a(paramInt));
    this.a = paramMediaAttachmentFactory;
    this.b = paramImageAttachmentDecoder;
    this.c = paramOrcaSharedPreferences;
  }

  private static MediaCacheParams a(int paramInt)
  {
    int i;
    if (paramInt >= 64)
    {
      i = 16777216;
      if (paramInt < 32)
        break label80;
    }
    label80: for (int j = i - 1048576; ; j = i - 524288)
    {
      return new MediaCacheParams().a("image").b(".image").c(i).d(j).a(500).b(450).a(true);
      if (paramInt >= 32)
      {
        i = 4194304;
        break;
      }
      i = 2097152;
      break;
    }
  }

  private boolean d()
  {
    boolean bool = true;
    if (this.c != null)
      bool = this.c.a(SharedPrefKeys.s, bool);
    return bool;
  }

  protected int a(Bitmap paramBitmap)
  {
    return 4 * (paramBitmap.getWidth() * paramBitmap.getHeight());
  }

  protected Bitmap a(ImageCacheKey paramImageCacheKey, File paramFile)
  {
    int i = paramImageCacheKey.c().b;
    int j = paramImageCacheKey.c().c;
    ImageCacheKey.Options.DownscalingMethod localDownscalingMethod = paramImageCacheKey.c().d;
    MediaResource localMediaResource = MediaResource.a(paramFile);
    MediaAttachment localMediaAttachment = this.a.b(localMediaResource);
    return this.b.a(localMediaAttachment, i, j, d(), localDownscalingMethod);
  }

  protected void a(ImageCacheKey paramImageCacheKey, Bitmap paramBitmap, File paramFile)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      if (paramBitmap.hasAlpha())
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      while (true)
      {
        return;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 95, localFileOutputStream);
      }
    }
    finally
    {
      Closeables.a(localFileOutputStream);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageCache
 * JD-Core Version:    0.6.2
 */