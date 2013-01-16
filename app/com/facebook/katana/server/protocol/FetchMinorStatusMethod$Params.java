package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchMinorStatusMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new FetchMinorStatusMethod.Params.1();
  public final long a;

  public FetchMinorStatusMethod$Params(long paramLong)
  {
    this.a = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.FetchMinorStatusMethod.Params
 * JD-Core Version:    0.6.0
 */