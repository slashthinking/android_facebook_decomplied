package com.facebook.photos.photogallery.tags;

import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.PhotoFragment;
import com.facebook.photos.photogallery.PhotoFragmentFactory;

public class TaggedPhotoFragmentFactory extends PhotoFragmentFactory
{
  public PhotoFragment a(Photo paramPhoto)
  {
    return new TaggedPhotoFragment((TaggedPhoto)paramPhoto);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggedPhotoFragmentFactory
 * JD-Core Version:    0.6.0
 */