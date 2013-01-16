package com.facebook.orca.prefs;

public class SharedPrefKeys
{
  public static final PrefKey a = new PrefKey("/");
  public static final PrefKey b = (PrefKey)a.c("settings/");
  public static final PrefKey c = (PrefKey)a.c("config/");
  public static final PrefKey d = (PrefKey)a.c("shared/");
  public static final PrefKey e = (PrefKey)d.c("device_id");
  public static final PrefKey f = (PrefKey)d.c("device_id_generate_timestamp");
  public static final PrefKey g = (PrefKey)d.c("logged_in_after_last_auth");
  public static final PrefKey h = (PrefKey)b.c("logging/");
  public static final PrefKey i = (PrefKey)h.c("logging_level");
  public static final PrefKey j = (PrefKey)h.c("debug_logs");
  public static final PrefKey k = (PrefKey)b.c("analytics");
  public static final PrefKey l = (PrefKey)k.c("device_stat_interval");
  public static final PrefKey m = (PrefKey)k.c("batch_size");
  public static final PrefKey n = (PrefKey)d.c("fps_controller/");
  public static final PrefKey o = (PrefKey)n.c("enable");
  public static final PrefKey p = (PrefKey)n.c("logging");
  public static final PrefKey q = (PrefKey)d.c("ui_thread_watchdog");
  public static final PrefKey r = (PrefKey)d.c("imagecache/");
  public static final PrefKey s = (PrefKey)r.c("bitmap_purgeable");
  public static final PrefKey t = (PrefKey)b.c("bug_reporting/");
  public static final PrefKey u = (PrefKey)t.c("rageshake/");
  public static final PrefKey v = (PrefKey)u.c("enable");
  public static final PrefKey w = (PrefKey)d.c("new_photo_gallery");
  public static final PrefKey x = (PrefKey)d.c("face_rec");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.SharedPrefKeys
 * JD-Core Version:    0.6.0
 */