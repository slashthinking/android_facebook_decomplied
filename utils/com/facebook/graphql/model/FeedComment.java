package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import java.util.Comparator;

public class FeedComment extends FeedbackableGraphQLNode
  implements Parcelable, Dedupable, OptimisticEntity, Comparable<FeedComment>
{
  public static final Parcelable.Creator<FeedComment> CREATOR = new FeedComment.1();

  @JsonProperty("author")
  public final GraphQLProfile author;

  @JsonProperty("body")
  public final GraphQLTextWithEntities body;

  @JsonProperty("created_time")
  public final long createdTime;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("publish_state")
  private FeedOptimisticPublishState publishState;

  public FeedComment()
  {
    this.id = null;
    this.author = null;
    this.body = null;
    this.createdTime = 0L;
    this.publishState = FeedOptimisticPublishState.NONE;
  }

  public FeedComment(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.author = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.body = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.createdTime = paramParcel.readLong();
    this.publishState = FeedOptimisticPublishState.values()[paramParcel.readInt()];
  }

  public FeedComment(FeedCommentBuilder paramFeedCommentBuilder)
  {
    super(paramFeedCommentBuilder.e());
    this.id = paramFeedCommentBuilder.a();
    this.author = paramFeedCommentBuilder.b();
    this.body = paramFeedCommentBuilder.c();
    this.createdTime = paramFeedCommentBuilder.d();
    this.publishState = paramFeedCommentBuilder.f();
  }

  public int a(FeedComment paramFeedComment)
  {
    return FeedStoryComments.b.compare(this, paramFeedComment);
  }

  public String a()
  {
    Feedback localFeedback = S();
    if ((localFeedback != null) && (localFeedback.legacyApiPostId != null));
    for (String str = localFeedback.legacyApiPostId; ; str = this.id)
      return str;
  }

  @JsonIgnore
  public void a(FeedOptimisticPublishState paramFeedOptimisticPublishState)
  {
    this.publishState = paramFeedOptimisticPublishState;
  }

  public boolean b()
  {
    Feedback localFeedback = S();
    boolean bool1 = false;
    if (localFeedback != null)
    {
      boolean bool2 = S().canViewerLike;
      bool1 = false;
      if (bool2)
        break label27;
    }
    while (true)
    {
      return bool1;
      label27: String str = S().legacyApiPostId;
      bool1 = false;
      if (str != null)
        bool1 = true;
    }
  }

  @JsonIgnore
  public FeedOptimisticPublishState c()
  {
    return this.publishState;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    FeedComment localFeedComment;
    if ((paramObject instanceof FeedComment))
    {
      localFeedComment = (FeedComment)paramObject;
      if ((S() == null) || (localFeedComment.S() == null));
    }
    for (boolean bool = Objects.equal(S().legacyApiPostId, localFeedComment.S().legacyApiPostId); ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    Feedback localFeedback = S();
    int i = 0;
    if (localFeedback != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = S().legacyApiPostId;
      i = Objects.hashCode(arrayOfObject);
    }
    return i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.author, paramInt);
    paramParcel.writeParcelable(this.body, paramInt);
    paramParcel.writeLong(this.createdTime);
    paramParcel.writeInt(this.publishState.ordinal());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedComment
 * JD-Core Version:    0.6.2
 */