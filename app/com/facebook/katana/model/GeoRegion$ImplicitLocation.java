package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeoRegion$ImplicitLocation
  implements Parcelable
{
  public static final Parcelable.Creator<ImplicitLocation> CREATOR = new GeoRegion.ImplicitLocation.1();
  public String a;
  public Long b;

  public GeoRegion$ImplicitLocation(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = Long.valueOf(paramParcel.readLong());
  }

  public GeoRegion$ImplicitLocation(String paramString, Long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b.longValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.GeoRegion.ImplicitLocation
 * JD-Core Version:    0.6.0
 */