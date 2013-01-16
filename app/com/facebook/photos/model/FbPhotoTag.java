package com.facebook.photos.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLPoint2D;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class FbPhotoTag
  implements Parcelable
{
  public static final Parcelable.Creator<FbPhotoTag> CREATOR = new FbPhotoTag.1();

  @JsonProperty("node")
  private final FbPhotoTag.TagEdgeNode node;

  @JsonProperty("tag")
  private final FbPhotoTag.TagEdgeData tagData;

  private FbPhotoTag()
  {
    this.node = null;
    this.tagData = null;
  }

  private FbPhotoTag(Parcel paramParcel)
  {
    this.tagData = new FbPhotoTag.TagEdgeData(null);
    this.tagData.location = ((GraphQLPoint2D)paramParcel.readParcelable(GraphQLPoint2D.class.getClassLoader()));
    this.node = new FbPhotoTag.TagEdgeNode(null);
    this.node.fbid = paramParcel.readString();
    this.node.name = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.tagData.location, 0);
    paramParcel.writeString(this.node.fbid);
    paramParcel.writeString(this.node.name);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.FbPhotoTag
 * JD-Core Version:    0.6.0
 */