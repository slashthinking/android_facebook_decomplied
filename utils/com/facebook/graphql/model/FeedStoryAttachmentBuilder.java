package com.facebook.graphql.model;

import java.util.List;

public class FeedStoryAttachmentBuilder
{
  public FeedStory a;
  private String b;
  private String c;
  private String d;
  private GraphQLTextWithEntities e;
  private GraphQLTextWithEntities f;
  private GraphQLMedia g;
  private FeedStoryAttachmentTarget h;
  private List<GraphQLActionLink> i;
  private List<FeedStoryAttachment> j;
  private List<String> k;

  public FeedStoryAttachmentBuilder()
  {
  }

  public FeedStoryAttachmentBuilder(FeedStoryAttachment paramFeedStoryAttachment)
  {
    this.b = paramFeedStoryAttachment.title;
    this.c = paramFeedStoryAttachment.url;
    this.e = paramFeedStoryAttachment.description;
    this.f = paramFeedStoryAttachment.source;
    this.g = paramFeedStoryAttachment.media;
    this.h = paramFeedStoryAttachment.target;
    this.i = paramFeedStoryAttachment.actionLinks;
    this.j = paramFeedStoryAttachment.subattachments;
    this.k = paramFeedStoryAttachment.styleList;
    this.a = paramFeedStoryAttachment.a;
    this.d = paramFeedStoryAttachment.mediaReferenceToken;
  }

  public FeedStoryAttachmentBuilder a(GraphQLMedia paramGraphQLMedia)
  {
    this.g = paramGraphQLMedia;
    return this;
  }

  public FeedStoryAttachmentBuilder a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public FeedStoryAttachmentBuilder a(List<GraphQLActionLink> paramList)
  {
    this.i = paramList;
    return this;
  }

  public String a()
  {
    return this.b;
  }

  public FeedStoryAttachmentBuilder b(List<FeedStoryAttachment> paramList)
  {
    this.j = paramList;
    return this;
  }

  public String b()
  {
    return this.c;
  }

  public FeedStoryAttachmentBuilder c(List<String> paramList)
  {
    this.k = paramList;
    return this;
  }

  public GraphQLTextWithEntities c()
  {
    return this.e;
  }

  public GraphQLTextWithEntities d()
  {
    return this.f;
  }

  public GraphQLMedia e()
  {
    return this.g;
  }

  public String f()
  {
    return this.d;
  }

  public FeedStoryAttachmentTarget g()
  {
    return this.h;
  }

  public List<GraphQLActionLink> h()
  {
    return this.i;
  }

  public List<FeedStoryAttachment> i()
  {
    return this.j;
  }

  public List<String> j()
  {
    return this.k;
  }

  public FeedStoryAttachment k()
  {
    return new FeedStoryAttachment(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryAttachmentBuilder
 * JD-Core Version:    0.6.2
 */