package com.facebook.katana.orca;

import android.content.SharedPreferences;
import android.net.Uri;
import com.facebook.katana.SettingsActivity;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.notify.MessagingNotificationPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class FbAndroidMessagingNotificationPreferences
  implements MessagingNotificationPreferences
{
  private final OrcaSharedPreferences a;
  private final SharedPreferences b;

  public FbAndroidMessagingNotificationPreferences(SharedPreferences paramSharedPreferences, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramSharedPreferences;
    this.a = paramOrcaSharedPreferences;
  }

  public boolean a()
  {
    return this.b.getBoolean("vibrate", true);
  }

  public boolean b()
  {
    Uri localUri = d();
    if ((localUri != null) && (!localUri.equals(Uri.EMPTY)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean c()
  {
    return this.b.getBoolean("use_led", true);
  }

  public Uri d()
  {
    String str = this.b.getString("ringtone", SettingsActivity.a);
    if (StringUtil.a(str));
    for (Uri localUri = Uri.EMPTY; ; localUri = Uri.parse(str))
      return localUri;
  }

  public int e()
  {
    return 2130838953;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences
 * JD-Core Version:    0.6.0
 */