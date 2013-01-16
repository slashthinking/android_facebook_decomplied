package com.facebook.orca.images;

import android.net.Uri;
import com.facebook.orca.media.MediaCacheKey;
import com.google.common.base.Preconditions;

public class ImageCacheKey extends MediaCacheKey
{
  public static final ImageCacheKey.Options a = ImageCacheKey.Options.newBuilder().a(true).d();
  public static final ImageCacheKey.Options b = ImageCacheKey.Options.newBuilder().a(64, 64).d();
  public static final ImageCacheKey.Options c = ImageCacheKey.Options.newBuilder().a(false).d();
  private final Uri d;
  private final String e;
  private final ImageCacheKey.Options f;
  private volatile String g;

  public ImageCacheKey(Uri paramUri, ImageCacheKey.Options paramOptions)
  {
    this(paramUri, paramOptions, null);
  }

  public ImageCacheKey(Uri paramUri, ImageCacheKey.Options paramOptions, String paramString)
  {
    Preconditions.checkNotNull(paramUri);
    Preconditions.checkNotNull(paramOptions);
    this.d = paramUri;
    this.f = paramOptions;
    this.e = paramString;
  }

  public Uri a()
  {
    return this.d;
  }

  public String b()
  {
    if (this.g == null)
      this.g = (this.d + "____" + this.e);
    return this.g;
  }

  public ImageCacheKey.Options c()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (((paramObject instanceof ImageCacheKey)) && (paramObject != null))
    {
      ImageCacheKey localImageCacheKey = (ImageCacheKey)paramObject;
      if (((this.e == null) && (localImageCacheKey.e == null)) || ((this.e != null) && (localImageCacheKey != null) && (this.e.equals(localImageCacheKey.e))))
      {
        bool2 = bool1;
        if ((!this.d.equals(localImageCacheKey.d)) || (!bool2) || (!this.f.equals(localImageCacheKey.f)))
          break label101;
      }
    }
    while (true)
    {
      return bool1;
      bool2 = false;
      break;
      label101: bool1 = false;
      continue;
      bool1 = false;
    }
  }

  public int hashCode()
  {
    int i = 31 * (31 * this.d.hashCode() + this.f.hashCode());
    if (this.e == null);
    for (int j = 0; ; j = this.e.hashCode())
      return j + i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageCacheKey
 * JD-Core Version:    0.6.2
 */