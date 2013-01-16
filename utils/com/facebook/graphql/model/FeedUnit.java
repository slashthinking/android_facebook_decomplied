package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract interface FeedUnit
{
  @JsonProperty("cache_id")
  public abstract String getCacheId();

  @JsonProperty("fetchTimeMs")
  public abstract long getFetchTimeMs();

  @JsonProperty("__type__")
  public abstract GraphQLObjectType getType();

  @JsonProperty("fetchTimeMs")
  public abstract void setFetchTimeMs(long paramLong);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedUnit
 * JD-Core Version:    0.6.2
 */