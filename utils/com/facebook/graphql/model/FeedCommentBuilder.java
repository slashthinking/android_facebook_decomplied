package com.facebook.graphql.model;

public class FeedCommentBuilder
{
  private String a;
  private GraphQLProfile b;
  private GraphQLTextWithEntities c;
  private long d;
  private Feedback e;
  private FeedOptimisticPublishState f;

  public FeedCommentBuilder()
  {
  }

  public FeedCommentBuilder(FeedComment paramFeedComment)
  {
    this.a = paramFeedComment.id;
    this.b = paramFeedComment.author;
    this.c = paramFeedComment.body;
    this.d = paramFeedComment.createdTime;
    this.e = paramFeedComment.S();
    this.f = paramFeedComment.c();
  }

  public FeedCommentBuilder a(long paramLong)
  {
    this.d = paramLong;
    return this;
  }

  public FeedCommentBuilder a(FeedOptimisticPublishState paramFeedOptimisticPublishState)
  {
    this.f = paramFeedOptimisticPublishState;
    return this;
  }

  public FeedCommentBuilder a(Feedback paramFeedback)
  {
    this.e = paramFeedback;
    return this;
  }

  public FeedCommentBuilder a(GraphQLProfile paramGraphQLProfile)
  {
    this.b = paramGraphQLProfile;
    return this;
  }

  public FeedCommentBuilder a(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    this.c = paramGraphQLTextWithEntities;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public GraphQLProfile b()
  {
    return this.b;
  }

  public GraphQLTextWithEntities c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public Feedback e()
  {
    return this.e;
  }

  public FeedOptimisticPublishState f()
  {
    return this.f;
  }

  public FeedComment g()
  {
    return new FeedComment(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedCommentBuilder
 * JD-Core Version:    0.6.2
 */