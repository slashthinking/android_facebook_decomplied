package com.facebook.orca.prefs;

import android.net.Uri;

public class MessagesPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("messages/");
  public static final PrefKey b = (PrefKey)SharedPrefKeys.b.c("messages/");
  public static final PrefKey c = (PrefKey)a.c("sms/");
  public static final PrefKey d = (PrefKey)c.c("last_push_time");
  public static final PrefKey e = (PrefKey)c.c("last_seen_time");
  public static final PrefKey f = (PrefKey)c.c("sms_enabled");
  public static final PrefKey g = (PrefKey)c.c("sms_beta_enabled");
  public static final PrefKey h = (PrefKey)c.c("sms_nux_progress");
  public static final PrefKey i = (PrefKey)c.c("use_as_main_app");
  public static final PrefKey j = (PrefKey)c.c("enable_sms_only");
  public static final PrefKey k = (PrefKey)b.c("notifications/");
  public static final PrefKey l = (PrefKey)k.c("enabled");
  public static final PrefKey m = (PrefKey)k.c("muted_until2");
  public static final PrefKey n = (PrefKey)k.c("sound_enabled");
  public static final PrefKey o = (PrefKey)k.c("vibrate_enabled");
  public static final PrefKey p = (PrefKey)k.c("led_enabled");
  public static final PrefKey q = (PrefKey)k.c("ringtone_uri");
  public static final PrefKey r = (PrefKey)b.c("location_services");
  public static final PrefKey s = (PrefKey)b.c("threads/");
  public static final PrefKey t = (PrefKey)k.c("threads/");
  public static final PrefKey u = (PrefKey)a.c("notifications/recent_threads/");
  public static final PrefKey v = (PrefKey)a.c("block_dialog_radio_selection");
  public static final PrefKey w = (PrefKey)a.c("hide_contacts_suggestion_grid");
  public static final PrefKey x = (PrefKey)a.c("ui_counters/");
  public static final PrefKey y = (PrefKey)a.c("contacts/");
  public static final PrefKey z = (PrefKey)y.c("upload_enabled");

  public static PrefKey a(String paramString)
  {
    String str = Uri.encode(paramString);
    return (PrefKey)((PrefKey)t.c(str)).c("/muted_until2");
  }

  public static PrefKey b(String paramString)
  {
    String str = Uri.encode(paramString);
    return (PrefKey)((PrefKey)s.c(str)).c("/share_location");
  }

  public static PrefKey c(String paramString)
  {
    String str = Uri.encode(paramString);
    return (PrefKey)u.c(str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.MessagesPrefKeys
 * JD-Core Version:    0.6.0
 */