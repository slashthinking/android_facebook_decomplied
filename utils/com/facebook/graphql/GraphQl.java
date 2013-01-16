package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl
{
  public static GraphQlQueryRootCallActor a()
  {
    return new GraphQlQueryRootCallActor("me", null, null);
  }

  public static GraphQlQueryRootCallNode a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryRootCallNode("node", null, ImmutableList.a(paramGraphQlQueryParam));
  }

  public static GraphQlQueryRootCallNode a(String paramString)
  {
    return new GraphQlQueryRootCallNode("node", ImmutableList.a(paramString), null);
  }

  public static GraphQlQueryRootCallNode a(String[] paramArrayOfString)
  {
    return new GraphQlQueryRootCallNode("nodes", ImmutableList.a(paramArrayOfString), null);
  }

  public static GraphQlQueryRootCallStory b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryRootCallStory("story", null, ImmutableList.a(paramGraphQlQueryParam));
  }

  public static GraphQlQueryRootCallViewer b()
  {
    return new GraphQlQueryRootCallViewer("viewer", null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl
 * JD-Core Version:    0.6.2
 */