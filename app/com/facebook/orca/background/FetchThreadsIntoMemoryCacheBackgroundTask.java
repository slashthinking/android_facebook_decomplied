package com.facebook.orca.background;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.background.BackgroundTaskRunnerCallback;
import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.RateLimiter;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.server.module.ThreadsQueue;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FetchThreadsIntoMemoryCacheBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = FetchThreadsIntoMemoryCacheBackgroundTask.class;
  private static final WtfToken b = new WtfToken();
  private final MeUserAuthDataStore c;
  private final DataCache d;
  private final RateLimiter e;
  private final OrcaServiceOperationFactory f;
  private final BroadcastReceiver g;
  private List<String> h = Collections.emptyList();

  public FetchThreadsIntoMemoryCacheBackgroundTask(MeUserAuthDataStore paramMeUserAuthDataStore, DataCache paramDataCache, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, LocalBroadcastManager paramLocalBroadcastManager, Clock paramClock)
  {
    super("FETCH_THREADS_INTO_MEMORY_CACHE");
    this.c = paramMeUserAuthDataStore;
    this.d = paramDataCache;
    this.e = new RateLimiter(paramClock, 30, 60000L);
    this.f = paramOrcaServiceOperationFactory;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.THREADS_SHOWN_IN_LIST");
    this.g = new FetchThreadsIntoMemoryCacheBackgroundTask.1(this);
    paramLocalBroadcastManager.a(this.g, localIntentFilter);
  }

  private void a(List<String> paramList)
  {
    this.h = paramList;
    e().b();
  }

  private String d()
  {
    Iterator localIterator = this.h.iterator();
    String str;
    ThreadSummary localThreadSummary;
    MessagesCollection localMessagesCollection;
    do
    {
      if (!localIterator.hasNext())
        break;
      str = (String)localIterator.next();
      localThreadSummary = this.d.b(str);
      localMessagesCollection = this.d.c(str);
    }
    while ((localThreadSummary != null) && (localMessagesCollection != null));
    while (true)
    {
      return str;
      str = null;
    }
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
      String str = d();
      i = 0;
      if (str == null)
        continue;
      i = 1;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    BLog.c(a, "Starting getThread (db)");
    String str = d();
    SimpleBackgroundResultFutureCallback localSimpleBackgroundResultFutureCallback = null;
    if (str == null);
    while (true)
    {
      return localSimpleBackgroundResultFutureCallback;
      if (!this.e.a())
      {
        BLog.a(b, a, "Hit in memory caching thread rate limit");
        localSimpleBackgroundResultFutureCallback = null;
        continue;
      }
      FetchThreadParams localFetchThreadParams = FetchThreadParams.newBuilder().a(ThreadCriteria.a(str)).a(DataFreshnessParam.STALE_DATA_OKAY).a(50).h();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
      ListenableFuture localListenableFuture = this.f.a("fetch_thread", localBundle).d();
      localSimpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(a);
      Futures.a(localListenableFuture, localSimpleBackgroundResultFutureCallback);
    }
  }

  public Set<String> g()
  {
    return ImmutableSet.b("FETCH_OUT_OF_DATE_THREADS");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask
 * JD-Core Version:    0.6.0
 */