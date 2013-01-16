package com.facebook.feed.util;

import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.Sponsorable;

public abstract interface IFeedStoryImpressionLogger
{
  public abstract void a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit);

  public abstract void a(PeopleYouMayKnowFeedUnit paramPeopleYouMayKnowFeedUnit);

  public abstract void a(Sponsorable paramSponsorable);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.IFeedStoryImpressionLogger
 * JD-Core Version:    0.6.0
 */