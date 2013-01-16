package com.facebook.katana.view;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.webkit.WebView;

class LoggedOutWebViewActivity$ProgressSpinner extends ProgressDialog
{
  LoggedOutWebViewActivity$ProgressSpinner(LoggedOutWebViewActivity paramLoggedOutWebViewActivity)
  {
    super(paramLoggedOutWebViewActivity);
    requestWindowFeature(1);
    setMessage(paramLoggedOutWebViewActivity.getResources().getText(2131362038));
    setCanceledOnTouchOutside(false);
  }

  public void onBackPressed()
  {
    dismiss();
    if (LoggedOutWebViewActivity.d(this.a).canGoBack())
      LoggedOutWebViewActivity.d(this.a).goBack();
    while (true)
    {
      return;
      this.a.finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.LoggedOutWebViewActivity.ProgressSpinner
 * JD-Core Version:    0.6.0
 */