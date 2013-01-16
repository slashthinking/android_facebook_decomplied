package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ConfirmPhoneParams
  implements Parcelable
{
  public static final Parcelable.Creator<ConfirmPhoneParams> CREATOR = new ConfirmPhoneParams.1();
  private final String a;
  private final boolean b;

  private ConfirmPhoneParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return;
    }
  }

  public String a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ConfirmPhoneParams
 * JD-Core Version:    0.6.0
 */