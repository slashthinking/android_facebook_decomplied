package com.facebook.pages.identity.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchPageIdentityDataMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new FetchPageIdentityDataMethod.Params.1();
  public final long a;
  public final int b;

  public FetchPageIdentityDataMethod$Params(long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.b = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod.Params
 * JD-Core Version:    0.6.2
 */