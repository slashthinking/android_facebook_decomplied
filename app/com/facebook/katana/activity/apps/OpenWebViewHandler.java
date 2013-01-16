package com.facebook.katana.activity.apps;

import android.app.Activity;
import android.os.Handler;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebUriPalCall;
import com.facebook.katana.webview.FacewebUriPalCall.JsVariable;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.HashMap;

public class OpenWebViewHandler extends FacebookWebView.NativeUICallHandler
{
  public OpenWebViewHandler(Handler paramHandler)
  {
    super(paramHandler);
  }

  public static String a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", new FacewebUriPalCall.JsVariable("url"));
    return StringLocaleUtil.a("window.__fbNative.open = function(%1$s) {window.prompt(%2$s);var dialog = window.__fbNative.dialog = {close: function() {window.prompt(%3$s);},closed: false,postMessage: function(message, targetOrigin) {window.__fbNative.postMessage(message, targetOrigin);}};return dialog;};", new Object[] { "url", FacewebUriPalCall.a("fbrpc", "facebook", null, null, "openDialogWebview", localHashMap), FacewebUriPalCall.a("fbrpc", "facebook", null, null, "closeDialogWebview", new HashMap()) });
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "url", "");
    Assert.a(FacebookActivityDelegate.a);
    FacebookActivityDelegate.b = str;
    FacebookActivityDelegate.a.showDialog(684737812);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.OpenWebViewHandler
 * JD-Core Version:    0.6.0
 */