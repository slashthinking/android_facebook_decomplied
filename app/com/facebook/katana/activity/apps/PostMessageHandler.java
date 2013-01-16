package com.facebook.katana.activity.apps;

import android.os.Handler;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebUriPalCall;
import com.facebook.katana.webview.FacewebUriPalCall.JsVariable;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.HashMap;

public class PostMessageHandler extends FacebookWebView.NativeUICallHandler
{
  private static final Class<?> d = PostMessageHandler.class;
  protected FacebookWebView a;
  protected FacebookWebView b;

  public PostMessageHandler(FacebookWebView paramFacebookWebView1, FacebookWebView paramFacebookWebView2, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramFacebookWebView1;
    this.b = paramFacebookWebView2;
  }

  public static String a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", new FacewebUriPalCall.JsVariable("message"));
    localHashMap.put("targetOrigin", new FacewebUriPalCall.JsVariable("targetOrigin"));
    return StringLocaleUtil.a("window.__fbNative.postMessage = function(%1$s, %2$s) {window.prompt(%3$s);};", new Object[] { "message", "targetOrigin", FacewebUriPalCall.a("fbrpc", "facebook", null, null, "postMessageWebview", localHashMap) });
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "message", "");
    paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "targetOrigin", "");
    this.a.a("message", str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.PostMessageHandler
 * JD-Core Version:    0.6.0
 */