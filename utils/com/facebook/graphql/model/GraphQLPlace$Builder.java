package com.facebook.graphql.model;

import java.util.List;

public class GraphQLPlace$Builder extends GraphQLProfile.Builder
{
  private GraphQLLocation a = null;
  private String b = null;
  private GraphQLAddress c = null;
  private List<String> d = null;
  private float e = 0.0F;
  private GraphQLProfileList f = null;
  private GraphQLProfileList g = null;
  private GraphQLProfileList h = null;

  public GraphQLPlace a()
  {
    return new GraphQLPlace(this);
  }

  public void a(GraphQLLocation paramGraphQLLocation)
  {
    this.a = paramGraphQLLocation;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPlace.Builder
 * JD-Core Version:    0.6.2
 */