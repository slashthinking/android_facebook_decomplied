package com.facebook.orca.prefs;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.server.SetSettingsParams;
import com.facebook.orca.server.SetSettingsParamsBuilder;

public class GlobalNotificationPrefsSynchronizer
{
  private static Class<?> a = GlobalNotificationPrefsSynchronizer.class;
  private static long b = 4000L;
  private static long c = 600000L;
  private static long d = 5L;
  private final Handler e;
  private final MeUserAuthDataStore f;
  private final OrcaServiceOperation g;
  private final OrcaSharedPreferences h;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener i;
  private SetSettingsParamsBuilder j;
  private SetSettingsParams k;
  private long l;
  private int m;
  private volatile boolean n;

  public GlobalNotificationPrefsSynchronizer(MeUserAuthDataStore paramMeUserAuthDataStore, OrcaSharedPreferences paramOrcaSharedPreferences, OrcaServiceOperation paramOrcaServiceOperation)
  {
    this.f = paramMeUserAuthDataStore;
    this.h = paramOrcaSharedPreferences;
    this.g = paramOrcaServiceOperation;
    this.e = new Handler();
    this.i = new GlobalNotificationPrefsSynchronizer.1(this);
    paramOrcaSharedPreferences.a(this.i);
    paramOrcaServiceOperation.a(new GlobalNotificationPrefsSynchronizer.2(this));
    paramOrcaServiceOperation.a(true);
  }

  private SetSettingsParamsBuilder a()
  {
    if (this.j == null)
    {
      this.j = new SetSettingsParamsBuilder();
      this.l = b;
      b();
    }
    return this.j;
  }

  private void a(PrefKey paramPrefKey)
  {
    if (this.n);
    while (true)
    {
      return;
      if ((!MessagesPrefKeys.m.equals(paramPrefKey)) || (!this.f.d()))
        continue;
      NotificationSetting localNotificationSetting = NotificationSetting.b(this.h.a(MessagesPrefKeys.m, 0L));
      monitorenter;
      try
      {
        SetSettingsParamsBuilder localSetSettingsParamsBuilder = a();
        localSetSettingsParamsBuilder.a(true);
        localSetSettingsParamsBuilder.a(localNotificationSetting);
        monitorexit;
        continue;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
    }
    throw localObject;
  }

  private void a(Exception paramException)
  {
    monitorenter;
    try
    {
      if (this.j == null)
        this.j = new SetSettingsParamsBuilder();
      this.j.a(true);
      this.j.a(this.k.b());
      this.k = null;
      if (this.m < d)
      {
        this.m = (1 + this.m);
        this.l = Math.min(2L * this.l, c);
        BLog.c(a, "Failed to update thread notification settings. Retrying in " + this.l / 1000L + " seconds");
        b();
      }
      while (true)
      {
        return;
        this.m = 0;
        this.l = b;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void b()
  {
    this.e.postDelayed(new GlobalNotificationPrefsSynchronizer.3(this), this.l);
  }

  private void c()
  {
    monitorenter;
    try
    {
      SetSettingsParamsBuilder localSetSettingsParamsBuilder = this.j;
      if (localSetSettingsParamsBuilder == null);
      while (true)
      {
        return;
        if ((!this.f.d()) || (this.g.c() != OrcaServiceOperation.State.INIT))
          continue;
        this.k = this.j.c();
        this.j = null;
        BLog.b(a, "Starting update");
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("setSettingsParams", this.k);
        this.g.a("update_user_settings", localBundle);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void d()
  {
    monitorenter;
    try
    {
      this.k = null;
      this.l = b;
      this.m = 0;
      c();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(NotificationSetting paramNotificationSetting)
  {
    this.n = true;
    try
    {
      monitorenter;
      try
      {
        if ((this.k != null) || (this.j != null))
          monitorexit;
        for (this.n = false; ; this.n = false)
        {
          return;
          NotificationSetting localNotificationSetting = NotificationSetting.b(this.h.a(MessagesPrefKeys.m, 0L));
          if (paramNotificationSetting.d() != localNotificationSetting.d())
          {
            OrcaSharedPreferences.Editor localEditor = this.h.b();
            localEditor.a(MessagesPrefKeys.m, paramNotificationSetting.d());
            localEditor.a();
          }
          monitorexit;
        }
      }
      finally
      {
        monitorexit;
      }
    }
    finally
    {
      this.n = false;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.GlobalNotificationPrefsSynchronizer
 * JD-Core Version:    0.6.0
 */