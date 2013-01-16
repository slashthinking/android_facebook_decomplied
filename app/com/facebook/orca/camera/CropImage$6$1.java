package com.facebook.orca.camera;

import android.widget.Toast;
import java.util.ArrayList;

class CropImage$6$1
  implements Runnable
{
  public void run()
  {
    CropImage localCropImage = this.a.e;
    boolean bool;
    if (this.a.d > 1)
      bool = true;
    while (true)
    {
      localCropImage.a = bool;
      if (this.a.d > 0)
      {
        for (int i = 0; i < this.a.d; i++)
          CropImage.6.a(this.a, this.a.c[i]);
        bool = false;
        continue;
      }
      CropImage.6.a(this.a);
    }
    CropImage.d(this.a.e).invalidate();
    if (CropImage.d(this.a.e).a.size() == 1)
    {
      this.a.e.c = ((HighlightView)CropImage.d(this.a.e).a.get(0));
      this.a.e.c.a(true);
    }
    if (this.a.d > 1)
      Toast.makeText(this.a.e, 2131362643, 0).show();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.CropImage.6.1
 * JD-Core Version:    0.6.0
 */