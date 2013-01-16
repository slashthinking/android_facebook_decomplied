package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import java.io.IOException;

class FacewebComponentsStoreCacheClient$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacewebComponentsStore paramFacewebComponentsStore)
  {
    if (paramFacewebComponentsStore == null)
      this.a.a(this.b, false, this.c, null, new FacewebComponentsStoreCache.Value(FacewebComponentsStoreCache.LoadError.UNKNOWN_ERROR, paramString2));
    while (true)
    {
      return;
      try
      {
        String str = paramFacewebComponentsStore.b();
        this.a.a(this.b, true, this.c, str, new FacewebComponentsStoreCache.Value(paramFacewebComponentsStore));
      }
      catch (IOException localIOException)
      {
        this.a.a(this.b, false, this.c, null, new FacewebComponentsStoreCache.Value(FacewebComponentsStoreCache.LoadError.SERIALIZATION_ERROR, localIOException.toString()));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebComponentsStoreCacheClient.1
 * JD-Core Version:    0.6.0
 */