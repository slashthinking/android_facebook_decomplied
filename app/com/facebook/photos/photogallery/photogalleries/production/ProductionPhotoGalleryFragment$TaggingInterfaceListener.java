package com.facebook.photos.photogallery.photogalleries.production;

import com.facebook.photos.photogallery.photos.LocalPhoto;
import com.facebook.photos.photogallery.tags.Tag;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragment;
import com.facebook.photos.photogallery.tags.TaggingInterface.TaggingInterfaceListener;
import java.util.List;

class ProductionPhotoGalleryFragment$TaggingInterfaceListener
  implements TaggingInterface.TaggingInterfaceListener
{
  private ProductionPhotoGalleryFragment$TaggingInterfaceListener(ProductionPhotoGalleryFragment paramProductionPhotoGalleryFragment)
  {
  }

  public void a()
  {
    ProductionPhotoGalleryFragment.c(this.a);
    ((TaggedPhotoFragment)ProductionPhotoGalleryFragment.d(this.a)).c();
  }

  public void a(Tag paramTag)
  {
    ((LocalPhoto)ProductionPhotoGalleryFragment.e(this.a)).i().add(paramTag);
    ((TaggedPhotoFragment)ProductionPhotoGalleryFragment.f(this.a)).K();
    ProductionPhotoGalleryFragment.h(this.a).a(((LocalPhoto)ProductionPhotoGalleryFragment.g(this.a)).a(), paramTag);
  }

  public void b()
  {
    ProductionPhotoGalleryFragment.i(this.a);
    ((TaggedPhotoFragment)ProductionPhotoGalleryFragment.j(this.a)).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.production.ProductionPhotoGalleryFragment.TaggingInterfaceListener
 * JD-Core Version:    0.6.0
 */