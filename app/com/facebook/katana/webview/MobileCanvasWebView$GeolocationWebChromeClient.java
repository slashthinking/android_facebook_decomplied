package com.facebook.katana.webview;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.webkit.GeolocationPermissions.Callback;
import android.widget.CheckBox;

public class MobileCanvasWebView$GeolocationWebChromeClient extends FacebookWebView.RPCChromeClient
{
  private Context d;

  public MobileCanvasWebView$GeolocationWebChromeClient(MobileCanvasWebView paramMobileCanvasWebView, Context paramContext)
  {
    super(paramMobileCanvasWebView);
    this.d = paramContext;
  }

  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    CheckBox localCheckBox = new CheckBox(this.d);
    localCheckBox.setText(2131362954);
    localCheckBox.setTextColor(-1);
    new AlertDialog.Builder(this.d).setMessage(this.d.getString(2131362953, new Object[] { paramString })).setCancelable(false).setView(localCheckBox).setPositiveButton(2131362951, new MobileCanvasWebView.GeolocationWebChromeClient.2(this, paramCallback, paramString, localCheckBox)).setNegativeButton(2131362952, new MobileCanvasWebView.GeolocationWebChromeClient.1(this, paramCallback, paramString, localCheckBox)).create().show();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.MobileCanvasWebView.GeolocationWebChromeClient
 * JD-Core Version:    0.6.0
 */