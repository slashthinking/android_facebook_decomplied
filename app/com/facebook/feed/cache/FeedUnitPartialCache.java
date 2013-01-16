package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.feed.db.DbFeedUnitPartialHandler;
import com.facebook.feed.db.DbFeedbackHandler;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.FeedStoryReshares;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FeedUnitPartialCache
{
  private final Function<FeedUnitEdge, FeedUnitEdge> a = new FeedUnitPartialCache.1(this);
  private final Function<FeedStory, FeedStory> b = new FeedUnitPartialCache.2(this);
  private final AndroidThreadUtil c;
  private final DbFeedbackHandler d;
  private final DbFeedUnitPartialHandler e;
  private final LruCache<String, Feedback> f;
  private final LruCache<String, FeedUnitPartial> g;
  private boolean h;

  public FeedUnitPartialCache(AndroidThreadUtil paramAndroidThreadUtil, DbFeedbackHandler paramDbFeedbackHandler, DbFeedUnitPartialHandler paramDbFeedUnitPartialHandler)
  {
    this(paramAndroidThreadUtil, paramDbFeedbackHandler, paramDbFeedUnitPartialHandler, 30);
  }

  FeedUnitPartialCache(AndroidThreadUtil paramAndroidThreadUtil, DbFeedbackHandler paramDbFeedbackHandler, DbFeedUnitPartialHandler paramDbFeedUnitPartialHandler, int paramInt)
  {
    this.c = ((AndroidThreadUtil)Preconditions.checkNotNull(paramAndroidThreadUtil));
    this.d = ((DbFeedbackHandler)Preconditions.checkNotNull(paramDbFeedbackHandler));
    this.e = ((DbFeedUnitPartialHandler)Preconditions.checkNotNull(paramDbFeedUnitPartialHandler));
    this.h = false;
    this.f = new FeedUnitPartialCache.3(this, paramInt);
    this.g = new FeedUnitPartialCache.4(this, paramInt);
  }

  private FeedStory a(FeedStory paramFeedStory)
  {
    if (paramFeedStory == null)
    {
      paramFeedStory = null;
      return paramFeedStory;
    }
    Feedback localFeedback = c(paramFeedStory.S());
    FeedStoryPartial localFeedStoryPartial = (FeedStoryPartial)a(paramFeedStory.cacheId);
    if (localFeedStoryPartial != null);
    for (FeedStory localFeedStory1 = localFeedStoryPartial.a(paramFeedStory); ; localFeedStory1 = paramFeedStory)
    {
      FeedStory localFeedStory2 = a(paramFeedStory.attachedStory);
      List localList = b(paramFeedStory.substories);
      if ((localFeedStory1 == paramFeedStory) && (localFeedback == paramFeedStory.S()) && (localFeedStory2 == paramFeedStory.attachedStory) && (localList == paramFeedStory.substories))
        break;
      FeedStoryBuilder localFeedStoryBuilder = new FeedStoryBuilder(localFeedStory1).a(localFeedback).b(localFeedStory2).f(localList);
      if (localFeedback != null)
        localFeedStoryBuilder.b(localFeedback.getFetchTimeMs());
      paramFeedStory = localFeedStoryBuilder.G();
      break;
    }
  }

  private FeedUnit a(FeedUnit paramFeedUnit)
  {
    if ((paramFeedUnit instanceof FeedStory))
      paramFeedUnit = a((FeedStory)paramFeedUnit);
    while (true)
    {
      return paramFeedUnit;
      if (!(paramFeedUnit instanceof PagesYouMayLikeFeedUnit))
        continue;
      paramFeedUnit = a((PagesYouMayLikeFeedUnit)paramFeedUnit);
    }
  }

  private FeedUnitEdge a(FeedUnitEdge paramFeedUnitEdge)
  {
    FeedUnit localFeedUnit = a(paramFeedUnitEdge.b());
    if (localFeedUnit != paramFeedUnitEdge.b())
      paramFeedUnitEdge = new FeedUnitEdge(localFeedUnit, paramFeedUnitEdge.a(), paramFeedUnitEdge.c());
    return paramFeedUnitEdge;
  }

  private PagesYouMayLikeFeedUnit a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit)
  {
    if (paramPagesYouMayLikeFeedUnit == null)
      paramPagesYouMayLikeFeedUnit = null;
    while (true)
    {
      return paramPagesYouMayLikeFeedUnit;
      PagesYouMayLikeFeedUnitPartial localPagesYouMayLikeFeedUnitPartial = (PagesYouMayLikeFeedUnitPartial)a(paramPagesYouMayLikeFeedUnit.getCacheId());
      if (localPagesYouMayLikeFeedUnitPartial == null)
        continue;
      paramPagesYouMayLikeFeedUnit = localPagesYouMayLikeFeedUnitPartial.a(paramPagesYouMayLikeFeedUnit);
    }
  }

  private List<FeedUnitEdge> a(List<FeedUnitEdge> paramList)
  {
    return a(paramList, this.a);
  }

  private static <ITEM> List<ITEM> a(List<ITEM> paramList, Function<ITEM, ITEM> paramFunction)
  {
    if (paramList == null)
      paramList = null;
    while (true)
    {
      return paramList;
      ImmutableList.Builder localBuilder = ImmutableList.e();
      int i = 0;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        Object localObject2 = paramFunction.apply(localObject1);
        if (localObject2 != localObject1)
          i = 1;
        localBuilder.b(localObject2);
      }
      if (i == 0)
        continue;
      paramList = localBuilder.b();
    }
  }

  private Feedback b(Feedback paramFeedback)
  {
    return new FeedbackBuilder().a(paramFeedback).a(new FeedStoryLikers(paramFeedback.a())).a(new FeedStoryComments(paramFeedback.b())).a(new FeedStoryReshares(paramFeedback.c())).n();
  }

  private List<FeedStory> b(List<FeedStory> paramList)
  {
    return a(paramList, this.b);
  }

  private Feedback c(Feedback paramFeedback)
  {
    if (paramFeedback == null);
    Feedback localFeedback;
    for (paramFeedback = null; ; paramFeedback = localFeedback)
      do
      {
        return paramFeedback;
        localFeedback = b(paramFeedback.legacyApiPostId);
      }
      while ((localFeedback == null) || (localFeedback.getFetchTimeMs() < paramFeedback.getFetchTimeMs()));
  }

  <T extends FeedUnitPartial> T a(String paramString)
  {
    if (paramString == null);
    for (FeedUnitPartial localFeedUnitPartial = null; ; localFeedUnitPartial = (FeedUnitPartial)this.g.a(paramString))
      return localFeedUnitPartial;
  }

  public FeedHomeStories a(FeedHomeStories paramFeedHomeStories)
  {
    monitorenter;
    try
    {
      Preconditions.checkState(this.h, "FeedUnitPartialCache must be initialized before use");
      this.c.b();
      if (paramFeedHomeStories == null)
        paramFeedHomeStories = null;
      while (true)
      {
        return paramFeedHomeStories;
        List localList = a(paramFeedHomeStories.feedUnitEdges);
        if (localList == paramFeedHomeStories.feedUnitEdges)
          continue;
        FeedHomeStories localFeedHomeStories = new FeedHomeStories(localList, paramFeedHomeStories.pageInfo);
        paramFeedHomeStories = localFeedHomeStories;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    boolean bool = true;
    monitorenter;
    while (true)
    {
      try
      {
        if (!this.h)
        {
          Preconditions.checkState(bool, "FeedUnitPartialCache has been initialized more than once");
          this.h = true;
          Iterator localIterator1 = this.d.a().iterator();
          if (!localIterator1.hasNext())
            break;
          Feedback localFeedback = (Feedback)localIterator1.next();
          this.f.a(localFeedback.legacyApiPostId, localFeedback);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      bool = false;
    }
    Iterator localIterator2 = this.e.a().iterator();
    while (localIterator2.hasNext())
    {
      FeedUnitPartial localFeedUnitPartial = (FeedUnitPartial)localIterator2.next();
      this.g.a(localFeedUnitPartial.c, localFeedUnitPartial);
    }
    monitorexit;
  }

  public void a(FeedUnitPartial paramFeedUnitPartial)
  {
    monitorenter;
    try
    {
      Preconditions.checkState(this.h, "FeedUnitPartialCache must be initialized before use");
      this.c.b();
      if (paramFeedUnitPartial != null)
      {
        String str = paramFeedUnitPartial.c;
        if (str != null)
          break label37;
      }
      while (true)
      {
        return;
        label37: FeedUnitPartial localFeedUnitPartial = paramFeedUnitPartial.a(a(paramFeedUnitPartial.c));
        this.g.a(localFeedUnitPartial.c, localFeedUnitPartial);
        this.e.a(localFeedUnitPartial);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(Feedback paramFeedback)
  {
    monitorenter;
    try
    {
      Preconditions.checkState(this.h, "FeedUnitPartialCache must be initialized before use");
      this.c.b();
      if (paramFeedback == null);
      while (true)
      {
        return;
        Feedback localFeedback1 = b(paramFeedback.legacyApiPostId);
        if ((localFeedback1 != null) && (localFeedback1.getFetchTimeMs() >= paramFeedback.getFetchTimeMs()))
          continue;
        Feedback localFeedback2 = b(paramFeedback);
        this.f.a(localFeedback2.legacyApiPostId, localFeedback2);
        this.d.a(localFeedback2);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public FeedUnitPartialCache.FeedUnitPartialCacheInitializer b()
  {
    return new FeedUnitPartialCache.5(this);
  }

  Feedback b(String paramString)
  {
    if (paramString == null);
    for (Feedback localFeedback = null; ; localFeedback = (Feedback)this.f.a(paramString))
      return localFeedback;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitPartialCache
 * JD-Core Version:    0.6.0
 */