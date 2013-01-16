package com.facebook.katana.activity.media.crop;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.activity.media.RotationManager;
import com.facebook.katana.model.PhotoItem;

class CropManager$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int i = 90 * ((3 + (int)((CropDatabaseHelper.b(CropManager.a(this.a)).b() + CropManager.a(this.a).h().h()) / 90.0F)) % 4);
    CropDatabaseHelper.a(CropManager.a(this.a).h(), CropManager.b(this.a));
    RotationManager.a(CropManager.b(this.a), CropManager.a(this.a).h(), i);
    CropManager.a(this.a).e().a(i);
    CropManager.d(this.a).a();
    CropManager.d(this.a).setImageMatrix(CropManager.a(this.a).m());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropManager.3
 * JD-Core Version:    0.6.0
 */