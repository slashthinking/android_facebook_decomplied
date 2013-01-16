package com.facebook.friends.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FriendRequest$1
  implements Parcelable.Creator<FriendRequest>
{
  public FriendRequest a(Parcel paramParcel)
  {
    return new FriendRequest(paramParcel);
  }

  public FriendRequest[] a(int paramInt)
  {
    return new FriendRequest[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.model.FriendRequest.1
 * JD-Core Version:    0.6.0
 */