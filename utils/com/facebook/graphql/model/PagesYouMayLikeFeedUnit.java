package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class PagesYouMayLikeFeedUnit
  implements FeedUnit, Postprocessable, Sponsorable
{
  private long a = -1L;
  private boolean b;
  private List<String> c;

  @JsonProperty("cache_id")
  private final String cacheId;

  @JsonProperty("items")
  public final List<PagesYouMayLikeFeedUnitItem> items;

  @JsonProperty("title")
  public final GraphQLTextWithEntities title;

  @JsonProperty("tracking")
  public final String tracking;

  @JsonProperty("__type__")
  public final GraphQLObjectType type = new GraphQLObjectType(GraphQLObjectType.ObjectType.PagesYouMayLikeFeedUnit);

  public PagesYouMayLikeFeedUnit()
  {
    this.items = ImmutableList.d();
    this.title = null;
    this.cacheId = null;
    this.b = false;
    this.tracking = null;
  }

  public PagesYouMayLikeFeedUnit(PagesYouMayLikeFeedUnit.Builder paramBuilder)
  {
    this.items = PagesYouMayLikeFeedUnit.Builder.a(paramBuilder);
    this.title = PagesYouMayLikeFeedUnit.Builder.b(paramBuilder);
    this.cacheId = PagesYouMayLikeFeedUnit.Builder.c(paramBuilder);
    this.b = PagesYouMayLikeFeedUnit.Builder.d(paramBuilder);
    this.a = PagesYouMayLikeFeedUnit.Builder.e(paramBuilder);
    this.tracking = PagesYouMayLikeFeedUnit.Builder.f(paramBuilder);
  }

  private void b()
  {
    if ((this.items == null) || (this.c != null));
    while (true)
    {
      return;
      this.c = Lists.a();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        PagesYouMayLikeFeedUnitItem localPagesYouMayLikeFeedUnitItem = (PagesYouMayLikeFeedUnitItem)localIterator.next();
        if (localPagesYouMayLikeFeedUnitItem.sponsoredData != null)
          localPagesYouMayLikeFeedUnitItem.sponsoredData.a(this.c);
      }
    }
  }

  @JsonIgnore
  public boolean a()
  {
    boolean bool;
    if ((this.title == null) || (this.items == null))
      bool = false;
    while (true)
    {
      return bool;
      Iterator localIterator = this.items.iterator();
      while (true)
        if (localIterator.hasNext())
          if (!((PagesYouMayLikeFeedUnitItem)localIterator.next()).c())
          {
            bool = false;
            break;
          }
      bool = true;
    }
  }

  public String getCacheId()
  {
    return this.cacheId;
  }

  public long getFetchTimeMs()
  {
    return this.a;
  }

  public GraphQLObjectType getType()
  {
    return this.type;
  }

  public void p()
  {
    b();
    if (this.items != null)
    {
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
        ((PagesYouMayLikeFeedUnitItem)localIterator.next()).a(this);
    }
  }

  public void setFetchTimeMs(long paramLong)
  {
    this.a = paramLong;
  }

  public List<String> x()
  {
    b();
    return this.c;
  }

  public void y()
  {
    this.b = true;
  }

  public boolean z()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PagesYouMayLikeFeedUnit
 * JD-Core Version:    0.6.2
 */