package com.facebook.graphql.model;

import java.util.List;

public class PagesYouMayLikeFeedUnit$Builder
{
  private GraphQLTextWithEntities a;
  private List<PagesYouMayLikeFeedUnitItem> b;
  private String c;
  private boolean d;
  private long e;
  private String f;

  public Builder a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }

  public Builder a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit)
  {
    this.a = paramPagesYouMayLikeFeedUnit.title;
    this.b = paramPagesYouMayLikeFeedUnit.items;
    this.d = paramPagesYouMayLikeFeedUnit.z();
    this.c = paramPagesYouMayLikeFeedUnit.getCacheId();
    this.e = paramPagesYouMayLikeFeedUnit.getFetchTimeMs();
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public PagesYouMayLikeFeedUnit a()
  {
    PagesYouMayLikeFeedUnit localPagesYouMayLikeFeedUnit = new PagesYouMayLikeFeedUnit(this);
    if (localPagesYouMayLikeFeedUnit.a());
    while (true)
    {
      return localPagesYouMayLikeFeedUnit;
      localPagesYouMayLikeFeedUnit = null;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PagesYouMayLikeFeedUnit.Builder
 * JD-Core Version:    0.6.2
 */