package com.facebook.contacts.graphql;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class GraphQLQuery
{
  private final String a;
  private final String b;
  private final String c;
  private final ImmutableList<GraphQLQueryFieldCall> d;
  private final ImmutableList<GraphQLQuery> e;

  GraphQLQuery(GraphQLQueryBuilder paramGraphQLQueryBuilder)
  {
    this.a = paramGraphQLQueryBuilder.a();
    this.b = paramGraphQLQueryBuilder.b();
    this.c = paramGraphQLQueryBuilder.d();
    this.d = paramGraphQLQueryBuilder.e();
    this.e = ImmutableList.a(paramGraphQLQueryBuilder.c());
  }

  public static GraphQLQueryBuilder a()
  {
    return new GraphQLQueryBuilder().b("me()");
  }

  public static GraphQLQueryBuilder a(Iterable<String> paramIterable)
  {
    StringBuilder localStringBuilder = new StringBuilder("nodes(");
    Joiner.on(",").appendTo(localStringBuilder, paramIterable);
    localStringBuilder.append(")");
    return new GraphQLQueryBuilder().b(localStringBuilder.toString());
  }

  public static GraphQLQueryBuilder a(String paramString)
  {
    return new GraphQLQueryBuilder().b("node(" + paramString + ")");
  }

  public static GraphQLQueryBuilder b(String paramString)
  {
    return new GraphQLQueryBuilder().a(paramString);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
    {
      localStringBuilder.append(this.a);
      if (this.b != null)
        localStringBuilder.append(".");
    }
    if (this.b != null)
      localStringBuilder.append(this.b);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      GraphQLQueryFieldCall localGraphQLQueryFieldCall = (GraphQLQueryFieldCall)localIterator.next();
      localStringBuilder.append(".");
      localStringBuilder.append(localGraphQLQueryFieldCall.a());
      localStringBuilder.append("(");
      Joiner.on(",").appendTo(localStringBuilder, localGraphQLQueryFieldCall.b());
      localStringBuilder.append(")");
    }
    if (this.c != null)
    {
      localStringBuilder.append(" as ");
      localStringBuilder.append(this.c);
    }
    if (this.e.size() > 0)
    {
      localStringBuilder.append("{");
      Joiner.on(",").appendTo(localStringBuilder, this.e);
      localStringBuilder.append("}");
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.graphql.GraphQLQuery
 * JD-Core Version:    0.6.0
 */