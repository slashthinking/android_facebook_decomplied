package com.facebook.katana.activity.media.crop;

import com.facebook.katana.model.PhotoItem;

class CropManager$5
  implements CropImageView.OnImageSizeCalculatedListener
{
  public void a()
  {
    CropInfo localCropInfo = CropManager.a(this.a).h().j();
    if ((localCropInfo != null) && (localCropInfo.a() != null))
    {
      DrawingElements localDrawingElements = CropDatabaseHelper.a(localCropInfo, CropManager.a(this.a).j());
      CropManager.a(this.a).a(localDrawingElements.a);
      CropManager.a(this.a).b(localDrawingElements.b);
    }
    CropManager.e(this.a).setHighlightArea();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropManager.5
 * JD-Core Version:    0.6.0
 */