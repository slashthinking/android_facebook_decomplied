package com.facebook.katana.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import com.facebook.katana.UserAgent;

public class MobileCanvasWebView extends FacebookWebView
{
  private static final Class<?> g = MobileCanvasWebView.class;
  protected MobileCanvasWebView.PageFinishedHandler f;

  public MobileCanvasWebView(Context paramContext)
  {
    super(paramContext);
  }

  public MobileCanvasWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public MobileCanvasWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.f = null;
    WebSettings localWebSettings = getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + UserAgent.a(paramContext, Boolean.valueOf(true)));
    setWebViewClient(new MobileCanvasWebView.MobileCanvasWebViewClient(this, paramContext));
    setWebChromeClient(new MobileCanvasWebView.GeolocationWebChromeClient(this, paramContext));
  }

  public void b(String paramString)
  {
    if (this.f != null)
      this.f.a(this, paramString);
  }

  public void setPageFinishedHandler(MobileCanvasWebView.PageFinishedHandler paramPageFinishedHandler)
  {
    this.f = paramPageFinishedHandler;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.MobileCanvasWebView
 * JD-Core Version:    0.6.0
 */