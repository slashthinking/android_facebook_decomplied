package com.facebook.katana.activity.faceweb;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.util.StringUtils;

class FacewebFragment$ShowAlertHandler$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!StringUtils.c(this.a))
      this.b.a.b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowAlertHandler.2
 * JD-Core Version:    0.6.0
 */