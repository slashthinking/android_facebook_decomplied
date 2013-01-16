package com.facebook.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.os.PowerManager;
import android.view.WindowManager;
import com.facebook.orca.activity.FbActivityish;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import javax.inject.Provider;

public class AnalyticsLogger
  implements INeedInit
{
  private static final Class<?> a = AnalyticsLogger.class;
  private static final WtfToken b = new WtfToken();
  private String A;
  private final Context c;
  private final Provider<String> d;
  private final AnalyticsConfig e;
  private final AndroidThreadUtil f;
  private final Provider<AnalyticsServiceOperation> g;
  private final TimeSpentAnalyticsClientEvent h;
  private final PowerManager i;
  private final WindowManager j;
  private final Clock k;
  private final AnalyticsDeviceUtils l;
  private final Handler m;
  private final AnalyticsLogger.MyActivityListener n;
  private BroadcastReceiver o;
  private IntentFilter p;
  private boolean q = true;
  private boolean r = true;
  private boolean s = false;
  private AnalyticsConfig.Level t = AnalyticsConfig.Level.NONE;
  private Queue<HoneyAnalyticsEvent> u = new LinkedList();
  private Set<FbActivityish> v = Sets.a();
  private Runnable w = null;
  private int x = -1;
  private long y = -1L;
  private NetworkInfo z = null;

  public AnalyticsLogger(Context paramContext, Provider<String> paramProvider, AnalyticsConfig paramAnalyticsConfig, AndroidThreadUtil paramAndroidThreadUtil, Provider<AnalyticsServiceOperation> paramProvider1, PowerManager paramPowerManager, WindowManager paramWindowManager, Clock paramClock, AnalyticsDeviceUtils paramAnalyticsDeviceUtils)
  {
    this.c = paramContext;
    this.d = paramProvider;
    this.e = paramAnalyticsConfig;
    this.f = paramAndroidThreadUtil;
    this.g = paramProvider1;
    this.i = paramPowerManager;
    this.j = paramWindowManager;
    this.k = paramClock;
    this.h = new TimeSpentAnalyticsClientEvent(paramClock.a());
    this.l = paramAnalyticsDeviceUtils;
    this.n = new AnalyticsLogger.MyActivityListener(this);
    paramAndroidThreadUtil.a();
    this.m = new Handler();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    this.c.registerReceiver(new AnalyticsLogger.TimeChangeReceiver(this), localIntentFilter);
  }

  private HoneyClientEvent a(long paramLong, AnalyticEventNames.AppStateNames paramAppStateNames)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("app_state").b("state", paramAppStateNames.toString()).d("app");
    localHoneyClientEvent.a(paramLong);
    return localHoneyClientEvent;
  }

  private void a(int paramInt)
  {
    try
    {
      b(new HoneyClientEvent("orientation").a("orientation", paramInt).b("module", "device"));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(long paramLong)
  {
    if (this.q)
    {
      this.q = false;
      b(a(paramLong, AnalyticEventNames.AppStateNames.FOREGROUNDED).a("key_ui_event", "1").a("new_session", "1"));
    }
  }

  private void a(long paramLong, String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("session_end");
    localHoneyClientEvent.h(paramString).a("session_timeout", "1").a("stop_upload", "1").a(paramLong);
    this.l.a(this.z, localHoneyClientEvent);
    b(localHoneyClientEvent);
    this.r = true;
  }

  private void a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = c(paramContext);
    if ((localNetworkInfo != null) && (localNetworkInfo.getState() == NetworkInfo.State.DISCONNECTED))
      this.r = true;
    if ((!this.l.a(this.z, localNetworkInfo)) || (this.r))
    {
      a(localNetworkInfo);
      this.z = localNetworkInfo;
      this.r = false;
    }
  }

  private void a(NetworkInfo paramNetworkInfo)
  {
    try
    {
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("connection_change");
      localHoneyClientEvent.d("device");
      this.l.a(localHoneyClientEvent);
      this.l.a(localHoneyClientEvent, this.z);
      this.l.a(this.z, localHoneyClientEvent);
      if (paramNetworkInfo != null)
        localHoneyClientEvent.b("state", paramNetworkInfo.getState().toString());
      b(localHoneyClientEvent);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(AnalyticsSubModuleActivity paramAnalyticsSubModuleActivity)
  {
    a(paramAnalyticsSubModuleActivity.a(), true);
  }

  private void a(TimeSpentAnalyticsClientEvent.Dispatch paramDispatch)
  {
    try
    {
      if ((paramDispatch == TimeSpentAnalyticsClientEvent.Dispatch.FORCE) || (paramDispatch == TimeSpentAnalyticsClientEvent.Dispatch.FORCE_RESET))
        this.h.c();
      while (true)
      {
        HoneyClientEvent localHoneyClientEvent = this.h.b();
        if (localHoneyClientEvent != null)
          b(localHoneyClientEvent);
        if (paramDispatch == TimeSpentAnalyticsClientEvent.Dispatch.FORCE_RESET)
          this.h.a();
        return;
        if (paramDispatch == TimeSpentAnalyticsClientEvent.Dispatch.CLOCK_RESET)
          this.h.b(this.k.a());
      }
    }
    finally
    {
    }
  }

  private void b(long paramLong)
  {
    try
    {
      this.y = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void b(Context paramContext)
  {
    if (this.o == null)
    {
      this.o = new AnalyticsLogger.6(this);
      this.p = new IntentFilter();
      this.p.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      paramContext.registerReceiver(this.o, this.p);
    }
  }

  private void b(AnalyticsSubModuleActivity paramAnalyticsSubModuleActivity)
  {
    a(paramAnalyticsSubModuleActivity.a());
  }

  private void b(FbActivityish paramFbActivityish)
  {
  }

  private NetworkInfo c(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }

  private void c(long paramLong)
  {
    try
    {
      if (this.h.a(paramLong))
        a(TimeSpentAnalyticsClientEvent.Dispatch.PASSIVE);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void c(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if (-1L == paramHoneyAnalyticsEvent.b())
      paramHoneyAnalyticsEvent.a(this.k.a());
    paramHoneyAnalyticsEvent.a(this.q);
  }

  private void c(FbActivityish paramFbActivityish)
  {
    try
    {
      long l1 = this.k.a();
      this.v.add(paramFbActivityish);
      h();
      a(l1);
      if ((paramFbActivityish instanceof AnalyticsSubModuleActivity))
        a((AnalyticsSubModuleActivity)paramFbActivityish);
      while (true)
      {
        return;
        if (!(paramFbActivityish instanceof ManualAnalyticsNavigationActivity))
          a(paramFbActivityish);
        this.f.c(new AnalyticsLogger.1(this));
      }
    }
    finally
    {
    }
  }

  private void d(long paramLong)
  {
    try
    {
      if (!this.q)
      {
        AnalyticEventNames.AppStateNames localAppStateNames = AnalyticEventNames.AppStateNames.BACKGROUNDED;
        if (!this.i.isScreenOn())
          localAppStateNames = AnalyticEventNames.AppStateNames.RESIGN;
        HoneyClientEvent localHoneyClientEvent = a(paramLong, localAppStateNames);
        localHoneyClientEvent.a("truncate_batch", "1").a("key_ui_event", "1").a("new_session", "1");
        this.l.a(this.z, localHoneyClientEvent);
        b(localHoneyClientEvent);
        this.q = true;
        this.A = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void d(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if ("AUTO_SET".equals(paramHoneyAnalyticsEvent.c()))
      paramHoneyAnalyticsEvent.c(g());
  }

  private void d(FbActivityish paramFbActivityish)
  {
    try
    {
      if ((paramFbActivityish instanceof AnalyticsSubModuleActivity))
        b((AnalyticsSubModuleActivity)paramFbActivityish);
      if ((this.v.remove(paramFbActivityish)) && (this.v.isEmpty()))
      {
        long l1 = this.k.a();
        if (this.w != null)
        {
          BLog.a(b, a, "Previous sendToBackgroundDetector is still alive");
          this.m.removeCallbacks(this.w);
          this.w = null;
        }
        if (!this.s)
        {
          this.w = new AnalyticsLogger.2(this, l1);
          this.m.postDelayed(this.w, 5000L);
        }
        String str = paramFbActivityish.e();
        if (this.s)
        {
          a(l1, str);
          this.s = false;
          this.t = AnalyticsConfig.Level.NONE;
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void e(FbActivityish paramFbActivityish)
  {
  }

  private boolean e(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if (((paramHoneyAnalyticsEvent instanceof HoneyClientEvent)) && ("wildfire".equals(((HoneyClientEvent)paramHoneyAnalyticsEvent).h())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void f(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    this.f.c(new AnalyticsLogger.4(this, paramHoneyAnalyticsEvent));
  }

  private String g()
  {
    return (String)this.d.b();
  }

  private void g(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    this.f.c(new AnalyticsLogger.5(this, paramHoneyAnalyticsEvent));
  }

  private void h()
  {
    if (this.w != null)
    {
      this.m.removeCallbacks(this.w);
      this.w = null;
    }
  }

  private void h(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    try
    {
      this.u.add(paramHoneyAnalyticsEvent);
      if (this.u.size() > 100)
        i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void i()
  {
    try
    {
      if (this.u != null)
      {
        Queue localQueue = this.u;
        this.u = null;
        this.f.c(new AnalyticsLogger.3(this, localQueue));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void i(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    this.f.b();
    d(paramHoneyAnalyticsEvent);
    ((AnalyticsServiceOperation)this.g.b()).a(new AnalyticsServiceEvent(paramHoneyAnalyticsEvent));
  }

  public void a(Context paramContext, HoneyClientEvent paramHoneyClientEvent)
  {
    try
    {
      paramHoneyClientEvent.a(this.k.a());
      paramHoneyClientEvent.d(this.A);
      if ((paramContext instanceof FbActivityish))
        paramHoneyClientEvent.h(((FbActivityish)paramContext).e());
      b(paramHoneyClientEvent);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if (paramHoneyAnalyticsEvent == null);
    while (true)
    {
      return;
      try
      {
        c(paramHoneyAnalyticsEvent);
        if (this.u != null)
        {
          h(paramHoneyAnalyticsEvent);
          continue;
        }
      }
      finally
      {
      }
      f(paramHoneyAnalyticsEvent);
    }
  }

  public void a(FbActivityish paramFbActivityish)
  {
    while (true)
    {
      try
      {
        long l1 = this.k.a();
        Object localObject3;
        Object localObject2;
        String str2;
        if ((paramFbActivityish instanceof AnalyticsActivity))
        {
          String str4 = ((AnalyticsActivity)paramFbActivityish).a();
          localObject3 = str4;
          localObject2 = null;
          str2 = str4;
          if ((paramFbActivityish instanceof AnalyticsActivityContentUri))
          {
            str3 = ((AnalyticsActivityContentUri)paramFbActivityish).b();
            HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("navigation").b("dest_module", str2).h(paramFbActivityish.e());
            if (str3 != null)
              localHoneyClientEvent.b("dest_module_uri", str3);
            if (localObject2 != null)
              localHoneyClientEvent.b("dest_module_class", (String)localObject2);
            if (this.A != null)
              localHoneyClientEvent.d(this.A);
            b(localHoneyClientEvent.a(l1).a("resume_upload", "1"));
            this.A = ((String)localObject3);
          }
        }
        else
        {
          String str1 = paramFbActivityish.getClass().getSimpleName();
          localObject2 = str1;
          str2 = "unknown";
          localObject3 = str1;
          continue;
        }
      }
      finally
      {
      }
      String str3 = null;
    }
  }

  public void a(String paramString)
  {
    try
    {
      b(c(paramString));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      b(c(paramString, paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Map<String, String> paramMap)
  {
    HoneyClientEvent localHoneyClientEvent;
    try
    {
      localHoneyClientEvent = new HoneyClientEvent("login");
      localHoneyClientEvent.a("resume_upload", "1");
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localHoneyClientEvent.b((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    finally
    {
    }
    b(localHoneyClientEvent);
    i();
    a(TimeSpentAnalyticsClientEvent.Dispatch.FORCE_RESET);
  }

  public AnalyticsLogger.MyActivityListener b()
  {
    return this.n;
  }

  public void b(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if (paramHoneyAnalyticsEvent == null);
    while (true)
    {
      return;
      try
      {
        c(paramHoneyAnalyticsEvent);
        if (this.u != null)
        {
          h(paramHoneyAnalyticsEvent.a("startup_core", "1"));
          continue;
        }
      }
      finally
      {
      }
      g(paramHoneyAnalyticsEvent);
    }
  }

  public void b(String paramString)
  {
    try
    {
      a(c(paramString));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(String paramString, boolean paramBoolean)
  {
    try
    {
      a(c(paramString, paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public HoneyClientEvent c(String paramString)
  {
    return new HoneyClientEvent("hide_module").b("dest_module", paramString);
  }

  public HoneyClientEvent c(String paramString, boolean paramBoolean)
  {
    return new HoneyClientEvent("show_module").b("dest_module", paramString).a("is_modal", paramBoolean);
  }

  public void c()
  {
    try
    {
      this.s = true;
      b(new HoneyClientEvent("logout"));
      a(TimeSpentAnalyticsClientEvent.Dispatch.FORCE_RESET);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d()
  {
    try
    {
      this.s = false;
      b(new HoneyClientEvent("silent_login").a("resume_upload", "1"));
      i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String e()
  {
    return this.l.a(this.z);
  }

  public void i_()
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger
 * JD-Core Version:    0.6.2
 */