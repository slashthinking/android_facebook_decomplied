package com.facebook.photos.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class LimitedPhotoFeedbackData
  implements Parcelable
{
  public static final Parcelable.Creator<LimitedPhotoFeedbackData> CREATOR = new LimitedPhotoFeedbackData.1();

  @JsonProperty("can_viewer_comment")
  public final boolean canViewerComment;

  @JsonProperty("can_viewer_like")
  public final boolean canViewerLike;

  @JsonProperty("comments")
  public final LimitedPhotoFeedbackData.CountData commentCount;

  @JsonProperty("does_viewer_like")
  public final boolean doesViewerLike;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("likers")
  public final LimitedPhotoFeedbackData.CountData likeCount;

  private LimitedPhotoFeedbackData()
  {
    this.id = null;
    this.doesViewerLike = false;
    this.canViewerLike = false;
    this.canViewerComment = false;
    this.likeCount = null;
    this.commentCount = null;
  }

  private LimitedPhotoFeedbackData(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.doesViewerLike = ParcelUtil.a(paramParcel);
    this.canViewerLike = ParcelUtil.a(paramParcel);
    this.canViewerComment = ParcelUtil.a(paramParcel);
    this.likeCount = new LimitedPhotoFeedbackData.CountData(paramParcel.readLong(), null);
    this.commentCount = new LimitedPhotoFeedbackData.CountData(paramParcel.readLong(), null);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    ParcelUtil.a(paramParcel, this.doesViewerLike);
    ParcelUtil.a(paramParcel, this.canViewerLike);
    ParcelUtil.a(paramParcel, this.canViewerComment);
    paramParcel.writeLong(this.likeCount.count);
    paramParcel.writeLong(this.commentCount.count);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.LimitedPhotoFeedbackData
 * JD-Core Version:    0.6.0
 */