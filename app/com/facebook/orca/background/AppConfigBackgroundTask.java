package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.ConfigPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.server.module.ThreadsQueue;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;

public class AppConfigBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = AppConfigBackgroundTask.class;
  private final MeUserAuthDataStore b;
  private final OrcaSharedPreferences c;
  private final OrcaServiceOperationFactory d;
  private final Clock e;

  public AppConfigBackgroundTask(MeUserAuthDataStore paramMeUserAuthDataStore, OrcaSharedPreferences paramOrcaSharedPreferences, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Clock paramClock)
  {
    super("APP_CONFIG");
    this.b = paramMeUserAuthDataStore;
    this.c = paramOrcaSharedPreferences;
    this.d = paramOrcaServiceOperationFactory;
    this.e = paramClock;
  }

  public Set<Class<? extends Annotation>> a()
  {
    return ImmutableSet.b(ThreadsQueue.class);
  }

  public boolean b()
  {
    boolean bool1 = this.b.d();
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      long l = this.c.a(ConfigPrefKeys.b, 0L);
      boolean bool2 = this.e.a() - l < 3600000L;
      i = 0;
      if (!bool2)
        continue;
      i = 1;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    BLog.c(a, "Starting fetch");
    ListenableFuture localListenableFuture = this.d.a("get_app_info", new Bundle()).d();
    SimpleBackgroundResultFutureCallback localSimpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(a);
    Futures.a(localListenableFuture, localSimpleBackgroundResultFutureCallback);
    return localSimpleBackgroundResultFutureCallback;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.AppConfigBackgroundTask
 * JD-Core Version:    0.6.0
 */