package com.facebook.debug;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.SharedPrefKeys;

public class UiThreadWatchdog
  implements INeedInit
{
  private static final Class<?> a = UiThreadWatchdog.class;
  private final Clock b;
  private final UserActivityManager c;
  private final LocalBroadcastManager d;
  private final OrcaSharedPreferences e;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener f;
  private final Handler g;
  private HandlerThread h;
  private Handler i;
  private long j;
  private boolean k;
  private boolean l;
  private boolean m;

  public UiThreadWatchdog(UserActivityManager paramUserActivityManager, LocalBroadcastManager paramLocalBroadcastManager, OrcaSharedPreferences paramOrcaSharedPreferences, Clock paramClock)
  {
    this.c = paramUserActivityManager;
    this.d = paramLocalBroadcastManager;
    this.e = paramOrcaSharedPreferences;
    this.b = paramClock;
    this.g = new Handler(Looper.getMainLooper());
    this.d.a(new UiThreadWatchdog.1(this), new IntentFilter("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE"));
    this.k = this.c.a();
    this.f = new UiThreadWatchdog.2(this);
    this.e.a(this.f);
  }

  private void a(StringBuilder paramStringBuilder, String paramString, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    for (int n = 0; n < paramArrayOfStackTraceElement.length; n++)
    {
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("\tat ");
      paramStringBuilder.append(paramArrayOfStackTraceElement[n].toString());
      paramStringBuilder.append("\n");
    }
  }

  private void a(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      this.g.post(new UiThreadWatchdog.3(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void b()
  {
    try
    {
      this.k = this.c.a();
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void c()
  {
    while (true)
    {
      try
      {
        boolean bool1 = i();
        boolean bool2 = this.l;
        if (bool1 == bool2)
          return;
        if (bool1)
        {
          BLog.b(a, "Starting watchdog");
          this.h = new HandlerThread("UiThreadWatchdog");
          this.h.start();
          this.i = new Handler(this.h.getLooper());
          this.l = true;
          e();
          d();
          Looper.myQueue().addIdleHandler(new UiThreadWatchdog.4(this));
          continue;
        }
      }
      finally
      {
      }
      BLog.b(a, "Stopping watchdog");
      this.h.quit();
      this.h = null;
      this.i = null;
      this.l = false;
    }
  }

  private void d()
  {
    try
    {
      boolean bool = this.l;
      if (!bool);
      while (true)
      {
        return;
        this.i.postDelayed(new UiThreadWatchdog.5(this), 200L);
      }
    }
    finally
    {
    }
  }

  private void e()
  {
    if (!this.l);
    while (true)
    {
      return;
      this.g.postDelayed(new UiThreadWatchdog.6(this), 200L);
    }
  }

  private void f()
  {
    g();
  }

  private void g()
  {
    while (true)
    {
      try
      {
        boolean bool = this.l;
        if (!bool)
          return;
        this.k = this.c.a();
        if (this.k)
        {
          c();
          continue;
        }
      }
      finally
      {
      }
      this.j = this.b.a();
    }
  }

  private void h()
  {
    while (true)
    {
      try
      {
        boolean bool = this.l;
        if (!bool)
          return;
        this.k = this.c.a();
        if (this.k)
        {
          c();
          continue;
        }
      }
      finally
      {
      }
      long l1 = this.b.a() - this.j;
      if (l1 >= 600L)
      {
        StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UI Thread has been stuck for more than ").append(l1).append(" ms.");
        localStringBuilder.append("Current UI thread stack\n");
        a(localStringBuilder, "  ", arrayOfStackTraceElement);
        BLog.d(a, localStringBuilder.toString());
      }
    }
  }

  private boolean i()
  {
    if ((this.m) && (!this.k));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void i_()
  {
    a(this.e.a(SharedPrefKeys.q, false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.debug.UiThreadWatchdog
 * JD-Core Version:    0.6.2
 */