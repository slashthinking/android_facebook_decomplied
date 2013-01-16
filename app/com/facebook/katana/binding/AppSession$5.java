package com.facebook.katana.binding;

import com.facebook.common.util.Log;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Listener;
import com.facebook.katana.webview.FacewebComponentsStoreCache.LoadError;

class AppSession$5
  implements FacewebComponentsStoreCache.Listener
{
  public void a(FacewebComponentsStore paramFacewebComponentsStore)
  {
    this.a.a(AppSession.PreloadStep.FETCH_SKELETON);
  }

  public void a(FacewebComponentsStoreCache.LoadError paramLoadError, String paramString)
  {
    Log.e("PRELOAD", "Failed to fetch skeleton in preloader: " + paramLoadError + " data=" + paramString);
    this.a.a(AppSession.PreloadStep.FETCH_SKELETON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.5
 * JD-Core Version:    0.6.0
 */