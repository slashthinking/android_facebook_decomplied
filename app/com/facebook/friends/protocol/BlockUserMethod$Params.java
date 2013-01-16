package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BlockUserMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new BlockUserMethod.Params.1();
  public final long a;
  public final long b;

  public BlockUserMethod$Params(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.a = paramLong2;
  }

  public BlockUserMethod$Params(Parcel paramParcel)
  {
    this.b = paramParcel.readLong();
    this.a = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.BlockUserMethod.Params
 * JD-Core Version:    0.6.0
 */