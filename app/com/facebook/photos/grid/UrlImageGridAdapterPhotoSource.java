package com.facebook.photos.grid;

import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.PhotoSource;

public class UrlImageGridAdapterPhotoSource
  implements PhotoSource
{
  private UrlImageGridAdapter a;

  public UrlImageGridAdapterPhotoSource(UrlImageGridAdapter paramUrlImageGridAdapter)
  {
    this.a = paramUrlImageGridAdapter;
  }

  public int a()
  {
    return this.a.getCount();
  }

  public Photo a(int paramInt)
  {
    return (Photo)this.a.getItem(paramInt);
  }

  public Photo a(long paramLong)
  {
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.grid.UrlImageGridAdapterPhotoSource
 * JD-Core Version:    0.6.0
 */