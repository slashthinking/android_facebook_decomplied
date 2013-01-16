package com.facebook.orca.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserTokenCredentials$1
  implements Parcelable.Creator<UserTokenCredentials>
{
  public UserTokenCredentials a(Parcel paramParcel)
  {
    return new UserTokenCredentials(paramParcel.readString(), paramParcel.readString());
  }

  public UserTokenCredentials[] a(int paramInt)
  {
    return new UserTokenCredentials[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.UserTokenCredentials.1
 * JD-Core Version:    0.6.0
 */