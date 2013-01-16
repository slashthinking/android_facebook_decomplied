package com.facebook.graphql;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQl$Story
{
  public static final GraphQlQueryStory.StoryField a = new GraphQlQueryStory.StoryField("id");
  public static final GraphQlQueryStory.StoryField b = new GraphQlQueryStory.StoryField("url.site(mobile)");
  public static final GraphQlQueryStory.StoryField c = new GraphQlQueryStory.StoryField("debug_info");
  public static final GraphQlQueryStory.StoryField d = new GraphQlQueryStory.StoryField("cache_id");
  public static final GraphQlQueryStory.StoryField e = new GraphQlQueryStory.StoryField("can_viewer_delete");
  public static final GraphQlQueryStory.StoryField f = new GraphQlQueryStory.StoryField("creation_time");
  public static final GraphQlQueryStory.StoryField g = new GraphQlQueryStory.StoryField("substory_count");
  public static final GraphQlQueryStory.StoryField h = new GraphQlQueryStory.StoryField("tracking");
  public static final GraphQlQueryStory.StoryField i = new GraphQlQueryStory.StoryField("seen_state");

  @Deprecated
  public static final GraphQlQueryStory.StoryField j = new GraphQlQueryStory.StoryField("legacy_api_story_id");

  @Deprecated
  public static final GraphQlQueryStory.StoryField k = new GraphQlQueryStory.StoryField("sponsored");

  @Deprecated
  public static final GraphQlQueryStory.StoryField l = new GraphQlQueryStory.StoryField("style_list");

  @Deprecated
  public static final GraphQlQueryStory.StoryField m = new GraphQlQueryStory.StoryField("unique_identifier");

  public static GraphQlQueryStory.StoryField a(GraphQlQueryActor paramGraphQlQueryActor)
  {
    return new GraphQlQueryStory.StoryField("actors", paramGraphQlQueryActor);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryApplication paramGraphQlQueryApplication)
  {
    return new GraphQlQueryStory.StoryField("application", paramGraphQlQueryApplication);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryEntity paramGraphQlQueryEntity)
  {
    return new GraphQlQueryStory.StoryField("shareable", paramGraphQlQueryEntity);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryFeedback paramGraphQlQueryFeedback)
  {
    return new GraphQlQueryStory.StoryField("feedback", paramGraphQlQueryFeedback);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryIcon paramGraphQlQueryIcon)
  {
    return new GraphQlQueryStory.StoryField("icon", paramGraphQlQueryIcon);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryPlace paramGraphQlQueryPlace)
  {
    return new GraphQlQueryStory.StoryField("explicit_place", paramGraphQlQueryPlace);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryPrivacyScope paramGraphQlQueryPrivacyScope)
  {
    return new GraphQlQueryStory.StoryField("privacy_scope", paramGraphQlQueryPrivacyScope);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryProfile paramGraphQlQueryProfile)
  {
    return new GraphQlQueryStory.StoryField("to", paramGraphQlQueryProfile);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryReportInfo paramGraphQlQueryReportInfo)
  {
    return new GraphQlQueryStory.StoryField("report_info", paramGraphQlQueryReportInfo);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQuerySponsoredData paramGraphQlQuerySponsoredData)
  {
    return new GraphQlQueryStory.StoryField("sponsored_data", paramGraphQlQuerySponsoredData);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryStory paramGraphQlQueryStory)
  {
    return new GraphQlQueryStory.StoryField("attached_story", paramGraphQlQueryStory);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryStoryActionLink paramGraphQlQueryStoryActionLink)
  {
    return new GraphQlQueryStory.StoryField("action_links", paramGraphQlQueryStoryActionLink);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryStoryAttachment paramGraphQlQueryStoryAttachment)
  {
    return new GraphQlQueryStory.StoryField("attachments", paramGraphQlQueryStoryAttachment);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryStoryInsights paramGraphQlQueryStoryInsights)
  {
    return new GraphQlQueryStory.StoryField("insights", paramGraphQlQueryStoryInsights);
  }

  public static GraphQlQueryStory.StoryField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryStory.StoryField("message", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryStory a(List<? extends GraphQlQueryStory.StoryField> paramList)
  {
    return new GraphQlQueryStory(null, paramList, null);
  }

  public static GraphQlQueryStory a(GraphQlQueryStory.StoryField[] paramArrayOfStoryField)
  {
    return new GraphQlQueryStory(null, ImmutableList.a(paramArrayOfStoryField), null);
  }

  public static GraphQlQueryStory.StoryField b(GraphQlQueryActor paramGraphQlQueryActor)
  {
    return new GraphQlQueryStory.StoryField("via", paramGraphQlQueryActor);
  }

  public static GraphQlQueryStory.StoryField b(GraphQlQueryPlace paramGraphQlQueryPlace)
  {
    return new GraphQlQueryStory.StoryField("implicit_place", paramGraphQlQueryPlace);
  }

  public static GraphQlQueryStory.StoryField b(GraphQlQueryProfile paramGraphQlQueryProfile)
  {
    return new GraphQlQueryStory.StoryField("with", paramGraphQlQueryProfile);
  }

  public static GraphQlQueryStory.StoryField b(GraphQlQueryStory paramGraphQlQueryStory)
  {
    return new GraphQlQueryStory.StoryField("substories", paramGraphQlQueryStory);
  }

  public static GraphQlQueryStory.StoryField b(GraphQlQueryStoryActionLink paramGraphQlQueryStoryActionLink)
  {
    return new GraphQlQueryStory.StoryField("attached_action_links", paramGraphQlQueryStoryActionLink);
  }

  public static GraphQlQueryStory.StoryField b(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryStory.StoryField("suffix", paramGraphQlQueryTextWithEntities);
  }

  @Deprecated
  public static GraphQlQueryStory.StoryField c(GraphQlQueryStoryActionLink paramGraphQlQueryStoryActionLink)
  {
    return new GraphQlQueryStory.StoryField("secondary_actions", paramGraphQlQueryStoryActionLink);
  }

  public static GraphQlQueryStory.StoryField c(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryStory.StoryField("title", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Story
 * JD-Core Version:    0.6.2
 */