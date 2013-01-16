package com.facebook.feed.data;

import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedCommentBuilder;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FeedbackMutator
{
  private static FeedStoryComments a(FeedStoryComments paramFeedStoryComments, FeedComment paramFeedComment1, FeedComment paramFeedComment2)
  {
    if (paramFeedStoryComments.comments == null);
    while (true)
    {
      return paramFeedStoryComments;
      HashSet localHashSet = Sets.a(paramFeedStoryComments.comments);
      localHashSet.remove(paramFeedComment1);
      localHashSet.add(paramFeedComment2);
      paramFeedStoryComments = new FeedStoryComments(paramFeedStoryComments.count, localHashSet, paramFeedStoryComments.pageInfo);
    }
  }

  private static FeedStoryLikers a(FeedStoryLikers paramFeedStoryLikers, GraphQLProfile paramGraphQLProfile)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramFeedStoryLikers.likers.iterator();
    while (localIterator.hasNext())
    {
      GraphQLProfile localGraphQLProfile = (GraphQLProfile)localIterator.next();
      if (Objects.equal(localGraphQLProfile.id, paramGraphQLProfile.id))
        continue;
      localBuilder.b(localGraphQLProfile);
    }
    return new FeedStoryLikers(-1 + paramFeedStoryLikers.count, localBuilder.b(), paramFeedStoryLikers.pageInfo);
  }

  private static FeedStoryLikers b(FeedStoryLikers paramFeedStoryLikers, GraphQLProfile paramGraphQLProfile)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramFeedStoryLikers.likers.iterator();
    GraphQLProfile localGraphQLProfile;
    if (localIterator.hasNext())
    {
      localGraphQLProfile = (GraphQLProfile)localIterator.next();
      if (!Objects.equal(localGraphQLProfile.id, paramGraphQLProfile.id));
    }
    while (true)
    {
      return paramFeedStoryLikers;
      localBuilder.b(localGraphQLProfile);
      break;
      localBuilder.b(paramGraphQLProfile);
      paramFeedStoryLikers = new FeedStoryLikers(1 + paramFeedStoryLikers.count, localBuilder.b(), paramFeedStoryLikers.pageInfo);
    }
  }

  public FeedbackMutator.Result a(Feedback paramFeedback, FeedComment paramFeedComment, GraphQLProfile paramGraphQLProfile)
  {
    Feedback localFeedback = a(paramFeedComment.S(), paramGraphQLProfile);
    FeedComment localFeedComment = new FeedCommentBuilder(paramFeedComment).a(localFeedback).g();
    if ((paramFeedback.comments == null) || (paramFeedback.comments.comments.isEmpty()));
    FeedStoryComments localFeedStoryComments;
    for (FeedbackMutator.Result localResult = new FeedbackMutator.Result(paramFeedback, localFeedComment); ; localResult = new FeedbackMutator.Result(new FeedbackBuilder().a(paramFeedback).a(localFeedStoryComments).a(localFeedback.getFetchTimeMs()).n(), localFeedComment))
    {
      return localResult;
      localFeedStoryComments = a(paramFeedback.comments, paramFeedComment, localFeedComment);
    }
  }

  public Feedback a(Feedback paramFeedback, FeedComment paramFeedComment)
  {
    FeedStoryComments localFeedStoryComments1 = paramFeedback.comments;
    if ((localFeedStoryComments1 != null) && (localFeedStoryComments1.comments.contains(paramFeedComment)));
    while (true)
    {
      return paramFeedback;
      ImmutableSet.Builder localBuilder = ImmutableSet.e();
      GraphQLPageInfo localGraphQLPageInfo = GraphQLPageInfo.a;
      int i = 0;
      if (localFeedStoryComments1 != null)
      {
        localBuilder.b(localFeedStoryComments1.comments.iterator());
        i = localFeedStoryComments1.count;
        localGraphQLPageInfo = localFeedStoryComments1.pageInfo;
      }
      localBuilder.b(paramFeedComment);
      FeedStoryComments localFeedStoryComments2 = new FeedStoryComments(i + 1, localBuilder.b(), localGraphQLPageInfo);
      paramFeedback = new FeedbackBuilder().a(paramFeedback).a(localFeedStoryComments2).a(System.currentTimeMillis()).n();
    }
  }

  public Feedback a(Feedback paramFeedback, GraphQLProfile paramGraphQLProfile)
  {
    boolean bool;
    FeedbackBuilder localFeedbackBuilder;
    if (!paramFeedback.doesViewerLike)
    {
      bool = true;
      localFeedbackBuilder = new FeedbackBuilder().a(paramFeedback);
      localFeedbackBuilder.a(System.currentTimeMillis());
      localFeedbackBuilder.c(bool);
      if (!bool)
        break label71;
    }
    label71: for (FeedStoryLikers localFeedStoryLikers = b(paramFeedback.likers, paramGraphQLProfile); ; localFeedStoryLikers = a(paramFeedback.likers, paramGraphQLProfile))
    {
      localFeedbackBuilder.a(localFeedStoryLikers);
      return localFeedbackBuilder.n();
      bool = false;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.FeedbackMutator
 * JD-Core Version:    0.6.0
 */