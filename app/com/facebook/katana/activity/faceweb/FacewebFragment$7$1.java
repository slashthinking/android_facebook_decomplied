package com.facebook.katana.activity.faceweb;

import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.webview.FacewebWebView;
import java.util.List;

class FacewebFragment$7$1 extends AppSessionListener
{
  public void b(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<Long> paramList)
  {
    if (paramInt == 200)
      FacewebFragment.b(this.a.b).c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.7.1
 * JD-Core Version:    0.6.0
 */