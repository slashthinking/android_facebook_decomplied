package com.facebook.katana.activity.media;

import com.facebook.orca.inject.AbstractProvider;

class Fb4aPhotosModule$ImageGridPhotoManagerProvider extends AbstractProvider<ImageGridPhotoManager>
{
  private Fb4aPhotosModule$ImageGridPhotoManagerProvider(Fb4aPhotosModule paramFb4aPhotosModule)
  {
  }

  public ImageGridPhotoManager a()
  {
    return new ImageGridPhotoManager(Fb4aPhotosModule.a(this.a), (GridImageLoader)b(GridImageLoader.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aPhotosModule.ImageGridPhotoManagerProvider
 * JD-Core Version:    0.6.0
 */