package com.facebook.katana.dialog;

import android.content.Context;
import com.facebook.katana.provider.KeyValueManager;

class InstallMessengerApkActivity$ShortcutGating
{
  private static ShortcutGating a;
  private long b;
  private long c;

  private InstallMessengerApkActivity$ShortcutGating(Context paramContext)
  {
    this.c = KeyValueManager.a(paramContext, InstallMessengerApkActivity.ShortcutGating.PrefKeys.SHORTCUT_TIMES_SHOWN.name(), 0L);
    this.b = KeyValueManager.a(paramContext, InstallMessengerApkActivity.ShortcutGating.PrefKeys.SHORTCUT_LAST_SHOWN.name(), 0L);
  }

  public static ShortcutGating a(Context paramContext)
  {
    if (a == null)
      a = new ShortcutGating(paramContext);
    return a;
  }

  public boolean b(Context paramContext)
  {
    long l = System.currentTimeMillis() / 1000L - this.b;
    if ((this.c < 3L) && ((this.b == 0L) || (l >= 86400L)) && (!KeyValueManager.a(paramContext, InstallMessengerApkActivity.ShortcutGating.PrefKeys.SHORTCUT_CONVERTED.name())));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void c(Context paramContext)
  {
    KeyValueManager.a(paramContext, InstallMessengerApkActivity.ShortcutGating.PrefKeys.SHORTCUT_CONVERTED.name(), Boolean.valueOf(true));
  }

  public void d(Context paramContext)
  {
    this.c = (1L + this.c);
    this.b = (System.currentTimeMillis() / 1000L);
    KeyValueManager.a(paramContext, InstallMessengerApkActivity.ShortcutGating.PrefKeys.SHORTCUT_TIMES_SHOWN.name(), Long.valueOf(this.c));
    KeyValueManager.a(paramContext, InstallMessengerApkActivity.ShortcutGating.PrefKeys.SHORTCUT_LAST_SHOWN.name(), Long.valueOf(this.b));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.InstallMessengerApkActivity.ShortcutGating
 * JD-Core Version:    0.6.0
 */