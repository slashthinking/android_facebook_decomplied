package com.facebook.orca.login;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class WildfireAnalyticsUtils
{
  private OrcaSharedPreferences a;

  public WildfireAnalyticsUtils(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public HoneyClientEvent a(String paramString)
  {
    return a("wildfire_registration", paramString);
  }

  public HoneyClientEvent a(String paramString1, String paramString2)
  {
    return (HoneyClientEvent)new HoneyClientEvent(paramString1).d("wildfire").h(this.a.a(AuthPrefKeys.k, null)).b("step", paramString2).a("resume_upload_temporary", "1");
  }

  public HoneyClientEvent b(String paramString)
  {
    return a("wildfire_registration_manual", paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireAnalyticsUtils
 * JD-Core Version:    0.6.0
 */