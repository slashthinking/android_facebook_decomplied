package com.facebook.photos.photogallery;

import com.facebook.orca.images.FetchImageParams;

public abstract class Photo
{
  private long a;

  public Photo()
  {
  }

  public Photo(long paramLong)
  {
    this.a = paramLong;
  }

  public long a()
  {
    return this.a;
  }

  public abstract FetchImageParams a(Photo.PhotoSize paramPhotoSize);

  public void a(long paramLong)
  {
    this.a = paramLong;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.Photo
 * JD-Core Version:    0.6.0
 */