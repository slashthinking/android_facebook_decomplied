package com.facebook.feed.cache;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.model.FeedType;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchSingleStoryResult;
import com.facebook.feed.util.FetchFeedbackType;
import com.facebook.feed.util.FetchNewsFeedType;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DefaultNewsFeedCache
  implements NewsFeedCache
{
  private static final Class<?> a = DefaultNewsFeedCache.class;
  private final FeedbackMutator b;
  private final FeedStoryMutator c;
  private final FeedUnitCache d;
  private final FeedbackCache e;
  private final Clock f;
  private final NewsFeedServerSuppliedParameters g;
  private Map<FeedType, DefaultNewsFeedCache.FeedSegmentsCache> h;
  private int i;

  DefaultNewsFeedCache(int paramInt1, int paramInt2, Clock paramClock, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, FeedbackMutator paramFeedbackMutator, FeedStoryMutator paramFeedStoryMutator, FbErrorReporter paramFbErrorReporter)
  {
    this.b = paramFeedbackMutator;
    this.c = paramFeedStoryMutator;
    this.i = paramInt1;
    this.e = new FeedbackCache(paramInt2, paramFeedbackMutator);
    this.d = new FeedUnitCache(this.e, paramInt1, paramFeedStoryMutator, paramFbErrorReporter);
    this.h = Maps.a();
    this.f = paramClock;
    this.g = paramNewsFeedServerSuppliedParameters;
  }

  public DefaultNewsFeedCache(Clock paramClock, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, FeedbackMutator paramFeedbackMutator, FeedStoryMutator paramFeedStoryMutator, FbErrorReporter paramFbErrorReporter)
  {
    this(300, 300, paramClock, paramNewsFeedServerSuppliedParameters, paramFeedbackMutator, paramFeedStoryMutator, paramFbErrorReporter);
  }

  private FetchFeedbackResult a(Feedback paramFeedback)
  {
    if (paramFeedback == null);
    for (FetchFeedbackResult localFetchFeedbackResult = null; ; localFetchFeedbackResult = new FetchFeedbackResult(paramFeedback, b(paramFeedback.getFetchTimeMs()), paramFeedback.getFetchTimeMs()))
      return localFetchFeedbackResult;
  }

  private FetchSingleStoryResult a(FeedStory paramFeedStory)
  {
    if (paramFeedStory == null);
    for (FetchSingleStoryResult localFetchSingleStoryResult = null; ; localFetchSingleStoryResult = new FetchSingleStoryResult(paramFeedStory, b(paramFeedStory.getFetchTimeMs()), paramFeedStory.getFetchTimeMs()))
      return localFetchSingleStoryResult;
  }

  private DefaultNewsFeedCache.FeedSegmentsCache b(FeedType paramFeedType)
  {
    DefaultNewsFeedCache.FeedSegmentsCache localFeedSegmentsCache = (DefaultNewsFeedCache.FeedSegmentsCache)this.h.get(paramFeedType);
    if (localFeedSegmentsCache == null)
    {
      localFeedSegmentsCache = new DefaultNewsFeedCache.FeedSegmentsCache();
      this.h.put(paramFeedType, localFeedSegmentsCache);
    }
    return localFeedSegmentsCache;
  }

  private DataFreshnessResult b(long paramLong)
  {
    if (this.f.a() - paramLong > this.g.b());
    for (DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE; ; localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE)
      return localDataFreshnessResult;
  }

  private List<String> c(FeedType paramFeedType)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = DefaultNewsFeedCache.FeedSegmentsCache.a(b(paramFeedType)).iterator();
    while (localIterator.hasNext())
      localBuilder.b(((FeedSegment)localIterator.next()).d());
    return localBuilder.b();
  }

  public int a(FeedType paramFeedType, int paramInt)
  {
    boolean bool = true;
    monitorenter;
    if (paramInt > 0);
    try
    {
      int j;
      while (true)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        Preconditions.checkArgument(bool, "must be positive: %s", arrayOfObject);
        DefaultNewsFeedCache.FeedSegmentsCache localFeedSegmentsCache = b(paramFeedType);
        LinkedList localLinkedList = DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache);
        int k;
        for (j = 0; (!localFeedSegmentsCache.a()) && (j < paramInt); j = k + j)
        {
          FeedSegment localFeedSegment = (FeedSegment)localLinkedList.removeFirst();
          DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache, localFeedSegment);
          k = localFeedSegment.e();
        }
        bool = false;
      }
      monitorexit;
      return j;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public FetchFeedbackResult a(String paramString1, String paramString2, FetchNodeListParams paramFetchNodeListParams)
  {
    Preconditions.checkNotNull(paramString1);
    return a(this.e.a(paramString1, paramString2, paramFetchNodeListParams));
  }

  public FetchNewsFeedResult a(FeedType paramFeedType, FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    monitorenter;
    label235: boolean bool1;
    label270: long l1;
    while (true)
    {
      DefaultNewsFeedCache.FeedSegmentsCache localFeedSegmentsCache;
      FetchNewsFeedResult localFetchNewsFeedResult;
      LinkedList localLinkedList;
      try
      {
        localFeedSegmentsCache = b(paramFeedType);
        if (!localFeedSegmentsCache.a())
          continue;
        localFetchNewsFeedResult = FetchNewsFeedResult.a;
        return localFetchNewsFeedResult;
        FetchNewsFeedType localFetchNewsFeedType = FetchNewsFeedType.getQueryType(paramFetchNewsFeedParams);
        localLinkedList = DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache);
        switch (DefaultNewsFeedCache.1.a[localFetchNewsFeedType.ordinal()])
        {
        default:
          j = localLinkedList.size();
          if (j != localLinkedList.size())
            break label235;
          localFetchNewsFeedResult = FetchNewsFeedResult.a;
          break;
        case 1:
          throw new UnsupportedOperationException("This news feed query type is not supported.");
        case 2:
        case 3:
        case 4:
        }
      }
      finally
      {
        monitorexit;
      }
      int j = 0;
      continue;
      if (localFeedSegmentsCache.b(paramFetchNewsFeedParams.c()) == null)
      {
        localFetchNewsFeedResult = FetchNewsFeedResult.a;
        continue;
      }
      FeedSegment localFeedSegment3 = (FeedSegment)DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache).get(0);
      if (paramFetchNewsFeedParams.c().equals(localFeedSegment3.d()))
      {
        localFetchNewsFeedResult = FetchNewsFeedResult.a;
        continue;
        FeedSegment localFeedSegment1 = localFeedSegmentsCache.a(paramFetchNewsFeedParams.d());
        if ((localFeedSegment1 == null) || (localFeedSegment1.f()))
        {
          localFetchNewsFeedResult = FetchNewsFeedResult.a;
          continue;
        }
        j = 1 + localLinkedList.indexOf(localFeedSegment1);
        continue;
        ImmutableList.Builder localBuilder = ImmutableList.e();
        String str1 = ((FeedSegment)localLinkedList.get(j)).d();
        if (paramFetchNewsFeedParams.d() != null)
          break label499;
        bool1 = true;
        break;
        FeedSegment localFeedSegment2 = (FeedSegment)localLinkedList.get(j);
        Object localObject2;
        if (localFeedSegment2.g() > localObject2)
          l1 = localFeedSegment2.g();
        this.d.a(localBuilder, localFeedSegment2.b());
        long l2 = localFeedSegment2.e();
        String str2 = localFeedSegment2.c();
        boolean bool2;
        if (localFeedSegment2.f())
          bool2 = localFeedSegment2.a().hasNextPage;
        while (true)
        {
          GraphQLPageInfo localGraphQLPageInfo = new GraphQLPageInfo(str1, str2, bool1, bool2);
          localFetchNewsFeedResult = new FetchNewsFeedResult(paramFetchNewsFeedParams, new FeedHomeStories(localBuilder.b(), localGraphQLPageInfo), b(l1), l1);
          break;
          j++;
          if ((j < localLinkedList.size()) && (paramFetchNewsFeedParams.c() != null) && (paramFetchNewsFeedParams.c().equals(((FeedSegment)localLinkedList.get(j)).d())))
          {
            bool2 = false;
            continue;
          }
          if (l2 < paramFetchNewsFeedParams.b())
          {
            int k = localLinkedList.size();
            if (j < k)
              break label270;
          }
          bool2 = true;
        }
      }
      j = 0;
    }
    while (true)
    {
      l1 = 0L;
      break;
      label499: bool1 = false;
    }
  }

  public FetchSingleStoryResult a(String paramString)
  {
    return a(this.d.a(paramString));
  }

  public ArrayList<StoryUpdate> a(long paramLong)
  {
    return this.d.a(paramLong);
  }

  public List<String> a(FeedType paramFeedType, String paramString)
  {
    monitorenter;
    while (true)
    {
      try
      {
        DefaultNewsFeedCache.FeedSegmentsCache localFeedSegmentsCache = b(paramFeedType);
        LinkedList localLinkedList = DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache);
        FeedSegment localFeedSegment = localFeedSegmentsCache.a(paramString);
        if (localFeedSegment != null)
          continue;
        List localList2 = c(paramFeedType);
        localObject2 = localList2;
        return localObject2;
        if (localLinkedList.getLast() != localFeedSegment)
        {
          DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache, (FeedSegment)localLinkedList.removeLast());
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      List localList1 = c(paramFeedType);
      Object localObject2 = localList1;
    }
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.d.a();
      this.e.a();
      Iterator localIterator = this.h.values().iterator();
      if (localIterator.hasNext())
        DefaultNewsFeedCache.FeedSegmentsCache.a((DefaultNewsFeedCache.FeedSegmentsCache)localIterator.next(), 0);
    }
    finally
    {
      monitorexit;
    }
  }

  public void a(FeedType paramFeedType, FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    monitorenter;
    while (true)
    {
      FeedHomeStories localFeedHomeStories;
      String str2;
      String str3;
      DefaultNewsFeedCache.FeedSegmentsCache localFeedSegmentsCache;
      try
      {
        localFeedHomeStories = paramFetchNewsFeedResult.c;
        FetchNewsFeedParams localFetchNewsFeedParams = paramFetchNewsFeedResult.b;
        if ((localFeedHomeStories.pageInfo == null) || (localFeedHomeStories.pageInfo.startCursor == null))
          continue;
        String str1 = localFeedHomeStories.pageInfo.endCursor;
        if (str1 == null)
          return;
        str2 = localFetchNewsFeedParams.d();
        str3 = localFetchNewsFeedParams.c();
        if ((str2 != null) && (str3 != null))
          continue;
        localFeedSegmentsCache = b(paramFeedType);
        FetchNewsFeedType localFetchNewsFeedType = FetchNewsFeedType.getQueryType(localFetchNewsFeedParams);
        switch (DefaultNewsFeedCache.1.a[localFetchNewsFeedType.ordinal()])
        {
        case 1:
        default:
          if (localFeedHomeStories.feedUnitEdges == null)
            break label299;
          Iterator localIterator = localFeedHomeStories.feedUnitEdges.iterator();
          if (!localIterator.hasNext())
            break label299;
          FeedUnitEdge localFeedUnitEdge = (FeedUnitEdge)localIterator.next();
          this.d.a(localFeedUnitEdge.story, localFeedUnitEdge.a());
          continue;
        case 2:
        case 3:
        case 4:
        }
      }
      finally
      {
        monitorexit;
      }
      localFeedSegmentsCache.b(new FeedSegment(localFeedHomeStories.feedUnitEdges, localFeedHomeStories.pageInfo, paramFetchNewsFeedResult.f(), true));
      continue;
      localFeedSegmentsCache.b(str3, new FeedSegment(localFeedHomeStories.feedUnitEdges, localFeedHomeStories.pageInfo, paramFetchNewsFeedResult.f(), localFeedHomeStories.pageInfo.hasNextPage));
      continue;
      localFeedSegmentsCache.a(str2, new FeedSegment(localFeedHomeStories.feedUnitEdges, localFeedHomeStories.pageInfo, paramFetchNewsFeedResult.f(), true));
      continue;
      label299: DefaultNewsFeedCache.FeedSegmentsCache.a(localFeedSegmentsCache, this.i);
    }
  }

  public void a(FetchSingleStoryResult paramFetchSingleStoryResult, String paramString, FetchFeedbackType paramFetchFeedbackType)
  {
    Preconditions.checkNotNull(paramFetchSingleStoryResult.a);
    Preconditions.checkNotNull(paramFetchSingleStoryResult.a.cacheId);
    this.d.a(paramFetchSingleStoryResult.a, paramString, paramFetchFeedbackType);
  }

  public void a(Feedback paramFeedback, FetchFeedbackType paramFetchFeedbackType, String paramString)
  {
    this.d.a(paramFeedback, paramFetchFeedbackType, paramString);
  }

  public void a(Feedback paramFeedback, String paramString)
  {
    this.e.a(paramFeedback, paramString);
  }

  public void a(String paramString, FeedComment paramFeedComment)
  {
    this.d.a(paramString, paramFeedComment);
  }

  public void a(String paramString, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    this.d.a(paramString, paramGraphQLProfile, paramBoolean);
  }

  public void a(String paramString1, String paramString2, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    this.d.a(paramString1, paramString2, paramGraphQLProfile, paramBoolean);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramString);
    FeedStory localFeedStory1 = (FeedStory)this.d.c(paramString);
    if (localFeedStory1 == null);
    while (true)
    {
      return;
      GraphQLActionLink localGraphQLActionLink = localFeedStory1.f();
      if (localGraphQLActionLink.page.doesViewerLike == paramBoolean)
        continue;
      FeedStory localFeedStory2 = this.c.a(localFeedStory1, localGraphQLActionLink).b();
      this.d.a(localFeedStory2, null, FetchFeedbackType.BASE_ONLY);
    }
  }

  public boolean a(FeedType paramFeedType)
  {
    monitorenter;
    try
    {
      boolean bool = b(paramFeedType).a();
      if (!bool)
      {
        j = 1;
        return j;
      }
      int j = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public FetchSingleStoryResult b(String paramString)
  {
    return a(this.d.b(paramString));
  }

  public FetchSingleStoryResult c(String paramString)
  {
    FeedUnit localFeedUnit = this.d.c((String)Preconditions.checkNotNull(paramString));
    if (!(localFeedUnit instanceof FeedStory));
    for (FetchSingleStoryResult localFetchSingleStoryResult = null; ; localFetchSingleStoryResult = a((FeedStory)localFeedUnit))
      return localFetchSingleStoryResult;
  }

  public FetchFeedbackResult d(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return a(this.e.a(paramString));
  }

  public Feedback e(String paramString)
  {
    return this.e.c(paramString);
  }

  public void f(String paramString)
  {
    this.d.d(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.DefaultNewsFeedCache
 * JD-Core Version:    0.6.0
 */