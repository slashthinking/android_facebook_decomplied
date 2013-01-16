package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GraphQLMediaList
{

  @JsonProperty("count")
  public final int count = 0;

  @JsonProperty("nodes")
  public final List<GraphQLMedia> medias = null;

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo = null;
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLMediaList
 * JD-Core Version:    0.6.2
 */