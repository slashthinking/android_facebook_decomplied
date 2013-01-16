package com.facebook.feed.protocol;

import com.facebook.graphql.model.GraphQLObjectType;
import com.google.common.base.Preconditions;

public class MarkImpressionsLoggedParams$Builder
{
  private String a;
  private GraphQLObjectType b;

  public Builder a(GraphQLObjectType paramGraphQLObjectType)
  {
    this.b = paramGraphQLObjectType;
    return this;
  }

  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public MarkImpressionsLoggedParams a()
  {
    Preconditions.checkNotNull(this.a);
    Preconditions.checkNotNull(this.b);
    return new MarkImpressionsLoggedParams(this.a, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.MarkImpressionsLoggedParams.Builder
 * JD-Core Version:    0.6.0
 */