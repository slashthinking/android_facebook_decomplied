package com.facebook.photos.photogallery.photosources;

import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.PhotoSource;

public class SinglePhotoSource
  implements PhotoSource
{
  private Photo a;

  public SinglePhotoSource(Photo paramPhoto)
  {
    this.a = paramPhoto;
  }

  public int a()
  {
    return 1;
  }

  public Photo a(int paramInt)
  {
    return this.a;
  }

  public Photo a(long paramLong)
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photosources.SinglePhotoSource
 * JD-Core Version:    0.6.0
 */