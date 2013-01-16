package com.facebook.katana.c2dm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SystemTrayErrorNotificationPostActivity$4
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    this.a.startActivity(new Intent("android.settings.ADD_ACCOUNT_SETTINGS"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.c2dm.SystemTrayErrorNotificationPostActivity.4
 * JD-Core Version:    0.6.0
 */