package com.facebook.photos.photogallery.photos;

import android.net.Uri;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.OptionsBuilder;
import com.facebook.photos.photogallery.Photo.PhotoSize;

public class VaultLocalPhoto extends VaultPhoto
{
  private String a;
  private int b;
  private String c;
  private long d;

  public VaultLocalPhoto(long paramLong1, String paramString1, int paramInt, long paramLong2, String paramString2)
  {
    a(paramLong1);
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramLong2;
  }

  public FetchImageParams a(Photo.PhotoSize paramPhotoSize)
  {
    FetchImageParams localFetchImageParams;
    if (this.a == null)
    {
      localFetchImageParams = null;
      return localFetchImageParams;
    }
    ImageCacheKey.OptionsBuilder localOptionsBuilder = ImageCacheKey.Options.newBuilder();
    switch (VaultLocalPhoto.1.a[paramPhotoSize.ordinal()])
    {
    default:
      throw new IllegalArgumentException("unknown size: " + paramPhotoSize);
    case 1:
      localOptionsBuilder.a(true);
    case 2:
    }
    for (VaultLocalPhoto.LocalPhotoImageProcessor localLocalPhotoImageProcessor = new VaultLocalPhoto.LocalPhotoImageProcessor(this.b, Photo.PhotoSize.SCREENNAIL); ; localLocalPhotoImageProcessor = new VaultLocalPhoto.LocalPhotoImageProcessor(this.b, Photo.PhotoSize.THUMBNAIL))
    {
      ImageCacheKey.Options localOptions = localOptionsBuilder.d();
      localFetchImageParams = new FetchImageParams(Uri.parse("file://" + this.a), localLocalPhotoImageProcessor, localOptions);
      break;
      localOptionsBuilder.a(240, 240);
    }
  }

  public String b()
  {
    return this.c;
  }

  public long c()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photos.VaultLocalPhoto
 * JD-Core Version:    0.6.0
 */