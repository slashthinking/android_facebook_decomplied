package com.facebook.katana.prefs;

import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.prefs.PrefKey;

public class NotificationPrefKeys
{
  public static final PrefKey a = (PrefKey)FbandroidPrefKeys.a.c("notifications/");
  public static final PrefKey b = (PrefKey)a.c("unseen_notifications");
  public static final PrefKey c = (PrefKey)a.c("last_notification_update_time");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.prefs.NotificationPrefKeys
 * JD-Core Version:    0.6.0
 */