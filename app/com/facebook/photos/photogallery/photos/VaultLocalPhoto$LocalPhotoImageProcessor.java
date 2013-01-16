package com.facebook.photos.photogallery.photos;

import android.graphics.Bitmap;
import com.facebook.orca.images.UrlImageProcessor;
import com.facebook.photos.photogallery.Photo.PhotoSize;

class VaultLocalPhoto$LocalPhotoImageProcessor extends UrlImageProcessor
{
  private final String b;

  public VaultLocalPhoto$LocalPhotoImageProcessor(int paramInt, Photo.PhotoSize paramPhotoSize)
  {
    this.b = (":" + paramInt + ":" + paramPhotoSize);
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    return paramBitmap;
  }

  public String a()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photos.VaultLocalPhoto.LocalPhotoImageProcessor
 * JD-Core Version:    0.6.0
 */