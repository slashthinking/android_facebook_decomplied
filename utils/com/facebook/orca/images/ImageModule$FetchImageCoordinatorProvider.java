package com.facebook.orca.images;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$FetchImageCoordinatorProvider extends AbstractProvider<FetchImageCoordinator>
{
  private ImageModule$FetchImageCoordinatorProvider(ImageModule paramImageModule)
  {
  }

  public FetchImageCoordinator a()
  {
    return new FetchImageCoordinator((AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.FetchImageCoordinatorProvider
 * JD-Core Version:    0.6.2
 */