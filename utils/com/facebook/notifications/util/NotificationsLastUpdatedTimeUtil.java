package com.facebook.notifications.util;

import com.facebook.notifications.prefs.NotificationsPrefs;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;

public class NotificationsLastUpdatedTimeUtil
{
  private final OrcaSharedPreferences a;

  public NotificationsLastUpdatedTimeUtil(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public long a()
  {
    return this.a.a(NotificationsPrefs.b, -1L);
  }

  public void a(long paramLong)
  {
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(NotificationsPrefs.b, paramLong);
    localEditor.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil
 * JD-Core Version:    0.6.2
 */