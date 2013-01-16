package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FriendList$1
  implements Parcelable.Creator<FriendList>
{
  public FriendList a(Parcel paramParcel)
  {
    return new FriendList(paramParcel);
  }

  public FriendList[] a(int paramInt)
  {
    return new FriendList[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FriendList.1
 * JD-Core Version:    0.6.2
 */