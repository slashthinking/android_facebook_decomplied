package com.facebook.orca.push.c2dm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RegisterPushTokenParams
  implements Parcelable
{
  public static final Parcelable.Creator<RegisterPushTokenParams> CREATOR = new RegisterPushTokenParams.1();
  private final PushTokenHolder.ServiceType a;
  private final String b;
  private final String c;
  private final boolean d;

  private RegisterPushTokenParams(Parcel paramParcel)
  {
    this.a = ((PushTokenHolder.ServiceType)paramParcel.readSerializable());
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    if (paramParcel.readInt() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  public RegisterPushTokenParams(PushTokenHolder.ServiceType paramServiceType, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramServiceType;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
  }

  public PushTokenHolder.ServiceType a()
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

  public boolean d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    if (this.d);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.RegisterPushTokenParams
 * JD-Core Version:    0.6.0
 */