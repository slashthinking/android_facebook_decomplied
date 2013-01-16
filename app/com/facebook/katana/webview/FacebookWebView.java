package com.facebook.katana.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.base.BuildConstants;
import com.facebook.debug.Assert;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.model.SessionCookie;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FacebookWebView extends BaseWebView
{
  private static final Class<?> f = FacebookWebView.class;
  protected Map<String, FacebookWebView.UrlHandler> a;
  protected FacebookJsBridge b;
  protected final Context c;
  protected boolean d;
  protected final PerformanceLogger e;
  private String g;

  public FacebookWebView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FacebookWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FacebookWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.e = ((PerformanceLogger)FbInjector.a(this.c).a(PerformanceLogger.class));
  }

  public static void setCookiesForWebViews(AppSession paramAppSession, Context paramContext)
  {
    if ((paramAppSession == null) || (paramAppSession.b() == null));
    while (true)
    {
      return;
      List localList = paramAppSession.b().b();
      if (localList == null)
        continue;
      Boolean localBoolean = Gatekeeper.a(paramContext, "android_fw_ssl");
      if ((localBoolean == null) || (localBoolean.booleanValue()));
      for (String str1 = "https://%s/"; ; str1 = "http://%s/")
      {
        String str2 = Constants.URL.a(paramContext, str1);
        CookieManager localCookieManager = CookieManager.getInstance();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
          localCookieManager.setCookie(str2, ((SessionCookie)localIterator.next()).toString());
      }
      CookieSyncManager.getInstance().sync();
      paramAppSession.b().c();
    }
  }

  public String a(String paramString, FacebookWebView.JsReturnHandler paramJsReturnHandler)
  {
    String str1 = this.b.a(paramString, paramJsReturnHandler);
    String str2 = "__android_injected_function_" + str1;
    loadUrl(StringLocaleUtil.a("javascript:var %1$s = function() { return %2$s;};", new Object[] { str2, paramString }));
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("callId", str1);
    localHashMap1.put("exc", new FacewebUriPalCall.JsVariable("__android_exception"));
    localHashMap1.put("retval", new FacewebUriPalCall.JsVariable("__android_retval"));
    String str3 = FacewebUriPalCall.a("fbrpc", "facebook", null, null, "call_return", localHashMap1);
    HashMap localHashMap2;
    if (BuildConstants.a())
    {
      localHashMap2 = new HashMap();
      localHashMap2.put("callId", str1);
      localHashMap2.put("exc", new FacewebUriPalCall.JsVariable("err"));
    }
    for (String str4 = StringLocaleUtil.a("javascript:(function() { var __android_exception = null; var __android_retval; try { __android_retval = %1$s();} catch (err) { window.prompt(%2$s);throw err; }window.prompt(%3$s);%1$s = null;})()", new Object[] { str2, FacewebUriPalCall.a("fbrpc", "facebook", null, null, "call_return", localHashMap2), str3 }); ; str4 = StringLocaleUtil.a("javascript:(function() { var __android_exception = null; var __android_retval = null; try { __android_retval = %1$s();} catch (err) { __android_exception = true; }window.prompt(%2$s);%1$s = null;})()", new Object[] { str2, str3 }))
    {
      loadUrl(str4);
      return str1;
    }
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.a = new HashMap();
    this.b = new FacebookJsBridge(f);
    a("fbrpc", this.b.b);
  }

  protected void a(Context paramContext, FacewebPalCall paramFacewebPalCall)
  {
    this.b.a(paramContext, this, paramFacewebPalCall);
  }

  void a(String paramString)
  {
    loadUrl("javascript:" + paramString);
  }

  public void a(String paramString, FacebookWebView.NativeCallHandler paramNativeCallHandler)
  {
    this.b.a(paramString, paramNativeCallHandler);
  }

  public void a(String paramString, FacebookWebView.UrlHandler paramUrlHandler)
  {
    Assert.b((FacebookWebView.UrlHandler)this.a.put(paramString, paramUrlHandler));
  }

  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equals("")))
      paramString2 = "null";
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = new FacewebUriPalCall.JsVariable(paramString2);
    a(StringLocaleUtil.a("(function() {var event = document.createEvent('Event');event.initEvent('%1$s', true, true);event.data = '%2$s';document.dispatchEvent(event);})();", arrayOfObject));
  }

  public void a(String paramString, List<?> paramList, FacebookWebView.JsReturnHandler paramJsReturnHandler)
  {
    a(FacebookJsBridge.a(paramString, paramList), paramJsReturnHandler);
  }

  public void b(String paramString, FacebookWebView.JsReturnHandler paramJsReturnHandler)
  {
    a(paramString, paramJsReturnHandler);
  }

  public void destroy()
  {
    if (this.b != null)
      this.b.d.clear();
    super.destroy();
  }

  public String getMobilePage()
  {
    return this.g;
  }

  protected void setChromeClient(Context paramContext)
  {
    setWebChromeClient(new FacebookWebView.RPCChromeClient(this));
  }

  public void setMobilePage(String paramString)
  {
    this.g = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookWebView
 * JD-Core Version:    0.6.0
 */