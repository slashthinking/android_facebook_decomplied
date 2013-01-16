package com.facebook.katana.orca;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class ForceMessengerPrefKeys
{
  public static final PrefKey a;
  public static final PrefKey b;
  public static final PrefKey c;
  private static final PrefKey d = (PrefKey)SharedPrefKeys.c.c("force_messenger/");

  static
  {
    a = (PrefKey)d.c("stage");
    b = (PrefKey)d.c("cliff_time");
    c = (PrefKey)d.c("last_shown");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.ForceMessengerPrefKeys
 * JD-Core Version:    0.6.0
 */