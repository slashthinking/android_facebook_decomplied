package com.facebook.orca.prefs;

public class AuthPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("auth/");
  public static final PrefKey b = (PrefKey)a.c("user_data/");
  public static final PrefKey c = (PrefKey)b.c("fb_token");
  public static final PrefKey d = (PrefKey)b.c("fb_expires");
  public static final PrefKey e = (PrefKey)b.c("fb_session_cookies_string");
  public static final PrefKey f = (PrefKey)b.c("fb_is_partial_account");
  public static final PrefKey g = (PrefKey)b.c("fb_logged_out");
  public static final PrefKey h = (PrefKey)a.c("auth_machine_id");
  public static final PrefKey i = (PrefKey)b.c("attribution/");
  public static final PrefKey j = (PrefKey)SharedPrefKeys.a.c("reg/");
  public static final PrefKey k = (PrefKey)j.c("reg_instance");
  public static final PrefKey l = (PrefKey)j.c("conf_code");
  public static final PrefKey m = (PrefKey)j.c("conf_code_timestamp");
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.AuthPrefKeys
 * JD-Core Version:    0.6.2
 */