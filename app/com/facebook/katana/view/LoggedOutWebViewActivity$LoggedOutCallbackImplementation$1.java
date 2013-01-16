package com.facebook.katana.view;

import android.view.View;

class LoggedOutWebViewActivity$LoggedOutCallbackImplementation$1
  implements Runnable
{
  public void run()
  {
    if (this.a)
      LoggedOutWebViewActivity.a(this.b.a).setVisibility(0);
    while (true)
    {
      LoggedOutWebViewActivity.c(this.b.a);
      return;
      LoggedOutWebViewActivity.a(this.b.a).setVisibility(8);
      LoggedOutWebViewActivity.b(this.b.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.LoggedOutWebViewActivity.LoggedOutCallbackImplementation.1
 * JD-Core Version:    0.6.0
 */