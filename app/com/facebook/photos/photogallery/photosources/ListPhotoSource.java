package com.facebook.photos.photogallery.photosources;

import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.PhotoSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListPhotoSource
  implements PhotoSource
{
  private List<Photo> a;
  private Map<Long, Photo> b;

  public ListPhotoSource(List<Photo> paramList)
  {
    this.a = paramList;
    this.b = new HashMap();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Photo localPhoto = (Photo)localIterator.next();
      this.b.put(Long.valueOf(localPhoto.a()), localPhoto);
    }
  }

  public int a()
  {
    return this.a.size();
  }

  public Photo a(int paramInt)
  {
    return (Photo)this.a.get(paramInt);
  }

  public Photo a(long paramLong)
  {
    return (Photo)this.b.get(Long.valueOf(paramLong));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photosources.ListPhotoSource
 * JD-Core Version:    0.6.0
 */