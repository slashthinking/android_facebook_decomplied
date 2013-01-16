package com.facebook.feed.protocol;

import com.facebook.graphql.model.CelebrationsItem;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

abstract class FetchNewsFeedMethod$CelebrationsFeedUnitMixIn
{

  @JsonProperty("celebs_items")
  public List<CelebrationsItem> items;

  @JsonProperty("celebs_title")
  public GraphQLTextWithEntities title;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedMethod.CelebrationsFeedUnitMixIn
 * JD-Core Version:    0.6.0
 */