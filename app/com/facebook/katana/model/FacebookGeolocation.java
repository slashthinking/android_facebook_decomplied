package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookGeolocation
  implements Parcelable, JMStaticKeysDictDestination
{
  public static Parcelable.Creator<FacebookGeolocation> CREATOR;
  private static final Class<?> TAG = FacebookGeolocation.class;

  @JMAutogen.InferredType(jsonFieldName="address")
  public final String address;

  @JMAutogen.InferredType(jsonFieldName="city")
  public final String city;

  @JMAutogen.InferredType(jsonFieldName="country")
  public final String country;

  @JMAutogen.InferredType(jsonFieldName="distance")
  public final double distance;

  @JMAutogen.InferredType(jsonFieldName="house_number")
  public final String houseNumber;

  @JMAutogen.InferredType(jsonFieldName="latitude")
  public final double latitude;

  @JMAutogen.InferredType(jsonFieldName="longitude")
  public final double longitude;

  @JMAutogen.InferredType(jsonFieldName="postal_code")
  public final String postalCode;

  @JMAutogen.InferredType(jsonFieldName="region")
  public final String region;

  @JMAutogen.InferredType(jsonFieldName="street_name")
  public final String streetName;

  static
  {
    CREATOR = new FacebookGeolocation.1();
  }

  private FacebookGeolocation()
  {
    this.latitude = 0.0D;
    this.longitude = 0.0D;
    this.region = null;
    this.address = null;
    this.city = null;
    this.country = null;
    this.distance = 0.0D;
    this.postalCode = null;
    this.streetName = null;
    this.houseNumber = null;
  }

  private FacebookGeolocation(Parcel paramParcel)
  {
    this.latitude = paramParcel.readDouble();
    this.longitude = paramParcel.readDouble();
    this.region = paramParcel.readString();
    this.address = paramParcel.readString();
    this.city = paramParcel.readString();
    this.country = paramParcel.readString();
    this.distance = paramParcel.readDouble();
    this.postalCode = paramParcel.readString();
    this.streetName = paramParcel.readString();
    this.houseNumber = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeString(this.region);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.city);
    paramParcel.writeString(this.country);
    paramParcel.writeDouble(this.distance);
    paramParcel.writeString(this.postalCode);
    paramParcel.writeString(this.streetName);
    paramParcel.writeString(this.houseNumber);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookGeolocation
 * JD-Core Version:    0.6.0
 */