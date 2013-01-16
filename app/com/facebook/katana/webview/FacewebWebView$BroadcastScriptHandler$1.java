package com.facebook.katana.webview;

import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import java.util.Iterator;
import java.util.List;

class FacewebWebView$BroadcastScriptHandler$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = FacewebWebView.getRegisteredFacewebWebViews().iterator();
    while (localIterator.hasNext())
    {
      FacewebWebView localFacewebWebView = (FacewebWebView)localIterator.next();
      if (Constants.URL.a(localFacewebWebView.getUrl()))
      {
        localFacewebWebView.a(this.a, null);
        continue;
      }
      Log.c(FacewebWebView.k(), "Skipped broadcast to non-FB url: " + localFacewebWebView.getUrl());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.BroadcastScriptHandler.1
 * JD-Core Version:    0.6.0
 */