package com.facebook.pages.identity.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RatePageParams
  implements Parcelable
{
  public static final Parcelable.Creator<RatePageParams> CREATOR = new RatePageParams.1();
  private final String a;
  private final int b;

  public RatePageParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }

  public RatePageParams(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.RatePageParams
 * JD-Core Version:    0.6.2
 */