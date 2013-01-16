package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.facebook.katana.webview.FacewebComponentsStoreCache;

class SettingsActivity$7
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (paramObject.equals("cookies"))
    {
      CookieSyncManager.createInstance(this.a);
      CookieManager.getInstance().removeAllCookie();
    }
    while (true)
    {
      return false;
      if (!paramObject.equals("cache"))
        continue;
      new WebView(this.a).clearCache(true);
      FacewebComponentsStoreCache.a(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.7
 * JD-Core Version:    0.6.0
 */