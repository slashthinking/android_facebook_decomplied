package com.facebook.photos.photogallery.photogalleries.production;

import android.support.v4.app.FragmentManager;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.LaunchableGalleryFragmentFactory;
import com.facebook.photos.photogallery.PhotoSource;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragmentFactory;

public class ProductionPhotoGalleryFragmentFactory
  implements LaunchableGalleryFragmentFactory
{
  private PhotoSource a;
  private FragmentManager b;
  private ProductionPhotoDataAdapter c;

  public ProductionPhotoGalleryFragmentFactory(PhotoSource paramPhotoSource, FragmentManager paramFragmentManager, ProductionPhotoDataAdapter paramProductionPhotoDataAdapter)
  {
    this.a = paramPhotoSource;
    this.b = paramFragmentManager;
    this.c = paramProductionPhotoDataAdapter;
  }

  public LaunchableGalleryFragment a(int paramInt)
  {
    ProductionPhotoGalleryFragment localProductionPhotoGalleryFragment = new ProductionPhotoGalleryFragment();
    localProductionPhotoGalleryFragment.a(paramInt, this.a, new TaggedPhotoFragmentFactory(), this.b, this.c);
    return localProductionPhotoGalleryFragment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.production.ProductionPhotoGalleryFragmentFactory
 * JD-Core Version:    0.6.0
 */