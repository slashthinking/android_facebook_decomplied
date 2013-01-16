package com.facebook.orca.prefs;

public class InternalHttpPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.b.c("http/");
  public static final PrefKey b = (PrefKey)a.c("php_profiling");
  public static final PrefKey c = (PrefKey)a.c("wirehog_profiling");
  public static final PrefKey d = (PrefKey)a.c("teak_profiling");
  public static final PrefKey e = (PrefKey)a.c("carrier_id");
  public static final PrefKey f = (PrefKey)a.c("check_certs");
  public static final PrefKey g = (PrefKey)a.c("http_proxy");
  public static final PrefKey h = (PrefKey)SharedPrefKeys.b.c("sandbox/");
  public static final PrefKey i = (PrefKey)h.c("web/");
  public static final PrefKey j = (PrefKey)i.c("server_tier");
  public static final PrefKey k = (PrefKey)i.c("sandbox");
  public static final PrefKey l = (PrefKey)h.c("mqtt/");
  public static final PrefKey m = (PrefKey)l.c("server_tier");
  public static final PrefKey n = (PrefKey)l.c("sandbox");
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.InternalHttpPrefKeys
 * JD-Core Version:    0.6.2
 */