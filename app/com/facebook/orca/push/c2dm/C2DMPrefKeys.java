package com.facebook.orca.push.c2dm;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class C2DMPrefKeys
{
  public static final PrefKey a;
  public static final PrefKey b;
  public static final PrefKey c;
  public static final PrefKey d;
  public static final PrefKey e;
  public static final PrefKey f;
  public static final PrefKey g;
  public static final PrefKey h;
  public static final PrefKey i;
  public static final PrefKey j;
  public static final PrefKey k;
  private static final PrefKey l = (PrefKey)SharedPrefKeys.a.c("messenger/");

  static
  {
    a = (PrefKey)l.c("c2dm/");
    b = (PrefKey)a.c("token");
    c = (PrefKey)a.c("token_owner");
    d = (PrefKey)a.c("last_register_time");
    e = (PrefKey)a.c("last_change_time");
    f = (PrefKey)a.c("backoff_ms");
    g = (PrefKey)a.c("last_push_time");
    h = (PrefKey)a.c("last_service_attempt_type");
    i = (PrefKey)a.c("service_type");
    j = (PrefKey)a.c("fb_server_registered");
    k = (PrefKey)a.c("fb_server_last_register_time");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPrefKeys
 * JD-Core Version:    0.6.0
 */