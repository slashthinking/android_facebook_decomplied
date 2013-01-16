package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.RateLimiter;
import com.facebook.orca.database.DbCache;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.module.ThreadsQueue;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.FolderType;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Provider;

public class FetchThreadListBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = FetchThreadListBackgroundTask.class;
  private static final WtfToken b = new WtfToken();
  private static final WtfToken c = new WtfToken();
  private final MeUserAuthDataStore d;
  private final Provider<FolderType> e;
  private final DbCache f;
  private final DataCache g;
  private final RateLimiter h;
  private final OrcaServiceOperationFactory i;

  public FetchThreadListBackgroundTask(MeUserAuthDataStore paramMeUserAuthDataStore, Provider<FolderType> paramProvider, DbCache paramDbCache, DataCache paramDataCache, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Clock paramClock)
  {
    super("FETCH_THREAD_LIST");
    this.d = paramMeUserAuthDataStore;
    this.e = paramProvider;
    this.f = paramDbCache;
    this.g = paramDataCache;
    this.i = paramOrcaServiceOperationFactory;
    this.h = new RateLimiter(paramClock, 10, 60000L);
  }

  private DataFreshnessParam a(FolderName paramFolderName)
  {
    DataFreshnessParam localDataFreshnessParam;
    if (!this.f.a(paramFolderName))
      localDataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
    while (true)
    {
      return localDataFreshnessParam;
      if (this.g.c(paramFolderName))
      {
        localDataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
        continue;
      }
      localDataFreshnessParam = null;
    }
  }

  public Set<Class<? extends Annotation>> a()
  {
    return ImmutableSet.b(ThreadsQueue.class);
  }

  public boolean b()
  {
    int j;
    if (this.d.g() == null)
      j = 0;
    while (true)
    {
      return j;
      FolderName localFolderName = FolderName.a((FolderType)this.e.b());
      if (localFolderName == FolderName.a)
      {
        BLog.a(b, a, "User not authenticated to access folders");
        j = 0;
        continue;
      }
      if (a(localFolderName) == null)
      {
        j = 0;
        continue;
      }
      j = 1;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    FolderName localFolderName = FolderName.a((FolderType)this.e.b());
    DataFreshnessParam localDataFreshnessParam = a(localFolderName);
    SimpleBackgroundResultFutureCallback localSimpleBackgroundResultFutureCallback;
    if (localDataFreshnessParam == null)
      localSimpleBackgroundResultFutureCallback = null;
    while (true)
    {
      return localSimpleBackgroundResultFutureCallback;
      if (!this.h.a())
      {
        BLog.a(c, a, "Hit fetch thread list rate limit");
        localSimpleBackgroundResultFutureCallback = null;
        continue;
      }
      BLog.c(a, "Starting fetch threads (" + localDataFreshnessParam + ")");
      FetchThreadListParams localFetchThreadListParams = FetchThreadListParams.newBuilder().a(localDataFreshnessParam).a(localFolderName).f();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadListParams", localFetchThreadListParams);
      ListenableFuture localListenableFuture = this.i.a("fetch_thread_list", localBundle).d();
      localSimpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(a);
      Futures.a(localListenableFuture, localSimpleBackgroundResultFutureCallback);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.FetchThreadListBackgroundTask
 * JD-Core Version:    0.6.0
 */