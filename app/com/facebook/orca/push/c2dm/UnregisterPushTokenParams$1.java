package com.facebook.orca.push.c2dm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UnregisterPushTokenParams$1
  implements Parcelable.Creator<UnregisterPushTokenParams>
{
  public UnregisterPushTokenParams a(Parcel paramParcel)
  {
    return new UnregisterPushTokenParams(paramParcel, null);
  }

  public UnregisterPushTokenParams[] a(int paramInt)
  {
    return new UnregisterPushTokenParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.UnregisterPushTokenParams.1
 * JD-Core Version:    0.6.0
 */