package com.facebook.composer.optimistic;

import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedCommentBuilder;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

public class FeedCommentPreview
{
  public static FeedComment a(GraphQLProfile paramGraphQLProfile, GraphQLTextWithEntities paramGraphQLTextWithEntities, String paramString)
  {
    Feedback localFeedback = new FeedbackBuilder().a(paramString).a(true).n();
    return new FeedCommentBuilder().a(paramGraphQLProfile).a(paramGraphQLTextWithEntities).a(System.currentTimeMillis() / 1000L).a(localFeedback).a(FeedOptimisticPublishState.SUCCESS).g();
  }

  public static FeedComment a(GraphQLProfile paramGraphQLProfile, String paramString, List<GraphQLEntityRange> paramList)
  {
    Preconditions.checkNotNull(paramGraphQLProfile);
    Preconditions.checkNotNull(paramString);
    Feedback localFeedback = new FeedbackBuilder().n();
    GraphQLTextWithEntities localGraphQLTextWithEntities = new GraphQLTextWithEntities(paramString, paramList, Lists.a());
    return new FeedCommentBuilder().a(paramGraphQLProfile).a(localGraphQLTextWithEntities).a(System.currentTimeMillis() / 1000L).a(localFeedback).a(FeedOptimisticPublishState.POSTING).g();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.optimistic.FeedCommentPreview
 * JD-Core Version:    0.6.2
 */