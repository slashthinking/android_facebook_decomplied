package com.facebook.notifications.prefs;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class NotificationsPrefs
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("notifications/");
  public static final PrefKey b = (PrefKey)a.c("last_updated_time");
  public static final PrefKey c = (PrefKey)a.c("gql_notification");
  public static final PrefKey d = (PrefKey)a.c("graphql_notif_card");
  public static final PrefKey e = (PrefKey)a.c("last_stale_client_notification_fetch_time_ms");
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.prefs.NotificationsPrefs
 * JD-Core Version:    0.6.2
 */