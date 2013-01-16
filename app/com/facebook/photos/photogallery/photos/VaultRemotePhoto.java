package com.facebook.photos.photogallery.photos;

import android.net.Uri;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.OptionsBuilder;
import com.facebook.photos.photogallery.Photo.PhotoSize;

public class VaultRemotePhoto extends VaultPhoto
{
  private String a;
  private long b;

  public VaultRemotePhoto()
  {
  }

  public VaultRemotePhoto(long paramLong1, String paramString, long paramLong2)
  {
    a(paramLong1);
    this.a = paramString;
    this.b = paramLong2;
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
    switch (VaultRemotePhoto.1.a[paramPhotoSize.ordinal()])
    {
    default:
      throw new IllegalArgumentException("unknown size: " + paramPhotoSize);
    case 1:
      localOptionsBuilder.a(true);
    case 2:
    }
    for (VaultRemotePhoto.RemotePhotoImageProcessor localRemotePhotoImageProcessor = new VaultRemotePhoto.RemotePhotoImageProcessor(Photo.PhotoSize.SCREENNAIL); ; localRemotePhotoImageProcessor = new VaultRemotePhoto.RemotePhotoImageProcessor(Photo.PhotoSize.THUMBNAIL))
    {
      ImageCacheKey.Options localOptions = localOptionsBuilder.d();
      localFetchImageParams = new FetchImageParams(Uri.parse(this.a), localRemotePhotoImageProcessor, localOptions);
      break;
      localOptionsBuilder.a(240, 240);
    }
  }

  public long c()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photos.VaultRemotePhoto
 * JD-Core Version:    0.6.0
 */