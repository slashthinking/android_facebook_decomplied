package com.facebook.katana.activity.media;

import com.facebook.katana.model.PhotoItem;
import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.PhotoSource;

public class ForwardingGridAdapterPhotoSource
  implements PhotoSource
{
  private ForwardingGridAdapter a;

  public ForwardingGridAdapterPhotoSource(ForwardingGridAdapter paramForwardingGridAdapter)
  {
    this.a = paramForwardingGridAdapter;
  }

  public int a()
  {
    return this.a.getCount();
  }

  public Photo a(int paramInt)
  {
    return ((PhotoItem)this.a.getItem(paramInt)).l();
  }

  public Photo a(long paramLong)
  {
    return ((PhotoItem)this.a.a(paramLong)).l();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ForwardingGridAdapterPhotoSource
 * JD-Core Version:    0.6.0
 */