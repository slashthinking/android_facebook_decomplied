package com.facebook.katana.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import android.widget.CheckBox;

class MobileCanvasWebView$GeolocationWebChromeClient$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.invoke(this.b, false, this.c.isChecked());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.MobileCanvasWebView.GeolocationWebChromeClient.1
 * JD-Core Version:    0.6.0
 */