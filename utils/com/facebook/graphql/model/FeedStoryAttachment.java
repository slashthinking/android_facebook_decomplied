package com.facebook.graphql.model;

import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FeedStoryAttachment
{

  @JsonIgnore
  public FeedStory a;

  @JsonProperty("action_links")
  public final List<GraphQLActionLink> actionLinks;

  @JsonIgnore
  private FeedStoryAttachmentType.KnownAttachmentType b = null;

  @JsonIgnore
  private String c;
  private boolean d;

  @JsonProperty("description")
  public final GraphQLTextWithEntities description;

  @JsonProperty("media")
  public final GraphQLMedia media;

  @JsonProperty("media_reference_token")
  public final String mediaReferenceToken;

  @JsonProperty("source")
  public final GraphQLTextWithEntities source;

  @JsonProperty("style_list")
  public final List<String> styleList;

  @JsonProperty("subattachments")
  public final List<FeedStoryAttachment> subattachments;

  @JsonProperty("target")
  public final FeedStoryAttachmentTarget target;

  @JsonProperty("title")
  public final String title;

  @JsonProperty("url")
  public final String url;

  protected FeedStoryAttachment()
  {
    this.title = null;
    this.url = null;
    this.a = null;
    this.description = null;
    this.source = null;
    this.media = null;
    this.target = null;
    this.actionLinks = Collections.emptyList();
    this.subattachments = null;
    this.styleList = null;
    this.mediaReferenceToken = null;
  }

  public FeedStoryAttachment(FeedStoryAttachmentBuilder paramFeedStoryAttachmentBuilder)
  {
    this.title = paramFeedStoryAttachmentBuilder.a();
    this.url = paramFeedStoryAttachmentBuilder.b();
    this.a = null;
    this.description = paramFeedStoryAttachmentBuilder.c();
    this.source = paramFeedStoryAttachmentBuilder.d();
    this.media = paramFeedStoryAttachmentBuilder.e();
    this.target = paramFeedStoryAttachmentBuilder.g();
    this.actionLinks = paramFeedStoryAttachmentBuilder.h();
    this.subattachments = paramFeedStoryAttachmentBuilder.i();
    this.styleList = paramFeedStoryAttachmentBuilder.j();
    this.mediaReferenceToken = paramFeedStoryAttachmentBuilder.f();
  }

  private void m()
  {
    Iterator localIterator = this.styleList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != null) && (FeedStoryAttachmentType.a.contains(str.toUpperCase())))
        this.b = FeedStoryAttachmentType.KnownAttachmentType.valueOf(str.toUpperCase());
    }
    if (this.b == null)
      this.b = FeedStoryAttachmentType.KnownAttachmentType.BASE;
  }

  private void n()
  {
    switch (FeedStoryAttachment.1.a[this.b.ordinal()])
    {
    default:
      this.c = "unknown_attachment";
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      if (StringUtil.a(this.c))
        this.c = "unknown_attachment";
      return;
      this.c = this.url;
      continue;
      if ((this.media == null) || (this.media.image == null))
      {
        this.c = "unknown_attachment";
      }
      else
      {
        this.c = this.media.image.uri;
        continue;
        if (this.media == null)
        {
          this.c = "unknown_attachment";
        }
        else
        {
          this.c = this.media.id;
          continue;
          StringBuilder localStringBuilder = new StringBuilder();
          if (h())
          {
            Iterator localIterator = this.subattachments.iterator();
            while (localIterator.hasNext())
              localStringBuilder.append(((FeedStoryAttachment)localIterator.next()).i());
          }
          this.c = localStringBuilder.toString();
        }
      }
    }
  }

  public void a()
  {
    if (h())
    {
      Iterator localIterator = this.subattachments.iterator();
      while (localIterator.hasNext())
        ((FeedStoryAttachment)localIterator.next()).a();
    }
    m();
    n();
  }

  @JsonIgnore
  public void a(FeedStory paramFeedStory)
  {
    this.a = paramFeedStory;
    if (this.media != null)
      this.media.a = this.a;
    if (this.subattachments != null)
    {
      Iterator localIterator = this.subattachments.iterator();
      while (localIterator.hasNext())
        ((FeedStoryAttachment)localIterator.next()).a(paramFeedStory);
    }
  }

  @JsonIgnore
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  @JsonIgnore
  public GraphQLTextWithEntities b()
  {
    if (this.source != null);
    for (GraphQLTextWithEntities localGraphQLTextWithEntities = this.source; ; localGraphQLTextWithEntities = this.description)
      return localGraphQLTextWithEntities;
  }

  @JsonIgnore
  public boolean c()
  {
    if ((this.target != null) && (this.target.objectType != null) && (this.target.objectType.a() == GraphQLObjectType.ObjectType.Application));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean d()
  {
    if ((c()) || ((this.target != null) && (this.target.objectType.a() == GraphQLObjectType.ObjectType.OpenGraphObject) && (this.target.application != null) && (this.target.application.androidStoreUrl != null)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean e()
  {
    if (this.b == FeedStoryAttachmentType.KnownAttachmentType.QUESTION);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof FeedStoryAttachment)) && (i() != null));
    for (boolean bool = Objects.equal(i(), ((FeedStoryAttachment)paramObject).i()); ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean f()
  {
    if (this.b == FeedStoryAttachmentType.KnownAttachmentType.POPULAR_OBJECTS);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean g()
  {
    if ((this.styleList.contains(FeedStoryAttachmentType.KnownAttachmentType.PHOTO.toString().toLowerCase())) || (this.styleList.contains(FeedStoryAttachmentType.KnownAttachmentType.ALBUM.toString().toLowerCase())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean h()
  {
    if ((this.subattachments != null) && (!this.subattachments.isEmpty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public String i()
  {
    if (this.c == null)
    {
      if (this.b == null)
        m();
      n();
    }
    return this.c;
  }

  @JsonIgnore
  public FeedStoryAttachmentType.KnownAttachmentType j()
  {
    if (this.b == null)
      m();
    return this.b;
  }

  @JsonIgnore
  public boolean k()
  {
    return this.d;
  }

  @JsonIgnore
  public boolean l()
  {
    if ((this.target != null) && (this.target.objectType != null) && ((this.target.objectType.a() == GraphQLObjectType.ObjectType.OpenGraphObject) || (this.target.objectType.a() == GraphQLObjectType.ObjectType.OpenGraphAction)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryAttachment
 * JD-Core Version:    0.6.2
 */