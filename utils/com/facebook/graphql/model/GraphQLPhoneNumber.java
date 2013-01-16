package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLPhoneNumber
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLPhoneNumber> CREATOR = new GraphQLPhoneNumber.1();

  @JsonProperty("display_number")
  public final String displayNumber;

  @JsonProperty("universal_number")
  public final String universalNumber;

  public GraphQLPhoneNumber()
  {
    this.displayNumber = null;
    this.universalNumber = null;
  }

  private GraphQLPhoneNumber(Parcel paramParcel)
  {
    this.displayNumber = paramParcel.readString();
    this.universalNumber = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.displayNumber);
    paramParcel.writeString(this.universalNumber);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPhoneNumber
 * JD-Core Version:    0.6.2
 */