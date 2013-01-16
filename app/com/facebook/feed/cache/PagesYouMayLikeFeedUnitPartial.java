package com.facebook.feed.cache;

import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit.Builder;

public class PagesYouMayLikeFeedUnitPartial extends FeedUnitPartial
{
  public static final String a = GraphQLObjectType.ObjectType.PagesYouMayLikeFeedUnit.toString();
  public final boolean b;

  public PagesYouMayLikeFeedUnitPartial(PagesYouMayLikeFeedUnitPartial.Builder paramBuilder)
  {
    super(PagesYouMayLikeFeedUnitPartial.Builder.a(paramBuilder), PagesYouMayLikeFeedUnitPartial.Builder.b(paramBuilder));
    this.b = PagesYouMayLikeFeedUnitPartial.Builder.c(paramBuilder);
  }

  public FeedUnitPartial a(FeedUnitPartial paramFeedUnitPartial)
  {
    Object localObject;
    if (!(paramFeedUnitPartial instanceof PagesYouMayLikeFeedUnitPartial))
    {
      localObject = super.a(paramFeedUnitPartial);
      return localObject;
    }
    PagesYouMayLikeFeedUnitPartial.Builder localBuilder = new PagesYouMayLikeFeedUnitPartial.Builder();
    if (paramFeedUnitPartial.d > this.d)
    {
      localBuilder.a((PagesYouMayLikeFeedUnitPartial)paramFeedUnitPartial);
      label46: if ((!this.b) && (!((PagesYouMayLikeFeedUnitPartial)paramFeedUnitPartial).b))
        break label89;
    }
    label89: for (boolean bool = true; ; bool = false)
    {
      localObject = localBuilder.a(bool).a();
      break;
      localBuilder.a(this);
      break label46;
    }
  }

  public PagesYouMayLikeFeedUnit a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit)
  {
    if (paramPagesYouMayLikeFeedUnit == null)
      paramPagesYouMayLikeFeedUnit = null;
    while (true)
    {
      return paramPagesYouMayLikeFeedUnit;
      if (paramPagesYouMayLikeFeedUnit.getFetchTimeMs() > this.d)
      {
        if (!this.b)
          continue;
        paramPagesYouMayLikeFeedUnit.y();
        continue;
      }
      paramPagesYouMayLikeFeedUnit = new PagesYouMayLikeFeedUnit.Builder().a(paramPagesYouMayLikeFeedUnit).a(this.b).a(this.d).a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.PagesYouMayLikeFeedUnitPartial
 * JD-Core Version:    0.6.0
 */