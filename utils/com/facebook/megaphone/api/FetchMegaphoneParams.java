package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchMegaphoneParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMegaphoneParams> CREATOR = new FetchMegaphoneParams.1();
  public final String a;
  public final int b;

  private FetchMegaphoneParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
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
 * Qualified Name:     com.facebook.megaphone.api.FetchMegaphoneParams
 * JD-Core Version:    0.6.2
 */