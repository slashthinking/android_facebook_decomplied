package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLAddress
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<GraphQLAddress> CREATOR = new GraphQLAddress.1();

  @JsonProperty("city")
  public final String city;

  @JsonProperty("country")
  public final String country;

  @JsonProperty("full_address")
  public final String fullAddress;

  @JsonProperty("postal_code")
  public final String postalCode;

  @JsonProperty("street")
  public final String street;

  protected GraphQLAddress()
  {
    this.street = null;
    this.city = null;
    this.country = null;
    this.postalCode = null;
    this.fullAddress = null;
  }

  private GraphQLAddress(Parcel paramParcel)
  {
    this.street = paramParcel.readString();
    this.city = paramParcel.readString();
    this.country = paramParcel.readString();
    this.postalCode = paramParcel.readString();
    this.fullAddress = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.street);
    paramParcel.writeString(this.city);
    paramParcel.writeString(this.country);
    paramParcel.writeString(this.postalCode);
    paramParcel.writeString(this.fullAddress);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLAddress
 * JD-Core Version:    0.6.2
 */