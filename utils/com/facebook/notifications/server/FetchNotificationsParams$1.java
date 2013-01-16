package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchNotificationsParams$1
  implements Parcelable.Creator<FetchNotificationsParams>
{
  public FetchNotificationsParams a(Parcel paramParcel)
  {
    return new FetchNotificationsParams(paramParcel);
  }

  public FetchNotificationsParams[] a(int paramInt)
  {
    return new FetchNotificationsParams[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.server.FetchNotificationsParams.1
 * JD-Core Version:    0.6.2
 */