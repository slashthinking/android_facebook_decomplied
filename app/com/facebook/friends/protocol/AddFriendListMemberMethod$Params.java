package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;

public class AddFriendListMemberMethod$Params
  implements Parcelable
{
  public final long a;
  public final long b;

  public AddFriendListMemberMethod$Params(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.AddFriendListMemberMethod.Params
 * JD-Core Version:    0.6.0
 */