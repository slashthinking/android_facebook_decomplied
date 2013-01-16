package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.util.FetchFeedbackType;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.Sponsorable;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FeedUnitCache
{
  private static Class<FeedUnitCache> a = FeedUnitCache.class;
  private final LinkedList<StoryUpdate> b;
  private final Map<String, String> c;
  private final HashMultimap<String, String> d;
  private final LruCache<String, FeedUnitCache.CacheEntry> e;
  private final HashMultimap<String, String> f;
  private final FeedbackCache g;
  private final FeedStoryMutator h;
  private final FbErrorReporter i;

  public FeedUnitCache(FeedbackCache paramFeedbackCache, int paramInt, FeedStoryMutator paramFeedStoryMutator, FbErrorReporter paramFbErrorReporter)
  {
    this.g = paramFeedbackCache;
    this.h = paramFeedStoryMutator;
    this.i = paramFbErrorReporter;
    this.c = Maps.a();
    this.d = HashMultimap.m();
    this.f = HashMultimap.m();
    this.b = Lists.b();
    this.e = new FeedUnitCache.1(this, paramInt);
  }

  private FeedStory a(FeedStory paramFeedStory, String paramString)
  {
    return a(paramFeedStory, null, paramString, FetchFeedbackType.BASE_ONLY, true);
  }

  private FeedStory a(FeedStory paramFeedStory, String paramString1, String paramString2, FetchFeedbackType paramFetchFeedbackType, boolean paramBoolean)
  {
    if ((paramFeedStory == null) || (paramFeedStory.cacheId == null));
    FeedUnitCache.CacheEntry localCacheEntry;
    while (true)
    {
      return paramFeedStory;
      localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(paramFeedStory.cacheId);
      if (localCacheEntry == null)
        break;
      if (!(localCacheEntry.a instanceof FeedStory))
      {
        this.i.a("feed_unit_cache_fail", "Non-story cache entry had the same cache id as a story.", false);
        paramFeedStory = null;
        continue;
      }
      if (localCacheEntry.a.getFetchTimeMs() < paramFeedStory.getFetchTimeMs())
        break;
      paramFeedStory = (FeedStory)localCacheEntry.a;
    }
    if ((localCacheEntry != null) && (localCacheEntry.c != null) && (paramString2 == null))
      paramString2 = localCacheEntry.c;
    Feedback localFeedback1 = this.g.a(paramFeedStory.S(), paramFetchFeedbackType, null);
    List localList = paramFeedStory.substories;
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramFeedStory.substories.iterator();
    int j = 0;
    label158: if (localIterator.hasNext())
    {
      FeedStory localFeedStory4 = (FeedStory)localIterator.next();
      FeedStory localFeedStory5 = a(localFeedStory4, null, null, FetchFeedbackType.BASE_ONLY, paramBoolean);
      if (localFeedStory5 != null)
        localBuilder.b(localFeedStory5);
      if (localFeedStory5 == localFeedStory4)
        break label421;
    }
    label421: for (int m = 1; ; m = j)
    {
      j = m;
      break label158;
      if (j != 0);
      for (Object localObject = localBuilder.b(); ; localObject = localList)
      {
        FeedStory localFeedStory1 = paramFeedStory.attachedStory;
        if (paramFeedStory.attachedStory != null)
          localFeedStory1 = a(paramFeedStory.attachedStory, null, null, FetchFeedbackType.BASE_ONLY, paramBoolean);
        int k;
        if ((localFeedback1 == paramFeedStory.S()) && (localObject == paramFeedStory.substories))
        {
          FeedStory localFeedStory3 = paramFeedStory.attachedStory;
          k = 0;
          if (localFeedStory1 == localFeedStory3);
        }
        else
        {
          FeedStoryBuilder localFeedStoryBuilder = new FeedStoryBuilder(paramFeedStory);
          Feedback localFeedback2 = paramFeedStory.S();
          k = 0;
          if (localFeedback1 != localFeedback2)
          {
            localFeedStoryBuilder.a(localFeedback1);
            k = 1;
          }
          if (localObject != paramFeedStory.substories)
            localFeedStoryBuilder.f((List)localObject);
          if (localFeedStory1 != paramFeedStory.attachedStory)
            localFeedStoryBuilder.b(localFeedStory1);
          FeedStory localFeedStory2 = localFeedStoryBuilder.G();
          a(localFeedStory2, paramFeedStory, paramBoolean);
          paramFeedStory = localFeedStory2;
        }
        a(paramFeedStory, paramString1, paramString2, paramBoolean);
        if (k == 0)
          break;
        a(localFeedback1);
        break;
      }
    }
  }

  private void a(FeedStory paramFeedStory1, FeedStory paramFeedStory2, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramFeedStory1);
    Preconditions.checkNotNull(paramFeedStory2);
    if (paramFeedStory1 == paramFeedStory2);
    while (true)
    {
      return;
      paramFeedStory1.a(paramFeedStory2.a);
      FeedStory localFeedStory1 = paramFeedStory1.a;
      if (localFeedStory1 == null)
        continue;
      FeedUnitCache.CacheEntry localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(localFeedStory1.cacheId);
      if (localCacheEntry == null)
        continue;
      FeedStory localFeedStory2 = this.h.a(paramFeedStory1, paramFeedStory2);
      a(localFeedStory2, localFeedStory1, paramBoolean);
      a(localFeedStory2, localCacheEntry.b, localCacheEntry.c, paramBoolean);
    }
  }

  private void a(FeedStory paramFeedStory, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString2 != null) && (this.e.a(paramFeedStory.cacheId) != null));
    for (int j = 1; ; j = 0)
    {
      this.e.a(paramFeedStory.cacheId, new FeedUnitCache.CacheEntry(this, paramFeedStory, paramString1, paramString2, paramBoolean));
      if (paramString1 != null)
        this.c.put(paramString1, paramFeedStory.cacheId);
      if (paramFeedStory.id != null)
        this.d.a(paramFeedStory.id, paramFeedStory.cacheId);
      if ((paramFeedStory.S() != null) && (paramFeedStory.S().id != null))
        this.f.a(paramFeedStory.S().id, paramFeedStory.cacheId);
      if ((paramString2 != null) && (j != 0))
      {
        if (this.b.size() >= 10)
          this.b.removeLast();
        this.b.addFirst(new StoryUpdate(paramString2, paramFeedStory));
        Collections.sort(this.b, StoryUpdate.b);
      }
      return;
    }
  }

  private void a(Feedback paramFeedback)
  {
    if (paramFeedback == null);
    while (true)
    {
      return;
      Iterator localIterator = ImmutableSet.a(this.f.a(paramFeedback.id)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        FeedUnitCache.CacheEntry localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(str);
        if ((localCacheEntry == null) || (!(localCacheEntry.a instanceof FeedStory)) || (((FeedStory)localCacheEntry.a).S() == null) || (((FeedStory)localCacheEntry.a).S().id == null))
          continue;
        FeedStory localFeedStory1 = (FeedStory)localCacheEntry.a;
        if ((paramFeedback == localFeedStory1.S()) || (paramFeedback.getFetchTimeMs() < localFeedStory1.S().getFetchTimeMs()))
          continue;
        FeedStory localFeedStory2 = new FeedStoryBuilder(localFeedStory1).a(paramFeedback).b(paramFeedback.getFetchTimeMs()).G();
        a(localFeedStory2, localFeedStory1, localCacheEntry.d);
        a(localFeedStory2, localCacheEntry.b, localCacheEntry.c, localCacheEntry.d);
      }
    }
  }

  FeedStory a(FeedStory paramFeedStory, String paramString, FetchFeedbackType paramFetchFeedbackType)
  {
    monitorenter;
    try
    {
      FeedStory localFeedStory = a(paramFeedStory, paramString, null, paramFetchFeedbackType, false);
      monitorexit;
      return localFeedStory;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  FeedStory a(String paramString)
  {
    monitorenter;
    FeedStory localFeedStory;
    if (paramString == null)
      localFeedStory = null;
    while (true)
    {
      monitorexit;
      return localFeedStory;
      try
      {
        Iterator localIterator = this.d.a(paramString).iterator();
        localFeedStory = null;
        if (!localIterator.hasNext())
          continue;
        String str = (String)localIterator.next();
        FeedUnitCache.CacheEntry localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(str);
        if (!localCacheEntry.d)
        {
          if (!(localCacheEntry.a instanceof FeedStory))
          {
            this.i.a("feed_unit_cache_fail", "Non-story cache entry had the same cache id as a story.", false);
            localFeedStory = null;
            continue;
          }
          localFeedStory = (FeedStory)localCacheEntry.a;
          continue;
        }
        localFeedStory = (FeedStory)localCacheEntry.a;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  ArrayList<StoryUpdate> a(long paramLong)
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = Lists.a();
      for (int j = 0; (j < this.b.size()) && (((StoryUpdate)this.b.get(j)).b().getFetchTimeMs() > paramLong); j++)
      {
        if (localArrayList.contains(this.b.get(j)))
          continue;
        localArrayList.add(this.b.get(j));
      }
      monitorexit;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a()
  {
    monitorenter;
    try
    {
      this.f.f();
      this.d.f();
      this.c.clear();
      this.e.a();
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

  void a(FeedUnit paramFeedUnit, String paramString)
  {
    monitorenter;
    if (paramFeedUnit != null);
    while (true)
    {
      try
      {
        String str = paramFeedUnit.getCacheId();
        if (str == null)
          return;
        Preconditions.checkNotNull(paramString);
        if ((paramFeedUnit instanceof FeedStory))
        {
          a((FeedStory)paramFeedUnit, paramString);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.e.a(paramFeedUnit.getCacheId(), new FeedUnitCache.CacheEntry(this, paramFeedUnit, null, paramString, true));
    }
  }

  void a(Feedback paramFeedback, FetchFeedbackType paramFetchFeedbackType, String paramString)
  {
    monitorenter;
    if (paramFeedback != null);
    try
    {
      String str = paramFeedback.id;
      if (str == null);
      while (true)
      {
        return;
        Feedback localFeedback = this.g.a(paramFeedback, paramFetchFeedbackType, paramString);
        if ((localFeedback == null) || (localFeedback == paramFeedback))
          continue;
        a(localFeedback);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(ImmutableList.Builder<FeedUnitEdge> paramBuilder, ImmutableList<FeedUnitEdge> paramImmutableList)
  {
    monitorenter;
    while (true)
    {
      FeedUnitEdge localFeedUnitEdge;
      try
      {
        Preconditions.checkNotNull(paramImmutableList);
        Preconditions.checkNotNull(paramBuilder);
        Iterator localIterator = paramImmutableList.iterator();
        if (!localIterator.hasNext())
          break;
        localFeedUnitEdge = (FeedUnitEdge)localIterator.next();
        if (localFeedUnitEdge.e() == null)
          break label139;
        FeedUnitCache.CacheEntry localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(localFeedUnitEdge.e());
        if ((localCacheEntry != null) && (localCacheEntry.a.getFetchTimeMs() > localFeedUnitEdge.story.getFetchTimeMs()))
        {
          paramBuilder.b(new FeedUnitEdge(localCacheEntry.a, localFeedUnitEdge.a(), localFeedUnitEdge.c()));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      paramBuilder.b(localFeedUnitEdge);
      continue;
      label139: paramBuilder.b(localFeedUnitEdge);
    }
    monitorexit;
  }

  void a(String paramString, FeedComment paramFeedComment)
  {
    monitorenter;
    if ((paramString == null) || (paramFeedComment == null));
    while (true)
    {
      monitorexit;
      return;
      try
      {
        a(this.g.a(paramString, paramFeedComment));
      }
      finally
      {
        monitorexit;
      }
    }
  }

  void a(String paramString, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    monitorenter;
    if ((paramString == null) || (paramGraphQLProfile == null));
    while (true)
    {
      monitorexit;
      return;
      try
      {
        a(this.g.a(paramString, paramGraphQLProfile, paramBoolean));
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public void a(String paramString1, String paramString2, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    if ((paramString2 == null) || (paramGraphQLProfile == null));
    while (true)
    {
      return;
      a(this.g.a(paramString1, paramString2, paramGraphQLProfile, paramBoolean));
    }
  }

  FeedStory b(String paramString)
  {
    monitorenter;
    FeedStory localFeedStory;
    if (paramString == null)
      localFeedStory = null;
    while (true)
    {
      monitorexit;
      return localFeedStory;
      try
      {
        FeedUnit localFeedUnit = c((String)this.c.get(paramString));
        if (!(localFeedUnit instanceof FeedStory))
        {
          this.i.a("feed_unit_cache_fail", "Non-story cache entry had the same cache id as a story.", false);
          localFeedStory = null;
          continue;
        }
        localFeedStory = (FeedStory)localFeedUnit;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  FeedUnit c(String paramString)
  {
    monitorenter;
    FeedUnit localFeedUnit;
    if (paramString == null)
      localFeedUnit = null;
    while (true)
    {
      monitorexit;
      return localFeedUnit;
      try
      {
        FeedUnitCache.CacheEntry localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(paramString);
        if (localCacheEntry == null)
        {
          localFeedUnit = null;
          continue;
        }
        localFeedUnit = localCacheEntry.a;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  void d(String paramString)
  {
    monitorenter;
    if (paramString == null);
    while (true)
    {
      monitorexit;
      return;
      try
      {
        FeedUnitCache.CacheEntry localCacheEntry = (FeedUnitCache.CacheEntry)this.e.a(paramString);
        if ((localCacheEntry == null) || (!(localCacheEntry.a instanceof Sponsorable)) || (((Sponsorable)localCacheEntry.a).z()))
          continue;
        ((Sponsorable)localCacheEntry.a).y();
        localCacheEntry.a.setFetchTimeMs(System.currentTimeMillis());
      }
      finally
      {
        monitorexit;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitCache
 * JD-Core Version:    0.6.0
 */