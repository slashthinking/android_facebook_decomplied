package com.facebook.katana.view;

import android.view.View;

class LoggedOutWebViewActivity$LoggedOutCallbackImplementation
  implements LoggedOutCallbackInterface
{
  LoggedOutWebViewActivity$LoggedOutCallbackImplementation(LoggedOutWebViewActivity paramLoggedOutWebViewActivity)
  {
  }

  public void setFailing(boolean paramBoolean)
  {
    LoggedOutWebViewActivity.a(this.a).post(new LoggedOutWebViewActivity.LoggedOutCallbackImplementation.1(this, paramBoolean));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.LoggedOutWebViewActivity.LoggedOutCallbackImplementation
 * JD-Core Version:    0.6.0
 */