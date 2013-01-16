package com.facebook.photos.photogallery.photogalleries.consumption;

import android.graphics.PointF;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragment.TaggedPhotoFragmentListener;
import com.facebook.photos.photogallery.tags.TaggingInterface;

class ConsumptionPhotoGalleryFragment$2
  implements TaggedPhotoFragment.TaggedPhotoFragmentListener
{
  public void a(PointF paramPointF, boolean paramBoolean)
  {
    if (ConsumptionPhotoGalleryFragment.b(this.a))
      if (paramBoolean)
        ConsumptionPhotoGalleryFragment.c(this.a).a(paramPointF);
    while (true)
    {
      return;
      if (ConsumptionPhotoGalleryFragment.d(this.a))
      {
        ConsumptionPhotoGalleryFragment.e(this.a);
        continue;
      }
      ConsumptionPhotoGalleryFragment.f(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoGalleryFragment.2
 * JD-Core Version:    0.6.0
 */