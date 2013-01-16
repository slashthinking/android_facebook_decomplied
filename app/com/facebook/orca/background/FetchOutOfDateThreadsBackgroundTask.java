package com.facebook.orca.background;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.RateLimiter;
import com.facebook.orca.database.DbCache;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.server.module.ThreadsQueue;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FetchOutOfDateThreadsBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = FetchOutOfDateThreadsBackgroundTask.class;
  private static final WtfToken b = new WtfToken();
  private final MeUserAuthDataStore c;
  private final DbCache d;
  private final OrcaServiceOperationFactory e;
  private final RateLimiter f;
  private final BroadcastReceiver g;

  public FetchOutOfDateThreadsBackgroundTask(MeUserAuthDataStore paramMeUserAuthDataStore, DbCache paramDbCache, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, LocalBroadcastManager paramLocalBroadcastManager, Clock paramClock)
  {
    super("FETCH_OUT_OF_DATE_THREADS");
    this.c = paramMeUserAuthDataStore;
    this.d = paramDbCache;
    this.e = paramOrcaServiceOperationFactory;
    this.f = new RateLimiter(paramClock, 20, 60000L);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.ACTION_THREAD_UPDATED_FOR_UI");
    this.g = new FetchOutOfDateThreadsBackgroundTask.1(this);
    paramLocalBroadcastManager.a(this.g, localIntentFilter);
  }

  public Set<Class<? extends Annotation>> a()
  {
    return ImmutableSet.b(ThreadsQueue.class);
  }

  public boolean b()
  {
    User localUser = this.c.g();
    int i = 0;
    if (localUser == null);
    while (true)
    {
      return i;
      boolean bool = this.d.b(FolderName.b).isEmpty();
      i = 0;
      if (bool)
        continue;
      i = 1;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    BLog.c(a, "Starting fetch thread (server)");
    List localList = this.d.b(FolderName.b);
    boolean bool = localList.isEmpty();
    SimpleBackgroundResultFutureCallback localSimpleBackgroundResultFutureCallback = null;
    if (bool);
    while (true)
    {
      return localSimpleBackgroundResultFutureCallback;
      if (!this.f.a())
      {
        BLog.a(b, a, "Hit fetch thread rate limit");
        localSimpleBackgroundResultFutureCallback = null;
        continue;
      }
      String str = (String)localList.iterator().next();
      FetchThreadParams localFetchThreadParams = FetchThreadParams.newBuilder().a(ThreadCriteria.a(str)).a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(50).h();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
      ListenableFuture localListenableFuture = this.e.a("fetch_thread", localBundle).d();
      localSimpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(a);
      Futures.a(localListenableFuture, localSimpleBackgroundResultFutureCallback);
    }
  }

  public Set<String> g()
  {
    return ImmutableSet.b("FETCH_THREAD_LIST");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.FetchOutOfDateThreadsBackgroundTask
 * JD-Core Version:    0.6.0
 */