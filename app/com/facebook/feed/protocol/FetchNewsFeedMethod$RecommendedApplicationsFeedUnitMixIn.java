package com.facebook.feed.protocol;

import com.facebook.graphql.model.RecommendedApplicationsFeedUnitItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

abstract class FetchNewsFeedMethod$RecommendedApplicationsFeedUnitMixIn
{

  @JsonProperty("apps_items")
  public List<RecommendedApplicationsFeedUnitItem> apps;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedMethod.RecommendedApplicationsFeedUnitMixIn
 * JD-Core Version:    0.6.0
 */