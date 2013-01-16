package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FacebookUser$1
  implements Parcelable.Creator<FacebookUser>
{
  public FacebookUser a(Parcel paramParcel)
  {
    return new FacebookUser(paramParcel);
  }

  public FacebookUser[] a(int paramInt)
  {
    return new FacebookUser[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookUser.1
 * JD-Core Version:    0.6.0
 */