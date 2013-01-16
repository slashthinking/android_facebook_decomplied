package com.facebook.zero.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchZeroTokenResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchZeroTokenResult> CREATOR = new FetchZeroTokenResult.1();
  private String a;

  public FetchZeroTokenResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public FetchZeroTokenResult(String paramString)
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

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.protocol.methods.FetchZeroTokenResult
 * JD-Core Version:    0.6.2
 */