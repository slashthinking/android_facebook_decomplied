package com.facebook.katana.activity;

import android.app.ProgressDialog;
import android.content.res.Resources;

class PlatformDialogActivity$PlatformDialogSpinner extends ProgressDialog
{
  PlatformDialogActivity$PlatformDialogSpinner(PlatformDialogActivity paramPlatformDialogActivity)
  {
    super(paramPlatformDialogActivity);
    requestWindowFeature(1);
    setMessage(paramPlatformDialogActivity.getResources().getText(2131362038));
  }

  public void onBackPressed()
  {
    dismiss();
    this.a.d(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.PlatformDialogActivity.PlatformDialogSpinner
 * JD-Core Version:    0.6.0
 */