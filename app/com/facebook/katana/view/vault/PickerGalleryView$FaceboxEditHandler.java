package com.facebook.katana.view.vault;

import android.graphics.PointF;
import com.facebook.katana.activity.media.MediaPickerGalleryAdapter;
import com.facebook.katana.activity.media.MediaTagController.FaceboxClickedListener;
import com.facebook.katana.activity.media.PhotoPage;
import com.facebook.katana.activity.media.TouchBlip;
import com.facebook.katana.ui.ImageViewTouchBase;

class PickerGalleryView$FaceboxEditHandler
  implements MediaTagController.FaceboxClickedListener
{
  private PickerGalleryView$FaceboxEditHandler(PickerGalleryView paramPickerGalleryView)
  {
  }

  public void a()
  {
    PickerGalleryView.n(this.a);
  }

  public void a(PointF paramPointF)
  {
    if (PickerGalleryView.e(this.a) == null)
    {
      PointF localPointF = new PointF(paramPointF.x / 100.0F, paramPointF.y / 100.0F);
      PickerGalleryView.o(this.a).a(localPointF, PickerGalleryView.f(this.a).f().getImageView().getDisplayedImageRect());
    }
    PickerGalleryView.a(this.a, paramPointF);
    PickerGalleryView.b(this.a, true);
    PickerGalleryView.p(this.a);
  }

  public void b()
  {
    PickerGalleryView.q(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.FaceboxEditHandler
 * JD-Core Version:    0.6.0
 */