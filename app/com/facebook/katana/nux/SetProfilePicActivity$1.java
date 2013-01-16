package com.facebook.katana.nux;

import android.view.View;
import android.view.View.OnClickListener;

class SetProfilePicActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Thread localThread = new Thread(new SetProfilePicActivity.UploadProfilePicRunnable(this.a, SetProfilePicActivity.a(this.a), null));
    localThread.setPriority(1);
    localThread.start();
    this.a.setResult(-1);
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.SetProfilePicActivity.1
 * JD-Core Version:    0.6.0
 */