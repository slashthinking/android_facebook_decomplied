package com.facebook.katana.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.faceweb.FacewebAssassin;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.orca.inject.FbInjector;

public class BackgroundDetectionService extends Service
{
  private static PendingIntent a = null;
  private static boolean b;
  private static boolean c = false;
  private static long d = 0L;

  protected static void a(Context paramContext)
  {
    monitorenter;
    try
    {
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (a != null)
      {
        localAlarmManager.cancel(a);
        a.cancel();
        a = null;
      }
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

  protected static void a(Context paramContext, Uri paramUri, int paramInt)
  {
    monitorenter;
    try
    {
      a(paramContext);
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      Intent localIntent = new Intent(paramContext, BackgroundDetectionService.class);
      localIntent.setData(paramUri);
      a = PendingIntent.getService(paramContext, 0, localIntent, 0);
      localAlarmManager.set(2, SystemClock.elapsedRealtime() + paramInt, a);
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

  public static boolean a()
  {
    return b;
  }

  public static void b(Context paramContext)
  {
    c = false;
    d = SystemClock.elapsedRealtime();
    a(paramContext, BackgroundDetectionService.URI.a, 5000);
  }

  public static boolean b()
  {
    int i = 1;
    if (c);
    while (true)
    {
      return i;
      if (d > 0L)
      {
        if (SystemClock.elapsedRealtime() - d < 5000L)
          continue;
        i = 0;
        continue;
      }
      i = 0;
    }
  }

  public static void c(Context paramContext)
  {
    c = true;
    d = 0L;
    a(paramContext);
    f(paramContext);
  }

  protected static void d(Context paramContext)
  {
    b = true;
    ((PerformanceLogger)FbInjector.a(paramContext).a(PerformanceLogger.class)).c();
    FBLocationManager.a();
    a(paramContext, BackgroundDetectionService.URI.b, 540000);
  }

  protected static void e(Context paramContext)
  {
    FacewebAssassin.a();
  }

  protected static void f(Context paramContext)
  {
    if (b)
    {
      b = false;
      AppSession localAppSession = AppSession.a(paramContext, false);
      PhotoCleanupService.a(paramContext);
      if (localAppSession != null)
        localAppSession.b(paramContext, 0, false);
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = 2;
    if (paramIntent == null)
    {
      ErrorReporting.a("BackgroundDetectionService", "started with null intent");
      i = 1;
    }
    while (true)
    {
      return i;
      if (BackgroundDetectionService.URI.a.equals(paramIntent.getData()))
      {
        d(this);
        continue;
      }
      if (BackgroundDetectionService.URI.b.equals(paramIntent.getData()))
      {
        e(this);
        continue;
      }
      ErrorReporting.a("BackgroundDetectionService", "unexpected intent" + paramIntent.toString());
      i = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.BackgroundDetectionService
 * JD-Core Version:    0.6.0
 */