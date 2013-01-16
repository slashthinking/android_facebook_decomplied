package com.facebook.orca.prefs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class OrcaPartialUserUpgradeActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private FbTitleBar n;
  private OrcaSharedPreferences o;
  private SecureContextHelper p;
  private OrcaAppType q;

  public String a()
  {
    return "prefs_root";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903392);
    FbTitleBarUtil.a(this);
    this.n = ((FbTitleBar)f(2131296299));
    this.n.setTitle(getString(2131362622));
    WebView localWebView = (WebView)f(2131297404);
    localWebView.getSettings().setJavaScriptEnabled(true);
    FbInjector localFbInjector = C();
    this.o = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.p = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.q = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    String str1 = ((AuthDataStore)localFbInjector.a(AuthDataStore.class)).c().a();
    String str2 = Locale.getDefault().getLanguage();
    localWebView.setWebViewClient(new OrcaPartialUserUpgradeActivity.1(this));
    try
    {
      localWebView.loadUrl(Uri.parse("https://m.facebook.com/messenger/upgrade_account").buildUpon().appendQueryParameter("access_token", str1).appendQueryParameter("return_url", URLEncoder.encode("fb://upgrade_complete", "utf-8")).appendQueryParameter("locale", str2).appendQueryParameter("cid", this.q.b()).build().toString());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        BLog.e("PartialUpgrade", "Error encoding url");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaPartialUserUpgradeActivity
 * JD-Core Version:    0.6.0
 */