package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindFriendsFeedUnit
  implements FeedUnit
{
  private long a = -1L;

  @JsonProperty("__type__")
  public final GraphQLObjectType type = new GraphQLObjectType(GraphQLObjectType.ObjectType.FindFriendsFeedUnit);

  public String getCacheId()
  {
    return null;
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
 * Qualified Name:     com.facebook.graphql.model.FindFriendsFeedUnit
 * JD-Core Version:    0.6.2
 */