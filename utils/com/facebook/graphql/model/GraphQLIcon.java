package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLIcon
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLIcon> CREATOR = new GraphQLIcon.1();

  @JsonProperty("height")
  public final int height;

  @JsonProperty("uri")
  public final String uri;

  @JsonProperty("width")
  public final int width;

  protected GraphQLIcon()
  {
    this.uri = null;
    this.width = 0;
    this.height = 0;
  }

  public GraphQLIcon(Parcel paramParcel)
  {
    this.uri = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uri);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLIcon
 * JD-Core Version:    0.6.2
 */