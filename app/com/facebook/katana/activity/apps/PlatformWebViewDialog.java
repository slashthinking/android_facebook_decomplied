package com.facebook.katana.activity.apps;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.Window;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.MobileCanvasWebView;

public class PlatformWebViewDialog extends Dialog
{
  protected MobileCanvasWebView a;
  protected Handler b;
  protected Activity c;

  public PlatformWebViewDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    a(paramActivity);
  }

  protected void a(Activity paramActivity)
  {
    this.b = new Handler();
    this.c = paramActivity;
  }

  public void a(String paramString, FacebookWebView paramFacebookWebView)
  {
    setContentView(2130903060);
    getWindow().setLayout(-1, -1);
    this.a = ((MobileCanvasWebView)findViewById(2131296395));
    this.a.loadUrl(paramString);
    this.a.a("setNavBarTitle", new PlatformWebViewDialog.SetDialogTitleHandler(this, this, this.b));
    this.a.a("setNavBarButton", new PlatformWebViewDialog.SetDialogTextActionButton(this, this, this.b));
    this.a.a("postMessageWebview", new PostMessageHandler(paramFacebookWebView, this.a, this.b));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.PlatformWebViewDialog
 * JD-Core Version:    0.6.0
 */