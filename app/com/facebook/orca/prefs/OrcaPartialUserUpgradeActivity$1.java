package com.facebook.orca.prefs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.threadlist.ThreadListActivity;

class OrcaPartialUserUpgradeActivity$1 extends WebViewClient
{
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    BLog.e("PartialUpgrade", "Error in Upgrade Code:" + paramInt + " Description:" + paramString1);
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Uri localUri;
    if (paramString.startsWith("fb://upgrade_complete"))
    {
      localUri = Uri.parse(paramString);
      if (localUri.getQueryParameter("status").equalsIgnoreCase("success"))
      {
        OrcaPartialUserUpgradeActivity.a(this.a).b().a(AuthPrefKeys.f, false).a();
        Intent localIntent = new Intent(this.a, ThreadListActivity.class);
        localIntent.addFlags(67108864);
        OrcaPartialUserUpgradeActivity.b(this.a).a(localIntent, this.a);
      }
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      BLog.e("PartialUpgrade", "Error with upgrading:" + localUri.getQueryParameter("status_message"));
      break;
      paramWebView.loadUrl(paramString);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaPartialUserUpgradeActivity.1
 * JD-Core Version:    0.6.0
 */