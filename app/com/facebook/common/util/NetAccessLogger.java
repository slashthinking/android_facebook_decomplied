package com.facebook.common.util;

import android.net.Uri;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class NetAccessLogger
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.b.c("fb_log_net_access");
  private final OrcaSharedPreferences b;

  public NetAccessLogger(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramOrcaSharedPreferences;
  }

  public void a(String paramString)
  {
    if (a())
    {
      String str = Uri.parse(paramString).getScheme();
      if (("http".equals(str)) || ("https".equals(str)))
        BLog.c("fb_net", paramString);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b.b().a(a, paramBoolean).a();
  }

  public boolean a()
  {
    boolean bool1 = this.b.a();
    boolean bool2 = false;
    if (bool1)
      bool2 = this.b.a(a, false);
    return bool2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.NetAccessLogger
 * JD-Core Version:    0.6.0
 */