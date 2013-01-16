package com.facebook.orca.notify;

import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NotificationSettingsUtil
{
  private final OrcaSharedPreferences a;

  public NotificationSettingsUtil(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public NotificationSetting a()
  {
    return NotificationSetting.b(this.a.a(MessagesPrefKeys.m, 0L));
  }

  public NotificationSetting a(String paramString)
  {
    PrefKey localPrefKey = MessagesPrefKeys.a(paramString);
    return NotificationSetting.b(this.a.a(localPrefKey, 0L));
  }

  public boolean a(NotificationSetting paramNotificationSetting)
  {
    long l = paramNotificationSetting.b();
    if ((paramNotificationSetting.a()) && ((l == -1L) || (l < System.currentTimeMillis() / 1000L)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Date b()
  {
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.setTime(new Date());
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    int i = localCalendar.get(11);
    if (i < 8)
      localCalendar.add(10, 8 - i);
    while (true)
    {
      return localCalendar.getTime();
      localCalendar.add(10, 32 - i);
    }
  }

  public boolean b(NotificationSetting paramNotificationSetting)
  {
    long l = paramNotificationSetting.b();
    if ((paramNotificationSetting.a()) && (l != -1L) && (l > System.currentTimeMillis() / 1000L));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.NotificationSettingsUtil
 * JD-Core Version:    0.6.0
 */