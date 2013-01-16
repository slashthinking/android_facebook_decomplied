package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Viewer
{
  public static GraphQlQueryViewer.ViewerField a(GraphQlQueryFriendingPossibilitiesConnection paramGraphQlQueryFriendingPossibilitiesConnection)
  {
    return new GraphQlQueryViewer.ViewerField("friending_possibilities", paramGraphQlQueryFriendingPossibilitiesConnection);
  }

  public static GraphQlQueryViewer a(GraphQlQueryViewer.ViewerField[] paramArrayOfViewerField)
  {
    return new GraphQlQueryViewer(ImmutableList.a(paramArrayOfViewerField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Viewer
 * JD-Core Version:    0.6.2
 */