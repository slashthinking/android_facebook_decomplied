package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Feedback
{
  public static final GraphQlQueryFeedback.FeedbackField a = new GraphQlQueryFeedback.FeedbackField("id");
  public static final GraphQlQueryFeedback.FeedbackField b = new GraphQlQueryFeedback.FeedbackField("url.site(mobile)");
  public static final GraphQlQueryFeedback.FeedbackField c = new GraphQlQueryFeedback.FeedbackField("can_viewer_comment");
  public static final GraphQlQueryFeedback.FeedbackField d = new GraphQlQueryFeedback.FeedbackField("can_viewer_like");
  public static final GraphQlQueryFeedback.FeedbackField e = new GraphQlQueryFeedback.FeedbackField("does_viewer_like");
  public static final GraphQlQueryFeedback.FeedbackField f = new GraphQlQueryFeedback.FeedbackField("supports_ranked_comments");
  public static final GraphQlQueryFeedback.FeedbackField g = new GraphQlQueryFeedback.FeedbackField("legacy_api_post_id");
  public static final GraphQlQueryFeedback.FeedbackField h = new GraphQlQueryFeedback.FeedbackField("parent_object_id");

  @Deprecated
  public static final GraphQlQueryFeedback.FeedbackField i = new GraphQlQueryFeedback.FeedbackField("feedback_token");

  public static GraphQlQueryFeedback.FeedbackField a(GraphQlQueryCommentsConnection paramGraphQlQueryCommentsConnection)
  {
    return new GraphQlQueryFeedback.FeedbackField("comments", paramGraphQlQueryCommentsConnection);
  }

  public static GraphQlQueryFeedback.FeedbackField a(GraphQlQueryLikersOfContentConnection paramGraphQlQueryLikersOfContentConnection)
  {
    return new GraphQlQueryFeedback.FeedbackField("likers", paramGraphQlQueryLikersOfContentConnection);
  }

  public static GraphQlQueryFeedback.FeedbackField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryFeedback.FeedbackField("like_sentence", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryFeedback a(GraphQlQueryFeedback.FeedbackField[] paramArrayOfFeedbackField)
  {
    return new GraphQlQueryFeedback(ImmutableList.a(paramArrayOfFeedbackField), null);
  }

  public static GraphQlQueryFeedback.FeedbackField b(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryFeedback.FeedbackField("viewer_likes_sentence", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryFeedback.FeedbackField c(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryFeedback.FeedbackField("viewer_does_not_like_sentence", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Feedback
 * JD-Core Version:    0.6.2
 */