package com.facebook.katana.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.CacheManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.UserAgent;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.net.HttpOperation;
import com.google.common.collect.Maps;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseWebView extends WebView
{
  private static String a;

  public BaseWebView(Context paramContext)
  {
    super(paramContext);
    a();
    a(paramContext);
  }

  public BaseWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    a(paramContext);
  }

  public BaseWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    a(paramContext);
  }

  private void a()
  {
    if (a == null)
      a = getSettings().getUserAgentString();
  }

  private Map<String, String> getAdditionalHttpHeaders()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("X-FB-Connection-Type", HttpOperation.b(getContext()));
    return localHashMap;
  }

  protected void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      setHapticFeedbackEnabled(false);
      setLongClickable(true);
      setOnLongClickListener(new BaseWebView.1(this));
    }
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    Boolean localBoolean = Gatekeeper.a(paramContext, "android_disable_webcache");
    if (Boolean.TRUE.equals(localBoolean))
      localWebSettings.setCacheMode(2);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Method localMethod = CacheManager.class.getDeclaredMethod("setCacheDisabled", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      localWebSettings.setUserAgentString(getBaseUserAgent() + " " + UserAgent.a(paramContext, Boolean.valueOf(false)));
      setChromeClient(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        ErrorReporting.a("WebViewCache", "Failed to disable cache:" + localThrowable.getMessage(), localThrowable);
    }
  }

  protected String getBaseUserAgent()
  {
    return a;
  }

  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString, getAdditionalHttpHeaders());
  }

  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    HashMap localHashMap = Maps.a(1 + paramMap.size());
    localHashMap.putAll(paramMap);
    localHashMap.putAll(getAdditionalHttpHeaders());
    super.loadUrl(paramString, localHashMap);
  }

  protected void setChromeClient(Context paramContext)
  {
    setWebChromeClient(new BaseWebView.BaseWebChromeClient());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.BaseWebView
 * JD-Core Version:    0.6.0
 */