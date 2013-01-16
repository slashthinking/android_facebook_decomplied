package com.facebook.feed.protocol;

import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

abstract class FetchNewsFeedMethod$PagesYouMayLikeFeedUnitMixIn
{

  @JsonProperty("pyml_items")
  public List<PagesYouMayLikeFeedUnitItem> items;

  @JsonProperty("pyml_title")
  public GraphQLTextWithEntities title;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedMethod.PagesYouMayLikeFeedUnitMixIn
 * JD-Core Version:    0.6.0
 */