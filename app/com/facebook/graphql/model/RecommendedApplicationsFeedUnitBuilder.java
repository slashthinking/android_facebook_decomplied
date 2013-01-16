package com.facebook.graphql.model;

import java.util.Collections;
import java.util.List;

public class RecommendedApplicationsFeedUnitBuilder
{
  private long a = -1L;
  private String b;
  private GraphQLTextWithEntities c;
  private List<RecommendedApplicationsFeedUnitItem> d;

  public RecommendedApplicationsFeedUnitBuilder()
  {
    this.d = Collections.emptyList();
  }

  public RecommendedApplicationsFeedUnitBuilder(RecommendedApplicationsFeedUnit paramRecommendedApplicationsFeedUnit)
  {
    this.a = paramRecommendedApplicationsFeedUnit.getFetchTimeMs();
    this.b = paramRecommendedApplicationsFeedUnit.getCacheId();
    this.c = paramRecommendedApplicationsFeedUnit.title;
    this.d = paramRecommendedApplicationsFeedUnit.apps;
  }

  public long a()
  {
    return this.a;
  }

  public RecommendedApplicationsFeedUnitBuilder a(List<RecommendedApplicationsFeedUnitItem> paramList)
  {
    this.d = paramList;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public GraphQLTextWithEntities c()
  {
    return this.c;
  }

  public List<RecommendedApplicationsFeedUnitItem> d()
  {
    return this.d;
  }

  public RecommendedApplicationsFeedUnit e()
  {
    return new RecommendedApplicationsFeedUnit(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.RecommendedApplicationsFeedUnitBuilder
 * JD-Core Version:    0.6.0
 */