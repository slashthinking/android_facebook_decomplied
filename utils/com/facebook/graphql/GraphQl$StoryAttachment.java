package com.facebook.graphql;

import java.util.List;

public class GraphQl$StoryAttachment
{
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField a = new GraphQlQueryStoryAttachment.StoryAttachmentField("style_list");
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField b = new GraphQlQueryStoryAttachment.StoryAttachmentField("title");
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField c = new GraphQlQueryStoryAttachment.StoryAttachmentField("tracking");
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField d = new GraphQlQueryStoryAttachment.StoryAttachmentField("url.site(mobile)");

  @Deprecated
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField e = new GraphQlQueryStoryAttachment.StoryAttachmentField("target_url.site(mobile)");

  @Deprecated
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField f = new GraphQlQueryStoryAttachment.StoryAttachmentField("media_reference_token");

  @Deprecated
  public static final GraphQlQueryStoryAttachment.StoryAttachmentField g = new GraphQlQueryStoryAttachment.StoryAttachmentField("style");

  public static GraphQlQueryStoryAttachment.StoryAttachmentField a(GraphQlQueryMedia paramGraphQlQueryMedia)
  {
    return new GraphQlQueryStoryAttachment.StoryAttachmentField("media", paramGraphQlQueryMedia);
  }

  public static GraphQlQueryStoryAttachment.StoryAttachmentField a(GraphQlQueryNode paramGraphQlQueryNode)
  {
    return new GraphQlQueryStoryAttachment.StoryAttachmentField("target", paramGraphQlQueryNode);
  }

  public static GraphQlQueryStoryAttachment.StoryAttachmentField a(GraphQlQueryStoryActionLink paramGraphQlQueryStoryActionLink)
  {
    return new GraphQlQueryStoryAttachment.StoryAttachmentField("action_links", paramGraphQlQueryStoryActionLink);
  }

  public static GraphQlQueryStoryAttachment.StoryAttachmentField a(GraphQlQueryStoryAttachment paramGraphQlQueryStoryAttachment)
  {
    return new GraphQlQueryStoryAttachment.StoryAttachmentField("subattachments", paramGraphQlQueryStoryAttachment);
  }

  public static GraphQlQueryStoryAttachment.StoryAttachmentField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryStoryAttachment.StoryAttachmentField("description", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryStoryAttachment a(List<? extends GraphQlQueryStoryAttachment.StoryAttachmentField> paramList)
  {
    return new GraphQlQueryStoryAttachment(paramList, null);
  }

  public static GraphQlQueryStoryAttachment.StoryAttachmentField b(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryStoryAttachment.StoryAttachmentField("source", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.StoryAttachment
 * JD-Core Version:    0.6.2
 */