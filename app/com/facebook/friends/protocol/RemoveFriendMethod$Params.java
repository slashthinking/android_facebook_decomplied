package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;

public class RemoveFriendMethod$Params
  implements Parcelable
{
  public final long a;

  public RemoveFriendMethod$Params(long paramLong)
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
 * Qualified Name:     com.facebook.friends.protocol.RemoveFriendMethod.Params
 * JD-Core Version:    0.6.0
 */