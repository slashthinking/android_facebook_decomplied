package com.facebook.orca.notify;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NotificationSetting
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationSetting> CREATOR;
  public static NotificationSetting a = new NotificationSetting(true, 0L, false);
  public static NotificationSetting b = new NotificationSetting(false, 0L, false);
  private final boolean c;
  private final long d;
  private final boolean e;

  static
  {
    CREATOR = new NotificationSetting.1();
  }

  private NotificationSetting(Parcel paramParcel)
  {
    boolean bool2;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.c = bool2;
      this.d = paramParcel.readLong();
      if (paramParcel.readInt() == 0)
        break label46;
    }
    while (true)
    {
      this.e = bool1;
      return;
      bool2 = false;
      break;
      label46: bool1 = false;
    }
  }

  private NotificationSetting(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.d = paramLong;
    this.e = paramBoolean2;
  }

  public static NotificationSetting a(long paramLong)
  {
    return new NotificationSetting(true, paramLong, false);
  }

  public static NotificationSetting b(long paramLong)
  {
    NotificationSetting localNotificationSetting;
    if (paramLong == -1L)
      localNotificationSetting = b;
    while (true)
    {
      return localNotificationSetting;
      if (paramLong == 0L)
      {
        localNotificationSetting = a;
        continue;
      }
      if (paramLong < 0L)
      {
        localNotificationSetting = new NotificationSetting(true, -paramLong, true);
        continue;
      }
      localNotificationSetting = new NotificationSetting(true, paramLong, false);
    }
  }

  public boolean a()
  {
    return this.c;
  }

  public long b()
  {
    return this.d;
  }

  public boolean c()
  {
    return this.e;
  }

  public long d()
  {
    long l;
    if (this.c)
      l = this.d;
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    int j;
    if (this.c)
    {
      j = i;
      paramParcel.writeInt(j);
      paramParcel.writeLong(this.d);
      if (!this.e)
        break label45;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label45: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.NotificationSetting
 * JD-Core Version:    0.6.0
 */