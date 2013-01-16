package com.facebook.photos.photogallery.tags;

import com.facebook.photos.photogallery.Photo;
import java.util.List;

public abstract class TaggedPhoto extends Photo
{
  private List<Tag> a;

  public TaggedPhoto()
  {
  }

  public TaggedPhoto(long paramLong, List<Tag> paramList)
  {
    super(paramLong);
    this.a = paramList;
  }

  public void a(List<Tag> paramList)
  {
    this.a = paramList;
  }

  public List<Tag> i()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggedPhoto
 * JD-Core Version:    0.6.0
 */