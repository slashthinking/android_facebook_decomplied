package com.facebook.appcenter.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchAppDetailParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAppDetailParams> CREATOR = new FetchAppDetailParams.1();
  private final String a;

  public FetchAppDetailParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public FetchAppDetailParams(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.service.FetchAppDetailParams
 * JD-Core Version:    0.6.0
 */