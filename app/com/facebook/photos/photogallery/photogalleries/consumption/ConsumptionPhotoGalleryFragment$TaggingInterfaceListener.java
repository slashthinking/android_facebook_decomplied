package com.facebook.photos.photogallery.photogalleries.consumption;

import com.facebook.photos.photogallery.tags.Tag;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragment;
import com.facebook.photos.photogallery.tags.TaggingInterface.TaggingInterfaceListener;
import java.util.List;

class ConsumptionPhotoGalleryFragment$TaggingInterfaceListener
  implements TaggingInterface.TaggingInterfaceListener
{
  private ConsumptionPhotoGalleryFragment$TaggingInterfaceListener(ConsumptionPhotoGalleryFragment paramConsumptionPhotoGalleryFragment)
  {
  }

  public void a()
  {
    ConsumptionPhotoGalleryFragment.g(this.a);
    ((TaggedPhotoFragment)ConsumptionPhotoGalleryFragment.h(this.a)).c();
  }

  public void a(Tag paramTag)
  {
    ((ConsumptionPhoto)ConsumptionPhotoGalleryFragment.i(this.a)).i().add(paramTag);
    ((TaggedPhotoFragment)ConsumptionPhotoGalleryFragment.j(this.a)).K();
    ConsumptionPhotoGalleryFragment.k(this.a);
    ConsumptionPhotoGalleryFragment.m(this.a).a(((ConsumptionPhoto)ConsumptionPhotoGalleryFragment.l(this.a)).a(), paramTag);
  }

  public void b()
  {
    ConsumptionPhotoGalleryFragment.n(this.a);
    ((TaggedPhotoFragment)ConsumptionPhotoGalleryFragment.o(this.a)).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoGalleryFragment.TaggingInterfaceListener
 * JD-Core Version:    0.6.0
 */