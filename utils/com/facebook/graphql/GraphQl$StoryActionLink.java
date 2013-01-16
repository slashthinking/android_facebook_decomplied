package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$StoryActionLink
{
  public static final GraphQlQueryStoryActionLinkImpl.StoryActionLinkGenericField a = new GraphQlQueryStoryActionLinkImpl.StoryActionLinkGenericField("title");
  public static final GraphQlQueryStoryActionLinkImpl.StoryActionLinkGenericField b = new GraphQlQueryStoryActionLinkImpl.StoryActionLinkGenericField("url.site(mobile)");

  @Deprecated
  public static final GraphQlQueryStoryActionLinkImpl.StoryActionLinkGenericField c = new GraphQlQueryStoryActionLinkImpl.StoryActionLinkGenericField("type");

  public static GraphQlQueryStoryActionLinkImpl a(GraphQlQueryFieldStoryActionLink[] paramArrayOfGraphQlQueryFieldStoryActionLink)
  {
    return new GraphQlQueryStoryActionLinkImpl(ImmutableList.a(paramArrayOfGraphQlQueryFieldStoryActionLink), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.StoryActionLink
 * JD-Core Version:    0.6.2
 */