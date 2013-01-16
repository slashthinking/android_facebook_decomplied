package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import com.facebook.katana.ui.ImageViewTouchBase.Recycler;

class PhotoPage$LoadPhotoTask$1
  implements ImageViewTouchBase.Recycler
{
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      paramBitmap.recycle();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoPage.LoadPhotoTask.1
 * JD-Core Version:    0.6.0
 */