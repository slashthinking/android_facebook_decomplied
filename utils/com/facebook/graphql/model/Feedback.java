package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback
  implements Parcelable
{
  private long a = -1L;

  @JsonProperty("can_viewer_comment")
  public final boolean canViewerComment;

  @JsonProperty("can_viewer_like")
  public final boolean canViewerLike;

  @JsonProperty("comments")
  public final FeedStoryComments comments;

  @JsonProperty("does_viewer_like")
  public boolean doesViewerLike;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("legacy_api_post_id")
  public final String legacyApiPostId;

  @JsonProperty("like_sentence")
  public final GraphQLTextWithEntities likeSentence;

  @JsonProperty("likers")
  public final FeedStoryLikers likers;

  @JsonProperty("reshares")
  public final FeedStoryReshares reshares;

  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  @JsonProperty("viewer_does_not_like_sentence")
  public final GraphQLTextWithEntities viewerDoesNotLikeSentence;

  @JsonProperty("viewer_likes_sentence")
  public final GraphQLTextWithEntities viewerLikersSentence;

  protected Feedback()
  {
    this.canViewerLike = false;
    this.canViewerComment = false;
    this.doesViewerLike = false;
    this.legacyApiPostId = null;
    this.comments = FeedStoryComments.a;
    this.likers = FeedStoryLikers.a;
    this.reshares = FeedStoryReshares.a;
    this.id = null;
    this.likeSentence = null;
    this.viewerLikersSentence = null;
    this.viewerDoesNotLikeSentence = null;
    this.type = null;
  }

  Feedback(FeedbackBuilder paramFeedbackBuilder)
  {
    this.canViewerLike = paramFeedbackBuilder.a();
    this.canViewerComment = paramFeedbackBuilder.b();
    this.doesViewerLike = paramFeedbackBuilder.c();
    this.legacyApiPostId = paramFeedbackBuilder.d();
    this.comments = paramFeedbackBuilder.f();
    this.likers = paramFeedbackBuilder.g();
    this.reshares = paramFeedbackBuilder.h();
    this.id = paramFeedbackBuilder.e();
    this.likeSentence = paramFeedbackBuilder.i();
    this.viewerLikersSentence = paramFeedbackBuilder.j();
    this.viewerDoesNotLikeSentence = paramFeedbackBuilder.k();
    this.a = paramFeedbackBuilder.l();
    this.type = paramFeedbackBuilder.m();
  }

  @JsonIgnore
  public int a()
  {
    if (this.likers != null);
    for (int i = this.likers.count; ; i = 0)
      return i;
  }

  @JsonIgnore
  public int b()
  {
    if (this.comments != null);
    for (int i = this.comments.count; ; i = 0)
      return i;
  }

  @JsonIgnore
  public int c()
  {
    if (this.reshares != null);
    for (int i = this.reshares.count; ; i = 0)
      return i;
  }

  @JsonIgnore
  public String d()
  {
    return this.id;
  }

  public int describeContents()
  {
    return 0;
  }

  @JsonProperty("fetchTimeMs")
  public long getFetchTimeMs()
  {
    return this.a;
  }

  @JsonProperty("fetchTimeMs")
  public void setFetchTimeMs(long paramLong)
  {
    this.a = paramLong;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.Feedback
 * JD-Core Version:    0.6.2
 */