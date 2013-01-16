package com.facebook.feed.data;

import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.StoryUpdate;
import com.facebook.feed.util.FeedEdgeComparator;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.StoryFreshness;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class PagedFeedUnitCollection extends PagedGraphQLObjectCollection<FeedEdge>
{
  public static final FeedEdge a = new FeedUnitEdge();
  private final PendingStoryCache b;
  private boolean c = false;

  public PagedFeedUnitCollection(PendingStoryCache paramPendingStoryCache)
  {
    super(FeedEdgeComparator.a, a);
    this.b = paramPendingStoryCache;
  }

  private void c(List<? extends FeedEdge> paramList)
  {
    if ((!this.c) || (paramList.size() == 0));
    while (true)
    {
      return;
      for (int i = 0; i < super.a(); i++)
      {
        FeedUnit localFeedUnit2 = ((FeedEdge)super.b(i)).b();
        if (!(localFeedUnit2 instanceof FeedStory))
          continue;
        ((FeedStory)localFeedUnit2).a(FeedStory.StoryFreshness.OLD);
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FeedEdge localFeedEdge = (FeedEdge)localIterator.next();
        FeedUnit localFeedUnit1 = localFeedEdge.b();
        if ((!(localFeedUnit1 instanceof FeedStory)) || (a(localFeedEdge)))
          continue;
        ((FeedStory)localFeedUnit1).a(FeedStory.StoryFreshness.UPDATED);
      }
    }
  }

  public int a()
  {
    return super.a() + this.b.c();
  }

  public int a(List<? extends FeedEdge> paramList)
  {
    return super.a(paramList) - this.b.a(paramList);
  }

  public FeedEdge a(int paramInt)
  {
    if (this.b.c() > paramInt);
    for (FeedEdge localFeedEdge = (FeedEdge)this.b.b().get(paramInt); ; localFeedEdge = (FeedEdge)super.b(paramInt - this.b.c()))
      return localFeedEdge;
  }

  public List<FeedEdge> a(String paramString)
  {
    if (paramString == null);
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      for (int i = 0; i < super.a(); i++)
      {
        FeedEdge localFeedEdge = (FeedEdge)super.b(i);
        FeedUnit localFeedUnit = localFeedEdge.b();
        if ((localFeedUnit == null) || (localFeedUnit.getCacheId() == null) || (!localFeedUnit.getCacheId().equals(paramString)))
          continue;
        localBuilder.b(localFeedEdge);
      }
    }
  }

  public void a(FeedUnit paramFeedUnit)
  {
    if ((paramFeedUnit.getCacheId() == null) && ((paramFeedUnit instanceof FeedStory)) && (this.b.a((FeedStory)paramFeedUnit)));
    while (true)
    {
      return;
      Iterator localIterator = a(paramFeedUnit.getCacheId()).iterator();
      while (localIterator.hasNext())
      {
        FeedEdge localFeedEdge = (FeedEdge)localIterator.next();
        b(new FeedUnitEdge(paramFeedUnit, localFeedEdge.a(), localFeedEdge.c()));
      }
    }
  }

  public void a(List<? extends FeedEdge> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    a(paramList, paramGraphQLPageInfo, false);
  }

  public void a(List<? extends FeedEdge> paramList, GraphQLPageInfo paramGraphQLPageInfo, boolean paramBoolean)
  {
    if ((!paramList.isEmpty()) && (paramBoolean))
      this.b.a();
    c(paramList);
    super.a(paramList, paramGraphQLPageInfo);
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public PendingStoryCache b()
  {
    return this.b;
  }

  public FeedStory b(String paramString)
  {
    return this.b.c(paramString);
  }

  public void b(List<StoryUpdate> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      StoryUpdate localStoryUpdate = (StoryUpdate)localIterator.next();
      FeedEdge localFeedEdge = (FeedEdge)c(localStoryUpdate.a());
      if ((localFeedEdge == null) || (localFeedEdge.b().getFetchTimeMs() >= localStoryUpdate.b().getFetchTimeMs()))
        continue;
      b(new FeedUnitEdge(localStoryUpdate.b(), localStoryUpdate.a(), localFeedEdge.c()));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.PagedFeedUnitCollection
 * JD-Core Version:    0.6.0
 */