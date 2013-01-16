package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLApplication extends GraphQLProfile
{

  @JsonProperty("username")
  public final String username;

  protected GraphQLApplication()
  {
    this(new GraphQLApplication.Builder());
  }

  protected GraphQLApplication(GraphQLApplication.Builder paramBuilder)
  {
    super(paramBuilder);
    this.username = GraphQLApplication.Builder.a(paramBuilder);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLApplication
 * JD-Core Version:    0.6.0
 */