package com.facebook.feed.data;

import com.facebook.common.util.Log;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class FeedStoryMutator
{
  private static final String a = FeedStoryMutator.class.getSimpleName();
  private final FeedbackMutator b;
  private final ActionLinkMutator c;
  private final ActionLinkListMutator d;
  private final AttachmentMutator e;
  private final AttachmentListMutator f;

  public FeedStoryMutator(FeedbackMutator paramFeedbackMutator, AttachmentMutator paramAttachmentMutator, AttachmentListMutator paramAttachmentListMutator, ActionLinkMutator paramActionLinkMutator, ActionLinkListMutator paramActionLinkListMutator)
  {
    this.b = paramFeedbackMutator;
    this.e = paramAttachmentMutator;
    this.f = paramAttachmentListMutator;
    this.c = paramActionLinkMutator;
    this.d = paramActionLinkListMutator;
  }

  private FeedStoryMutator.Result b(FeedStory paramFeedStory, GraphQLActionLink paramGraphQLActionLink)
  {
    Preconditions.checkNotNull(paramFeedStory.actionLinks);
    GraphQLActionLink localGraphQLActionLink = this.c.a(paramGraphQLActionLink);
    ImmutableList localImmutableList = this.d.a(paramFeedStory.actionLinks, localGraphQLActionLink);
    FeedStory localFeedStory = new FeedStoryBuilder(paramFeedStory).d(localImmutableList).b(System.currentTimeMillis()).G();
    return new FeedStoryMutator.Result(b(localFeedStory, paramFeedStory), localFeedStory);
  }

  private FeedStoryMutator.Result c(FeedStory paramFeedStory, GraphQLActionLink paramGraphQLActionLink)
  {
    Preconditions.checkNotNull(paramFeedStory.attachedActionLinks);
    GraphQLActionLink localGraphQLActionLink = this.c.a(paramGraphQLActionLink);
    ImmutableList localImmutableList = this.d.a(paramFeedStory.attachedActionLinks, localGraphQLActionLink);
    FeedStory localFeedStory = new FeedStoryBuilder(paramFeedStory).e(localImmutableList).b(System.currentTimeMillis()).G();
    return new FeedStoryMutator.Result(b(localFeedStory, paramFeedStory), localFeedStory);
  }

  private FeedStoryMutator.Result d(FeedStory paramFeedStory, GraphQLActionLink paramGraphQLActionLink)
  {
    Preconditions.checkNotNull(paramFeedStory.e());
    FeedStoryAttachment localFeedStoryAttachment1 = paramFeedStory.e();
    FeedStoryAttachment localFeedStoryAttachment2 = this.e.a(localFeedStoryAttachment1, paramGraphQLActionLink);
    ImmutableList localImmutableList = this.f.a(paramFeedStory.attachments, localFeedStoryAttachment2);
    FeedStory localFeedStory = new FeedStoryBuilder(paramFeedStory).c(localImmutableList).b(System.currentTimeMillis()).G();
    return new FeedStoryMutator.Result(b(localFeedStory, paramFeedStory), localFeedStory);
  }

  public FeedStoryMutator.Result a(FeedStory paramFeedStory, FeedComment paramFeedComment, GraphQLProfile paramGraphQLProfile)
  {
    FeedbackMutator.Result localResult = this.b.a(paramFeedStory.S(), paramFeedComment, paramGraphQLProfile);
    return new FeedStoryMutator.Result(null, new FeedStoryBuilder(paramFeedStory).a(localResult.a).b(localResult.a.getFetchTimeMs()).G(), localResult.b);
  }

  public FeedStoryMutator.Result a(FeedStory paramFeedStory, GraphQLActionLink paramGraphQLActionLink)
  {
    int i = FeedStoryMutator.1.a[paramFeedStory.A().ordinal()];
    FeedStoryMutator.Result localResult = null;
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return localResult;
      localResult = d(paramFeedStory, paramGraphQLActionLink);
      continue;
      localResult = c(paramFeedStory, paramGraphQLActionLink);
      continue;
      localResult = c(paramFeedStory.a, paramGraphQLActionLink);
      continue;
      localResult = b(paramFeedStory, paramGraphQLActionLink);
    }
  }

  public FeedStoryMutator.Result a(FeedStory paramFeedStory, GraphQLProfile paramGraphQLProfile)
  {
    Feedback localFeedback = this.b.a(paramFeedStory.S(), paramGraphQLProfile);
    FeedStory localFeedStory = new FeedStoryBuilder(paramFeedStory).a(localFeedback).b(localFeedback.getFetchTimeMs()).G();
    return new FeedStoryMutator.Result(b(localFeedStory, paramFeedStory), localFeedStory);
  }

  public FeedStory a(FeedStory paramFeedStory1, FeedStory paramFeedStory2)
  {
    FeedStory localFeedStory1 = paramFeedStory1.a;
    FeedStory localFeedStory2;
    if (localFeedStory1 == null)
      localFeedStory2 = null;
    Object localObject;
    label40: int i;
    while (true)
    {
      return localFeedStory2;
      if (localFeedStory1.attachedStory == paramFeedStory2)
      {
        localObject = new FeedStoryBuilder(localFeedStory1);
        ((FeedStoryBuilder)localObject).b(paramFeedStory1);
        if (localObject == null)
        {
          Log.a(a, "FeedStory parent pointers are corrupted");
          localFeedStory2 = null;
          continue;
        }
      }
      else
      {
        if (localFeedStory1.substories == null)
          break label229;
        Iterator localIterator1 = localFeedStory1.substories.iterator();
        i = 0;
        label80: if (!localIterator1.hasNext())
          break;
        if ((FeedStory)localIterator1.next() != paramFeedStory2)
          break label235;
      }
    }
    label229: label235: for (int j = 1; ; j = i)
    {
      i = j;
      break label80;
      if (i != 0)
      {
        FeedStoryBuilder localFeedStoryBuilder = new FeedStoryBuilder(localFeedStory1);
        ImmutableList.Builder localBuilder = ImmutableList.e();
        Iterator localIterator2 = localFeedStory1.substories.iterator();
        while (localIterator2.hasNext())
        {
          FeedStory localFeedStory3 = (FeedStory)localIterator2.next();
          if (localFeedStory3 != paramFeedStory2)
          {
            localBuilder.b(localFeedStory3);
            continue;
          }
          localBuilder.b(paramFeedStory1);
        }
        localFeedStoryBuilder.f(localBuilder.b());
        localObject = localFeedStoryBuilder;
        break label40;
        localFeedStory2 = ((FeedStoryBuilder)localObject).b(paramFeedStory1.getFetchTimeMs()).G();
        break;
      }
      localObject = null;
      break label40;
    }
  }

  public FeedStory b(FeedStory paramFeedStory1, FeedStory paramFeedStory2)
  {
    if (paramFeedStory1.a != null)
    {
      if (paramFeedStory1 == paramFeedStory2);
      for (paramFeedStory1 = paramFeedStory1.a; ; paramFeedStory1 = a(paramFeedStory1, paramFeedStory2))
      {
        paramFeedStory2 = paramFeedStory1.a;
        break;
      }
    }
    paramFeedStory1.a(null);
    return paramFeedStory1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.FeedStoryMutator
 * JD-Core Version:    0.6.0
 */