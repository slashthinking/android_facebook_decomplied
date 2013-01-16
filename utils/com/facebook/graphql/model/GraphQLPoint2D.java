package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLPoint2D
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLPoint2D> CREATOR = new GraphQLPoint2D.1();

  @JsonProperty("x")
  public final double x;

  @JsonProperty("y")
  public final double y;

  protected GraphQLPoint2D()
  {
    this.x = 0.0D;
    this.y = 0.0D;
  }

  private GraphQLPoint2D(Parcel paramParcel)
  {
    this.x = paramParcel.readDouble();
    this.y = paramParcel.readDouble();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.x);
    paramParcel.writeDouble(this.y);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPoint2D
 * JD-Core Version:    0.6.2
 */