package com.facebook.orca.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class NotificationSetting$1
  implements Parcelable.Creator<NotificationSetting>
{
  public NotificationSetting a(Parcel paramParcel)
  {
    return new NotificationSetting(paramParcel, null);
  }

  public NotificationSetting[] a(int paramInt)
  {
    return new NotificationSetting[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.NotificationSetting.1
 * JD-Core Version:    0.6.0
 */