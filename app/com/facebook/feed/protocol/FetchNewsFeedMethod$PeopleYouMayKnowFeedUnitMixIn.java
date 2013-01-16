package com.facebook.feed.protocol;

import com.facebook.graphql.model.PeopleYouMayKnowItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

abstract class FetchNewsFeedMethod$PeopleYouMayKnowFeedUnitMixIn
{

  @JsonProperty("pymk_items")
  public List<PeopleYouMayKnowItem> suggestions;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedMethod.PeopleYouMayKnowFeedUnitMixIn
 * JD-Core Version:    0.6.0
 */