package com.facebook.graphql;

public class GraphQl$LikePageActionLink
{
  public static final GraphQlQueryLikePageActionLink.LikePageActionLinkField a = new GraphQlQueryLikePageActionLink.LikePageActionLinkField("title");
  public static final GraphQlQueryLikePageActionLink.LikePageActionLinkField b = new GraphQlQueryLikePageActionLink.LikePageActionLinkField("url.site(mobile)");

  @Deprecated
  public static final GraphQlQueryLikePageActionLink.LikePageActionLinkField c = new GraphQlQueryLikePageActionLink.LikePageActionLinkField("type");

  public static GraphQlQueryLikePageActionLink.LikePageActionLinkField a(GraphQlQueryPage paramGraphQlQueryPage)
  {
    return new GraphQlQueryLikePageActionLink.LikePageActionLinkField("page", paramGraphQlQueryPage);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.LikePageActionLink
 * JD-Core Version:    0.6.2
 */