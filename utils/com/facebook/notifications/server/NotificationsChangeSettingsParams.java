package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NotificationsChangeSettingsParams
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationsChangeSettingsParams> CREATOR = new NotificationsChangeSettingsParams.1();
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;

  public NotificationsChangeSettingsParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }

  public NotificationsChangeSettingsParams(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = null;
    this.d = null;
    this.e = null;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.server.NotificationsChangeSettingsParams
 * JD-Core Version:    0.6.2
 */