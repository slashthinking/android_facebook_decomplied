package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NearbyPlaceEdge
  implements Parcelable
{
  public static final Parcelable.Creator<NearbyPlaceEdge> CREATOR = new NearbyPlaceEdge.1();

  @JsonProperty("node")
  public final GraphQLPlace place;

  @JsonProperty("social_context")
  public final GraphQLTextWithEntities socialContext;

  public NearbyPlaceEdge()
  {
    this.place = null;
    this.socialContext = null;
  }

  public NearbyPlaceEdge(Parcel paramParcel)
  {
    this.place = ((GraphQLPlace)paramParcel.readParcelable(GraphQLPlace.class.getClassLoader()));
    this.socialContext = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return this.place.name;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.place, paramInt);
    paramParcel.writeParcelable(this.socialContext, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.model.NearbyPlaceEdge
 * JD-Core Version:    0.6.0
 */