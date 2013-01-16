package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchFriendListsWithMemberParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchFriendListsWithMemberParams> CREATOR = new FetchFriendListsWithMemberParams.1();
  private final long a;

  public FetchFriendListsWithMemberParams(long paramLong)
  {
    this.a = paramLong;
  }

  private FetchFriendListsWithMemberParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
  }

  public long a()
  {
    return this.a;
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
 * Qualified Name:     com.facebook.friends.protocol.FetchFriendListsWithMemberParams
 * JD-Core Version:    0.6.0
 */