package com.facebook.feed.cache;

import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.feed.util.FeedEdgeComparator;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.graphql.model.Shareable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PendingStoryCache
{
  private final Comparator<FeedEdge> a = new PendingStoryCache.1(this);
  private final MapWithSecondaryOrdering<String, FeedEdge> b = new MapWithSecondaryOrdering(this.a);

  public PendingStoryCache()
  {
  }

  public PendingStoryCache(PendingStoryCache paramPendingStoryCache)
  {
    this();
    this.b.putAll(paramPendingStoryCache.d());
  }

  private FeedUnitEdge a(FeedUnit paramFeedUnit)
  {
    return new FeedUnitEdge(paramFeedUnit, null, FeedEdgeComparator.b);
  }

  private String d(String paramString)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext())
        break;
      localEntry = (Map.Entry)localIterator.next();
    }
    while ((!(((FeedEdge)localEntry.getValue()).b() instanceof FeedStory)) || (((FeedStory)((FeedEdge)localEntry.getValue()).b()).S() == null) || (!Objects.equal(((FeedStory)((FeedEdge)localEntry.getValue()).b()).S().legacyApiPostId, paramString)));
    for (String str = (String)localEntry.getKey(); ; str = null)
      return str;
  }

  public int a(List<? extends FeedEdge> paramList)
  {
    Iterator localIterator1 = paramList.iterator();
    int i = 0;
    if (localIterator1.hasNext())
    {
      FeedEdge localFeedEdge = (FeedEdge)localIterator1.next();
      Iterator localIterator2 = this.b.entrySet().iterator();
      do
        if (!localIterator2.hasNext())
          break;
      while (!FeedUtils.a((FeedEdge)((Map.Entry)localIterator2.next()).getValue(), localFeedEdge));
    }
    for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public void a()
  {
    this.b.clear();
  }

  public void a(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      this.b.remove(paramString);
    }
  }

  public void a(String paramString, FeedStory paramFeedStory)
  {
    this.b.put(Preconditions.checkNotNull(paramString), a((FeedUnit)Preconditions.checkNotNull(paramFeedStory)));
  }

  public void a(String paramString1, String paramString2)
  {
    FeedEdge localFeedEdge = (FeedEdge)this.b.get(Preconditions.checkNotNull(paramString1));
    if (localFeedEdge == null)
      return;
    FeedStory localFeedStory = (FeedStory)localFeedEdge.b();
    localFeedStory.a(FeedOptimisticPublishState.SUCCESS);
    FeedStoryBuilder localFeedStoryBuilder;
    if (Shareable.a.equals(localFeedStory.shareable))
    {
      localFeedStoryBuilder = new FeedStoryBuilder(localFeedStory);
      String[] arrayOfString = paramString2.split("_");
      if (arrayOfString.length != 2)
        break label142;
      localFeedStoryBuilder.a(new Shareable(arrayOfString[1], Shareable.a.b()));
    }
    while (true)
    {
      localFeedStory = localFeedStoryBuilder.G();
      a(paramString1, new FeedStoryBuilder(localFeedStory).a(FeedbackBuilder.c(paramString2)).b(System.currentTimeMillis()).G());
      break;
      label142: localFeedStoryBuilder.a(null);
    }
  }

  public boolean a(FeedStory paramFeedStory)
  {
    Preconditions.checkNotNull(paramFeedStory.S());
    String str = d(paramFeedStory.S().legacyApiPostId);
    if (str != null)
      a(str, paramFeedStory);
    for (int i = 1; ; i = 0)
      return i;
  }

  public List<FeedEdge> b()
  {
    return this.b.a();
  }

  public boolean b(String paramString)
  {
    if (paramString == null);
    for (boolean bool = false; ; bool = this.b.containsKey(paramString))
      return bool;
  }

  public int c()
  {
    return this.b.size();
  }

  public FeedStory c(String paramString)
  {
    String str = d(paramString);
    if (str != null);
    for (FeedStory localFeedStory = (FeedStory)((FeedEdge)this.b.get(str)).b(); ; localFeedStory = null)
      return localFeedStory;
  }

  public MapWithSecondaryOrdering<String, FeedEdge> d()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.PendingStoryCache
 * JD-Core Version:    0.6.0
 */