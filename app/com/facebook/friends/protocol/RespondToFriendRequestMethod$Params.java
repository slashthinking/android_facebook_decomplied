package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestResponseRef;

public class RespondToFriendRequestMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new RespondToFriendRequestMethod.Params.1();
  public final FriendRequestResponse a;
  public final FriendRequestResponseRef b;
  public final long c;

  public RespondToFriendRequestMethod$Params(Parcel paramParcel)
  {
    this.a = FriendRequestResponse.valueOf(paramParcel.readString());
    this.b = FriendRequestResponseRef.valueOf(paramParcel.readString());
    this.c = paramParcel.readLong();
  }

  public RespondToFriendRequestMethod$Params(FriendRequestResponse paramFriendRequestResponse, long paramLong, FriendRequestResponseRef paramFriendRequestResponseRef)
  {
    this.a = paramFriendRequestResponse;
    this.b = paramFriendRequestResponseRef;
    this.c = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.name());
    paramParcel.writeString(this.b.name());
    paramParcel.writeLong(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.RespondToFriendRequestMethod.Params
 * JD-Core Version:    0.6.0
 */