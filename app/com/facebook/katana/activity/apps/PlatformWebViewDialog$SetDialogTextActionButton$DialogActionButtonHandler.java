package com.facebook.katana.activity.apps;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.webview.FacebookWebView;

class PlatformWebViewDialog$SetDialogTextActionButton$DialogActionButtonHandler
  implements View.OnClickListener
{
  protected FacebookWebView a;

  public PlatformWebViewDialog$SetDialogTextActionButton$DialogActionButtonHandler(PlatformWebViewDialog.SetDialogTextActionButton paramSetDialogTextActionButton, FacebookWebView paramFacebookWebView)
  {
    this.a = paramFacebookWebView;
  }

  public void onClick(View paramView)
  {
    this.a.b(PlatformWebViewDialog.SetDialogTextActionButton.a(this.b), null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.PlatformWebViewDialog.SetDialogTextActionButton.DialogActionButtonHandler
 * JD-Core Version:    0.6.0
 */