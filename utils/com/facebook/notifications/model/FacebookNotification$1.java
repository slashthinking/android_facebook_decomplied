package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FacebookNotification$1
  implements Parcelable.Creator<FacebookNotification>
{
  public FacebookNotification a(Parcel paramParcel)
  {
    return new FacebookNotification(paramParcel);
  }

  public FacebookNotification[] a(int paramInt)
  {
    return new FacebookNotification[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.model.FacebookNotification.1
 * JD-Core Version:    0.6.2
 */