package com.facebook.orca.appconfig;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppConfig> CREATOR = new AppConfig.1();
  private final String a;
  private final String b;
  private final String c;
  private final int d;
  private final int e;

  private AppConfig(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }

  AppConfig(AppConfigBuilder paramAppConfigBuilder)
  {
    this.a = paramAppConfigBuilder.a();
    this.b = paramAppConfigBuilder.b();
    this.c = paramAppConfigBuilder.c();
    this.d = paramAppConfigBuilder.d();
    this.e = paramAppConfigBuilder.e();
  }

  public static AppConfigBuilder newBuilder()
  {
    return new AppConfigBuilder();
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

  public int d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.appconfig.AppConfig
 * JD-Core Version:    0.6.0
 */