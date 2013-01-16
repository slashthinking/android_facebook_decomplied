package com.facebook.orca.prefs;

public class MessengerPrefKeys
{
  public static final PrefKey A;
  public static final PrefKey B;
  public static final PrefKey C;
  public static final PrefKey D;
  public static final PrefKey E;
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("messenger/");
  public static final PrefKey b = (PrefKey)SharedPrefKeys.b.c("messenger/");
  public static final PrefKey c = (PrefKey)a.c("first_install_time");
  public static final PrefKey d = (PrefKey)a.c("nux_completed");
  public static final PrefKey e = (PrefKey)a.c("login_reminder_trigger_state");
  public static final PrefKey f = (PrefKey)SharedPrefKeys.a.c("nux/");
  public static final PrefKey g = (PrefKey)f.c("version");
  public static final PrefKey h = (PrefKey)f.c("is_upgrade_user");
  public static final PrefKey i = (PrefKey)f.c("completed_version");
  public static final PrefKey j = (PrefKey)f.c("sms_completed");
  public static final PrefKey k = (PrefKey)f.c("sms_thread_completed");
  public static final PrefKey l = (PrefKey)f.c("compose_button_completed");
  public static final PrefKey m = (PrefKey)f.c("dive_bar_button_completed");
  public static final PrefKey n = (PrefKey)f.c("contacts_import_nux_completed");
  public static final PrefKey o = (PrefKey)f.c("audio_recordng_nux_completed");
  public static final PrefKey p = (PrefKey)a.c("phone_confirm/");
  public static final PrefKey q = (PrefKey)p.c("skipped_phone_verification_time");
  public static final PrefKey r = (PrefKey)p.c("last_sent_confirmation_code_time");
  public static final PrefKey s = (PrefKey)p.c("last_sent_country_code");
  public static final PrefKey t = (PrefKey)p.c("last_sent_number");
  public static final PrefKey u = (PrefKey)b.c("force_fb4a_look_and_feel");
  public static final PrefKey v = (PrefKey)a.c("version_promo/");
  public static final PrefKey w = (PrefKey)v.c("dismissed_version");
  public static final PrefKey x = (PrefKey)v.c("dismissed_time");
  public static final PrefKey y = (PrefKey)a.c("contacts_upload/");
  public static final PrefKey z = (PrefKey)y.c("last_upload_failed");

  static
  {
    A = (PrefKey)y.c("invite_all/");
    B = (PrefKey)A.c("/last_dismissed_ms");
    C = (PrefKey)A.c("/times_dismissed");
    D = (PrefKey)A.c("/has_converted");
    E = (PrefKey)A.c("/last_converted");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.MessengerPrefKeys
 * JD-Core Version:    0.6.0
 */