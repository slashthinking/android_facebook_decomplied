package com.facebook.orca.push.c2dm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UnregisterPushTokenParams
  implements Parcelable
{
  public static final Parcelable.Creator<UnregisterPushTokenParams> CREATOR = new UnregisterPushTokenParams.1();
  private final String a;

  private UnregisterPushTokenParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public UnregisterPushTokenParams(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.UnregisterPushTokenParams
 * JD-Core Version:    0.6.0
 */