package com.facebook.katana.service.autoupdate;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.common.util.ProcessUtil;
import com.facebook.config.AppBuildInfo;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;

public class AutoUpdateServiceStarter
{
  private final Context a;
  private final Clock b;
  private final AlarmManager c;
  private final OrcaSharedPreferences d;
  private final AppBuildInfo e;
  private final ProcessUtil f;
  private String g;

  public AutoUpdateServiceStarter(AlarmManager paramAlarmManager, AppBuildInfo paramAppBuildInfo, String paramString, Context paramContext, Clock paramClock, OrcaSharedPreferences paramOrcaSharedPreferences, ProcessUtil paramProcessUtil)
  {
    this.c = paramAlarmManager;
    this.e = paramAppBuildInfo;
    this.g = paramString;
    this.a = paramContext;
    this.b = paramClock;
    this.d = paramOrcaSharedPreferences;
    this.f = paramProcessUtil;
  }

  public void a()
  {
    AppInitLockHelper.a(this.a);
    if ((this.e.b() == this.e.c()) || (!this.f.a(this.a.getPackageName())));
    while (true)
    {
      return;
      Intent localIntent = new Intent(this.a, AutoUpdateAppObjectFetchService.class);
      localIntent.putExtra("build_tag", this.g);
      PendingIntent localPendingIntent = PendingIntent.getService(this.a, 0, localIntent, 0);
      long l1 = this.d.a(AutoUpdateConstants.b, 0L);
      long l2 = this.b.a();
      if (l2 - l1 <= 120000L)
        continue;
      this.c.cancel(localPendingIntent);
      this.c.setInexactRepeating(3, SystemClock.elapsedRealtime(), 3600000L, localPendingIntent);
      this.d.b().a(AutoUpdateConstants.b, l2).a();
      this.a.startService(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateServiceStarter
 * JD-Core Version:    0.6.0
 */