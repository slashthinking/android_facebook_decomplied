package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CancelFriendRequestMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new CancelFriendRequestMethod.Params.1();
  public final long a;

  public CancelFriendRequestMethod$Params(long paramLong)
  {
    this.a = paramLong;
  }

  public CancelFriendRequestMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
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
 * Qualified Name:     com.facebook.friends.protocol.CancelFriendRequestMethod.Params
 * JD-Core Version:    0.6.0
 */