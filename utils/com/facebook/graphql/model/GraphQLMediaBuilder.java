package com.facebook.graphql.model;

public class GraphQLMediaBuilder extends FeedbackableGraphQLNodeBuilder
{
  private String a = null;
  private GraphQLImage b = null;
  private GraphQLImage c = null;
  private GraphQLImage d = null;
  private boolean e = false;
  private String f = null;
  private GraphQLObjectType g = null;

  public GraphQLMediaBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public String c()
  {
    return this.a;
  }

  public GraphQLImage d()
  {
    return this.b;
  }

  public GraphQLImage e()
  {
    return this.c;
  }

  public GraphQLImage f()
  {
    return this.d;
  }

  public boolean g()
  {
    return this.e;
  }

  public String h()
  {
    return this.f;
  }

  public GraphQLObjectType i()
  {
    return this.g;
  }

  public GraphQLMedia j()
  {
    return new GraphQLMedia(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLMediaBuilder
 * JD-Core Version:    0.6.2
 */