package com.facebook.abtest.qe.service.background;

import android.os.Bundle;
import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.abtest.qe.service.module.QuickExperimentQueue;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Provider;

public class SyncQuickExperimentBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = SyncQuickExperimentBackgroundTask.class;
  private final Provider<String> b;
  private final OrcaSharedPreferences c;
  private final OrcaServiceOperationFactory d;
  private final LocaleUtil e;
  private final Clock f;

  public SyncQuickExperimentBackgroundTask(Provider<String> paramProvider, OrcaSharedPreferences paramOrcaSharedPreferences, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, LocaleUtil paramLocaleUtil, Clock paramClock)
  {
    super("SYNC_QUICK_EXPERIMENT");
    this.b = paramProvider;
    this.c = paramOrcaSharedPreferences;
    this.d = paramOrcaServiceOperationFactory;
    this.e = paramLocaleUtil;
    this.f = paramClock;
  }

  public Set<Class<? extends Annotation>> a()
  {
    return ImmutableSet.b(QuickExperimentQueue.class);
  }

  public boolean b()
  {
    long l1 = this.f.a();
    long l2 = this.c.a(QuickExperimentConfigPrefKeys.b, 0L);
    String str1 = this.e.a();
    String str2 = this.c.a(QuickExperimentConfigPrefKeys.c, str1);
    if ((this.b.b() != null) && ((l1 - l2 > 3600000L) || (!str2.equals(str1))));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public ListenableFuture<BackgroundResult> c()
  {
    BLog.c(a, "Starting fetch");
    ListenableFuture localListenableFuture = this.d.a("sync_qe", new Bundle()).d();
    SyncQuickExperimentBackgroundTask.BackgroundResultFutureCallback localBackgroundResultFutureCallback = new SyncQuickExperimentBackgroundTask.BackgroundResultFutureCallback(null);
    Futures.a(localListenableFuture, localBackgroundResultFutureCallback);
    return localBackgroundResultFutureCallback;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask
 * JD-Core Version:    0.6.2
 */