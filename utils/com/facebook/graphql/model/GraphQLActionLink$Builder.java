package com.facebook.graphql.model;

public class GraphQLActionLink$Builder
{
  private GraphQLObjectType a = null;
  private GraphQLProfile b = null;
  private String c = null;
  private String d = null;
  private GraphQLCoupon e = null;

  public Builder a(GraphQLActionLink paramGraphQLActionLink)
  {
    this.a = paramGraphQLActionLink.type;
    this.b = paramGraphQLActionLink.page;
    this.c = paramGraphQLActionLink.title;
    this.d = paramGraphQLActionLink.url;
    this.e = paramGraphQLActionLink.coupon;
    return this;
  }

  public Builder a(GraphQLProfile paramGraphQLProfile)
  {
    this.b = paramGraphQLProfile;
    return this;
  }

  public GraphQLActionLink a()
  {
    return new GraphQLActionLink(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLActionLink.Builder
 * JD-Core Version:    0.6.2
 */