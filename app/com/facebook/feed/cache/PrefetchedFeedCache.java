package com.facebook.feed.cache;

import com.facebook.feed.db.DbPrefetchFeedHandler;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;

public class PrefetchedFeedCache
{
  public static Class<?> a = PrefetchedFeedCache.class;
  private final Map<NewsFeedType, FetchNewsFeedResult> b = Maps.a();
  private final DbPrefetchFeedHandler c;
  private final Clock d;

  public PrefetchedFeedCache(DbPrefetchFeedHandler paramDbPrefetchFeedHandler, Clock paramClock)
  {
    this.c = ((DbPrefetchFeedHandler)Preconditions.checkNotNull(paramDbPrefetchFeedHandler));
    this.d = paramClock;
  }

  public FetchNewsFeedResult a(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramFetchNewsFeedParams);
      FetchNewsFeedResult localFetchNewsFeedResult1 = (FetchNewsFeedResult)this.b.get(paramFetchNewsFeedParams.f());
      if (localFetchNewsFeedResult1 == null)
      {
        localFetchNewsFeedResult1 = this.c.a(paramFetchNewsFeedParams);
        this.b.put(paramFetchNewsFeedParams.f(), localFetchNewsFeedResult1);
      }
      FetchNewsFeedResult localFetchNewsFeedResult2 = localFetchNewsFeedResult1;
      if ((localFetchNewsFeedResult2 != FetchNewsFeedResult.a) && (Objects.equal(paramFetchNewsFeedParams.c(), localFetchNewsFeedResult2.b.c())) && (Objects.equal(paramFetchNewsFeedParams.d(), localFetchNewsFeedResult2.b.d())) && (this.d.a() - localFetchNewsFeedResult2.f() <= 3600000L));
      for (FetchNewsFeedResult localFetchNewsFeedResult3 = new FetchNewsFeedResult(paramFetchNewsFeedParams, localFetchNewsFeedResult2.c, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localFetchNewsFeedResult2.f()); ; localFetchNewsFeedResult3 = FetchNewsFeedResult.a)
        return localFetchNewsFeedResult3;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.b.clear();
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

  public void a(NewsFeedType paramNewsFeedType)
  {
    monitorenter;
    try
    {
      this.b.remove(paramNewsFeedType);
      this.c.a(paramNewsFeedType);
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

  public void a(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    monitorenter;
    try
    {
      this.b.put(paramFetchNewsFeedResult.b.f(), paramFetchNewsFeedResult);
      this.c.a(paramFetchNewsFeedResult);
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
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.PrefetchedFeedCache
 * JD-Core Version:    0.6.0
 */