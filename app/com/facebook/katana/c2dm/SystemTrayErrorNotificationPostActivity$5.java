package com.facebook.katana.c2dm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

class SystemTrayErrorNotificationPostActivity$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
    localEditor.putBoolean("notif", false);
    localEditor.commit();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.c2dm.SystemTrayErrorNotificationPostActivity.5
 * JD-Core Version:    0.6.0
 */