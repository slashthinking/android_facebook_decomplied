package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.EnumSet;

public class FetchLastActiveParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchLastActiveParams> CREATOR = new FetchLastActiveParams.1();
  private final EnumSet<FetchLastActiveParams.FriendGroup> a;
  private final int b;

  private FetchLastActiveParams(Parcel paramParcel)
  {
    this.a = ((EnumSet)paramParcel.readSerializable());
    this.b = paramParcel.readInt();
  }

  public FetchLastActiveParams(EnumSet<FetchLastActiveParams.FriendGroup> paramEnumSet, int paramInt)
  {
    this.a = paramEnumSet;
    this.b = paramInt;
  }

  public static FetchLastActiveParams a()
  {
    return new FetchLastActiveParams(EnumSet.of(FetchLastActiveParams.FriendGroup.ALL), 0);
  }

  public static FetchLastActiveParams a(int paramInt)
  {
    return new FetchLastActiveParams(EnumSet.of(FetchLastActiveParams.FriendGroup.TOP_FRIENDS, FetchLastActiveParams.FriendGroup.FAVORITE_FRIENDS), paramInt);
  }

  public EnumSet<FetchLastActiveParams.FriendGroup> b()
  {
    return this.a;
  }

  public int c()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.a);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchLastActiveParams
 * JD-Core Version:    0.6.0
 */