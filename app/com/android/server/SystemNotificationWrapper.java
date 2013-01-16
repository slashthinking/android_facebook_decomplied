package com.android.server;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SystemNotificationWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<SystemNotificationWrapper> CREATOR;
  public static int a = 1;
  public int b = -1;
  public String c = "";
  public String d = "";
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public Notification h = null;

  static
  {
    CREATOR = new SystemNotificationWrapper.1();
  }

  SystemNotificationWrapper()
  {
  }

  private SystemNotificationWrapper(Parcel paramParcel)
  {
    a = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.b = paramParcel.readInt();
    if (paramParcel.readInt() != 0);
    for (this.d = paramParcel.readString(); ; this.d = null)
    {
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = new Notification(paramParcel);
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.b);
    if (this.d != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.d);
    }
    while (true)
    {
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      this.h.writeToParcel(paramParcel, paramInt);
      return;
      paramParcel.writeInt(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.android.server.SystemNotificationWrapper
 * JD-Core Version:    0.6.0
 */