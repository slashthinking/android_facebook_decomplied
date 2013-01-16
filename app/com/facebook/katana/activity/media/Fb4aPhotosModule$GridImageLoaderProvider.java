package com.facebook.katana.activity.media;

import com.facebook.orca.images.ImageCache;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aPhotosModule$GridImageLoaderProvider extends AbstractProvider<GridImageLoader>
{
  private Fb4aPhotosModule$GridImageLoaderProvider(Fb4aPhotosModule paramFb4aPhotosModule)
  {
  }

  public GridImageLoader a()
  {
    return new GridImageLoader(Fb4aPhotosModule.a(this.a), (AndroidMediaThumbnails)b(AndroidMediaThumbnails.class), (ImageCache)b(ImageCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aPhotosModule.GridImageLoaderProvider
 * JD-Core Version:    0.6.0
 */