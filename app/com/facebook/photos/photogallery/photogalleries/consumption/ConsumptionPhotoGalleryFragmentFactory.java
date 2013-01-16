package com.facebook.photos.photogallery.photogalleries.consumption;

import android.support.v4.app.FragmentManager;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.LaunchableGalleryFragmentFactory;
import com.facebook.photos.photogallery.PhotoSource;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragmentFactory;

public class ConsumptionPhotoGalleryFragmentFactory
  implements LaunchableGalleryFragmentFactory
{
  private PhotoSource a;
  private FragmentManager b;
  private ConsumptionPhotoDataAdapter c;

  public ConsumptionPhotoGalleryFragmentFactory(PhotoSource paramPhotoSource, FragmentManager paramFragmentManager, ConsumptionPhotoDataAdapter paramConsumptionPhotoDataAdapter)
  {
    this.a = paramPhotoSource;
    this.b = paramFragmentManager;
    this.c = paramConsumptionPhotoDataAdapter;
  }

  public LaunchableGalleryFragment a(int paramInt)
  {
    ConsumptionPhotoGalleryFragment localConsumptionPhotoGalleryFragment = new ConsumptionPhotoGalleryFragment();
    localConsumptionPhotoGalleryFragment.a(paramInt, this.a, new TaggedPhotoFragmentFactory(), this.b, this.c);
    return localConsumptionPhotoGalleryFragment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoGalleryFragmentFactory
 * JD-Core Version:    0.6.0
 */