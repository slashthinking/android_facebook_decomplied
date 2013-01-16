package com.facebook.katana.view.vault;

import com.facebook.katana.activity.media.MediaPickerGalleryAdapter;
import com.facebook.katana.activity.media.MediaPickerGalleryAdapter.MediaImageLoadedListener;
import com.facebook.katana.activity.media.PhotoPage;
import com.facebook.katana.ui.ImageViewTouchBase;

class PickerGalleryView$PhotoLoadedListener
  implements MediaPickerGalleryAdapter.MediaImageLoadedListener
{
  private PickerGalleryView$PhotoLoadedListener(PickerGalleryView paramPickerGalleryView)
  {
  }

  public void a(ImageViewTouchBase paramImageViewTouchBase)
  {
    if (paramImageViewTouchBase != null)
      paramImageViewTouchBase.setOnTouchListener(PickerGalleryView.s(this.a));
    PhotoPage localPhotoPage = PickerGalleryView.f(this.a).f();
    if ((localPhotoPage != null) && (paramImageViewTouchBase == localPhotoPage.getImageView()))
      this.a.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.PhotoLoadedListener
 * JD-Core Version:    0.6.0
 */