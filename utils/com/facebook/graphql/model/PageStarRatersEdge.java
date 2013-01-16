package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PageStarRatersEdge
  implements Parcelable
{
  public static final Parcelable.Creator<PageStarRatersEdge> CREATOR = new PageStarRatersEdge.1();

  @JsonProperty("node")
  public GraphQLProfile rater;

  @JsonProperty("rating")
  public int rating;

  protected PageStarRatersEdge()
  {
    this.rating = 0;
    this.rater = null;
  }

  private PageStarRatersEdge(Parcel paramParcel)
  {
    this.rating = paramParcel.readInt();
    this.rater = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.rating);
    paramParcel.writeParcelable(this.rater, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PageStarRatersEdge
 * JD-Core Version:    0.6.2
 */