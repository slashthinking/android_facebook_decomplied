package com.facebook.katana.webview;

import com.facebook.common.util.Log;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.List;

class FacewebWebView$1
  implements FacewebComponentsStoreCache.Listener
{
  public void a(FacewebComponentsStore paramFacewebComponentsStore)
  {
    List localList = paramFacewebComponentsStore.a(this.a);
    synchronized (this.b)
    {
      FacewebWebView.c(this.b).addAll(localList);
      this.b.e();
      return;
    }
  }

  public void a(FacewebComponentsStoreCache.LoadError paramLoadError, String paramString)
  {
    Class localClass = FacewebWebView.k();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramLoadError.toString();
    arrayOfObject[1] = paramString;
    Log.a(localClass, StringLocaleUtil.a("Failed to load components store. Error: %s   Message: %s", arrayOfObject));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.1
 * JD-Core Version:    0.6.0
 */