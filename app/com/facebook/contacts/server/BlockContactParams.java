package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.UserKey;

public class BlockContactParams
  implements Parcelable
{
  public static final Parcelable.Creator<BlockContactParams> CREATOR = new BlockContactParams.1();
  private final UserKey a;

  private BlockContactParams(Parcel paramParcel)
  {
    this.a = UserKey.a(paramParcel.readString());
  }

  public BlockContactParams(UserKey paramUserKey)
  {
    this.a = paramUserKey;
  }

  public UserKey a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.BlockContactParams
 * JD-Core Version:    0.6.0
 */