package com.facebook.graphql.model;

import com.google.common.base.Preconditions;

public class FeedbackBuilder
{
  public boolean a;
  private boolean b;
  private boolean c;
  private String d;
  private String e;
  private FeedStoryComments f = FeedStoryComments.a;
  private FeedStoryLikers g = FeedStoryLikers.a;
  private FeedStoryReshares h = FeedStoryReshares.a;
  private GraphQLObjectType i;
  private GraphQLTextWithEntities j;
  private GraphQLTextWithEntities k;
  private GraphQLTextWithEntities l;
  private long m;

  public static Feedback c(String paramString)
  {
    return new FeedbackBuilder().b(true).a(true).a((String)Preconditions.checkNotNull(paramString)).n();
  }

  public FeedbackBuilder a(long paramLong)
  {
    this.m = paramLong;
    return this;
  }

  public FeedbackBuilder a(FeedStoryComments paramFeedStoryComments)
  {
    this.f = paramFeedStoryComments;
    return this;
  }

  public FeedbackBuilder a(FeedStoryLikers paramFeedStoryLikers)
  {
    this.g = paramFeedStoryLikers;
    return this;
  }

  public FeedbackBuilder a(FeedStoryReshares paramFeedStoryReshares)
  {
    this.h = paramFeedStoryReshares;
    return this;
  }

  public FeedbackBuilder a(Feedback paramFeedback)
  {
    this.b = paramFeedback.canViewerLike;
    this.c = paramFeedback.canViewerComment;
    this.a = paramFeedback.doesViewerLike;
    this.d = paramFeedback.legacyApiPostId;
    this.f = paramFeedback.comments;
    this.g = paramFeedback.likers;
    this.h = paramFeedback.reshares;
    this.e = paramFeedback.id;
    this.j = paramFeedback.likeSentence;
    this.k = paramFeedback.viewerLikersSentence;
    this.l = paramFeedback.viewerDoesNotLikeSentence;
    this.m = paramFeedback.getFetchTimeMs();
    this.i = paramFeedback.type;
    return this;
  }

  public FeedbackBuilder a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public FeedbackBuilder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public boolean a()
  {
    return this.b;
  }

  public FeedbackBuilder b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public FeedbackBuilder b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public boolean b()
  {
    return this.c;
  }

  public FeedbackBuilder c(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }

  public boolean c()
  {
    return this.a;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }

  public FeedStoryComments f()
  {
    return this.f;
  }

  public FeedStoryLikers g()
  {
    return this.g;
  }

  public FeedStoryReshares h()
  {
    return this.h;
  }

  public GraphQLTextWithEntities i()
  {
    return this.j;
  }

  public GraphQLTextWithEntities j()
  {
    return this.k;
  }

  public GraphQLTextWithEntities k()
  {
    return this.l;
  }

  public long l()
  {
    return this.m;
  }

  public GraphQLObjectType m()
  {
    return this.i;
  }

  public Feedback n()
  {
    return new Feedback(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedbackBuilder
 * JD-Core Version:    0.6.2
 */