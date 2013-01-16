package com.facebook.katana.activity;

import android.app.ProgressDialog;
import android.content.res.Resources;

class NewUserRegistrationActivity$ProgressSpinner extends ProgressDialog
{
  NewUserRegistrationActivity$ProgressSpinner(NewUserRegistrationActivity paramNewUserRegistrationActivity)
  {
    super(paramNewUserRegistrationActivity);
    requestWindowFeature(1);
    setMessage(paramNewUserRegistrationActivity.getResources().getText(2131362038));
    setCanceledOnTouchOutside(false);
  }

  public void onBackPressed()
  {
    dismiss();
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.NewUserRegistrationActivity.ProgressSpinner
 * JD-Core Version:    0.6.0
 */