package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.common.util.Tuple;
import com.facebook.katana.util.StringUtils;
import java.util.Map;

public class FacebookJsBridge$NativeCallReturnHandler
  implements FacebookWebView.NativeCallHandler
{
  protected FacebookJsBridge$NativeCallReturnHandler(FacebookJsBridge paramFacebookJsBridge)
  {
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str1 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callId");
    String str2 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "exc");
    String str3 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "retval");
    boolean bool;
    if (!StringUtils.a("null", str2))
    {
      bool = true;
      if (bool)
        Log.a(this.a.c, "Exception was returned by js: " + str2);
      monitorenter;
    }
    while (true)
    {
      try
      {
        Tuple localTuple = (Tuple)this.a.e.remove(str1);
        monitorexit;
        if (localTuple != null)
        {
          FacebookWebView.JsReturnHandler localJsReturnHandler = (FacebookWebView.JsReturnHandler)localTuple.b;
          if (localJsReturnHandler == null)
            continue;
          localJsReturnHandler.a(paramFacebookWebView, str1, bool, str3);
          return;
          bool = false;
          break;
        }
      }
      finally
      {
        monitorexit;
      }
      Log.b(this.a.c, "js called native_return with callId " + str1 + " but no call with that callId was made.");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookJsBridge.NativeCallReturnHandler
 * JD-Core Version:    0.6.0
 */