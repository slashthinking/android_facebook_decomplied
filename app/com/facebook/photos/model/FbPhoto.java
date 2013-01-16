package com.facebook.photos.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.ParcelUtil;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FbPhoto
  implements Parcelable
{
  public static final Parcelable.Creator<FbPhoto> CREATOR = new FbPhoto.1();

  @JsonProperty("album")
  private final FbPhoto.AlbumFbid album;

  @JsonProperty("can_viewer_add_tags")
  public final boolean canViewerAddTags;

  @JsonProperty("message")
  public final GraphQLTextWithEntities caption;

  @JsonProperty("id")
  private final String fbid;

  @JsonProperty("feedback")
  public final LimitedPhotoFeedbackData feedback;

  @JsonProperty("image")
  public final GraphQLImage image;

  @JsonProperty("modified_time")
  public final long modifiedTime;

  @JsonProperty("tags")
  private final FbPhoto.TagsEdges tags;

  private FbPhoto()
  {
    this.fbid = null;
    this.caption = null;
    this.image = null;
    this.album = null;
    this.modifiedTime = -1L;
    this.feedback = null;
    this.canViewerAddTags = false;
    this.tags = null;
  }

  private FbPhoto(Parcel paramParcel)
  {
    this.fbid = paramParcel.readString();
    this.caption = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.image = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
    this.album = new FbPhoto.AlbumFbid(paramParcel.readString(), null);
    this.modifiedTime = paramParcel.readLong();
    this.feedback = ((LimitedPhotoFeedbackData)paramParcel.readParcelable(LimitedPhotoFeedbackData.class.getClassLoader()));
    this.canViewerAddTags = ParcelUtil.a(paramParcel);
    this.tags = ((FbPhoto.TagsEdges)paramParcel.readParcelable(FbPhoto.TagsEdges.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.fbid);
    paramParcel.writeParcelable(this.caption, 0);
    paramParcel.writeParcelable(this.image, 0);
    paramParcel.writeString(this.album.fbid);
    paramParcel.writeLong(this.modifiedTime);
    paramParcel.writeParcelable(this.feedback, 0);
    ParcelUtil.a(paramParcel, this.canViewerAddTags);
    paramParcel.writeParcelable(this.tags, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.FbPhoto
 * JD-Core Version:    0.6.0
 */