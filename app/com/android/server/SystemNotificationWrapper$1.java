package com.android.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SystemNotificationWrapper$1
  implements Parcelable.Creator<SystemNotificationWrapper>
{
  public SystemNotificationWrapper a(Parcel paramParcel)
  {
    return new SystemNotificationWrapper(paramParcel, null);
  }

  public SystemNotificationWrapper[] a(int paramInt)
  {
    return new SystemNotificationWrapper[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.android.server.SystemNotificationWrapper.1
 * JD-Core Version:    0.6.0
 */