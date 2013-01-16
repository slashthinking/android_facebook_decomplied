package com.facebook.katana.orca;

import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class FbandroidPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("fb_android/");
  public static final PrefKey b = (PrefKey)a.c("native_requests");
  public static final PrefKey c = (PrefKey)a.c("fullscreen_jewels");
  public static final PrefKey d = (PrefKey)a.c("native_search");
  public static final PrefKey e = (PrefKey)a.c("kvm/");
  public static final PrefKey f = (PrefKey)a.c("uvm/");
  public static final PrefKey g = (PrefKey)a.c("events/");
  public static final PrefKey h = (PrefKey)a.c("enable_faceweb_feed");
  public static final PrefKey i = (PrefKey)AuthPrefKeys.i.c("id");
  public static final PrefKey j = (PrefKey)AuthPrefKeys.i.c("attribution_id_timestamp");
  public static final PrefKey k = (PrefKey)AuthPrefKeys.i.c("attribution_id_saved_to_server");
  public static final PrefKey l = (PrefKey)a.c("bookmarks/");
  public static final PrefKey m = (PrefKey)l.c("newsfeed_filter_type_key");
  public static final PrefKey n = (PrefKey)a.c("push_notif_migration_done");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidPrefKeys
 * JD-Core Version:    0.6.0
 */