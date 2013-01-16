package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchNotificationsResult$1
  implements Parcelable.Creator<FetchNotificationsResult>
{
  public FetchNotificationsResult a(Parcel paramParcel)
  {
    return new FetchNotificationsResult(paramParcel);
  }

  public FetchNotificationsResult[] a(int paramInt)
  {
    return new FetchNotificationsResult[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchNotificationsResult.1
 * JD-Core Version:    0.6.2
 */