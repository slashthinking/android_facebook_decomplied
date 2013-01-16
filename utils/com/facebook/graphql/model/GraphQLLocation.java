package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.Log;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.TimeZone;

public class GraphQLLocation
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLLocation> CREATOR = new GraphQLLocation.1();

  @JsonProperty("latitude")
  public final double latitude;

  @JsonProperty("longitude")
  public final double longitude;

  @JsonProperty("timezone")
  public final String timezone;

  protected GraphQLLocation()
  {
    this.latitude = 0.0D;
    this.longitude = 0.0D;
    this.timezone = null;
  }

  public GraphQLLocation(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.timezone = null;
  }

  public GraphQLLocation(Parcel paramParcel)
  {
    this.latitude = paramParcel.readDouble();
    this.longitude = paramParcel.readDouble();
    this.timezone = paramParcel.readString();
  }

  @JsonIgnore
  public TimeZone a()
  {
    String str = this.timezone;
    Object localObject = null;
    if (str == null);
    while (true)
    {
      return localObject;
      TimeZone localTimeZone = TimeZone.getTimeZone(this.timezone);
      if (localTimeZone.getID().equals(this.timezone))
      {
        localObject = localTimeZone;
      }
      else
      {
        Log.a("Invalid timezone: <" + this.timezone + ">");
        localObject = null;
      }
    }
  }

  @JsonIgnore
  public boolean b()
  {
    if ((Math.abs(this.latitude) <= 90.0D) && (Math.abs(this.longitude) <= 180.0D));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeString(this.timezone);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLLocation
 * JD-Core Version:    0.6.2
 */