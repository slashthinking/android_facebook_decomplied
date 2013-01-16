package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class CelebrationsFeedUnit
  implements FeedUnit
{
  private long a = -1L;

  @JsonProperty("cache_id")
  private final String cacheId = null;

  @JsonProperty("items")
  public final List<CelebrationsItem> items = ImmutableList.d();

  @JsonProperty("title")
  public final GraphQLTextWithEntities title = null;

  @JsonProperty("__type__")
  public final GraphQLObjectType type = new GraphQLObjectType(GraphQLObjectType.ObjectType.CelebrationsFeedUnit);

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

  public void setFetchTimeMs(long paramLong)
  {
    this.a = paramLong;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.CelebrationsFeedUnit
 * JD-Core Version:    0.6.2
 */