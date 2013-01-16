package com.facebook.contacts.graphql;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class GraphQLQueryBuilder
{
  private String a;
  private String b;
  private String c;
  private ImmutableList.Builder<GraphQLQueryFieldCall> d = ImmutableList.e();
  private ImmutableList.Builder<GraphQLQuery> e = ImmutableList.e();

  public GraphQLQueryBuilder a(GraphQLQuery paramGraphQLQuery)
  {
    this.e.b(paramGraphQLQuery);
    return this;
  }

  public GraphQLQueryBuilder a(GraphQLQueryFieldCall paramGraphQLQueryFieldCall)
  {
    this.d.b(paramGraphQLQueryFieldCall);
    return this;
  }

  public GraphQLQueryBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public GraphQLQueryBuilder a(String paramString, Object[] paramArrayOfObject)
  {
    return a(new GraphQLQueryFieldCall(paramString, paramArrayOfObject));
  }

  public String a()
  {
    return this.a;
  }

  public GraphQLQueryBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public GraphQLQueryBuilder c(String paramString)
  {
    return a(new GraphQLQueryBuilder().a(paramString).f());
  }

  public ImmutableList<GraphQLQuery> c()
  {
    return this.e.b();
  }

  public GraphQLQueryBuilder d(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String d()
  {
    return this.c;
  }

  public ImmutableList<GraphQLQueryFieldCall> e()
  {
    return this.d.b();
  }

  public GraphQLQuery f()
  {
    return new GraphQLQuery(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.graphql.GraphQLQueryBuilder
 * JD-Core Version:    0.6.0
 */