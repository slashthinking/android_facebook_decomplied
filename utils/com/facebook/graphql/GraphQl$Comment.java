package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Comment
{
  public static final GraphQlQueryComment.CommentField a = new GraphQlQueryComment.CommentField("id");
  public static final GraphQlQueryComment.CommentField b = new GraphQlQueryComment.CommentField("url.site(mobile)");
  public static final GraphQlQueryComment.CommentField c = new GraphQlQueryComment.CommentField("created_time");
  public static final GraphQlQueryComment.CommentField d = new GraphQlQueryComment.CommentField("translation_available_for_viewer");

  @Deprecated
  public static final GraphQlQueryComment.CommentField e = new GraphQlQueryComment.CommentField("plain_body");

  @Deprecated
  public static final GraphQlQueryComment.CommentField f = new GraphQlQueryComment.CommentField("timestamp");

  public static GraphQlQueryComment.CommentField a(GraphQlQueryActor paramGraphQlQueryActor)
  {
    return new GraphQlQueryComment.CommentField("author", paramGraphQlQueryActor);
  }

  public static GraphQlQueryComment.CommentField a(GraphQlQueryFeedback paramGraphQlQueryFeedback)
  {
    return new GraphQlQueryComment.CommentField("feedback", paramGraphQlQueryFeedback);
  }

  public static GraphQlQueryComment.CommentField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryComment.CommentField("body", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryComment a(GraphQlQueryComment.CommentField[] paramArrayOfCommentField)
  {
    return new GraphQlQueryComment(ImmutableList.a(paramArrayOfCommentField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Comment
 * JD-Core Version:    0.6.2
 */