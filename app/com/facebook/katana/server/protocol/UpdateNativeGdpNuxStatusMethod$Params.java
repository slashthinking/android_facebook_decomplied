package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UpdateNativeGdpNuxStatusMethod$Params
  implements Parcelable
{
  public static Parcelable.Creator<Params> CREATOR = new UpdateNativeGdpNuxStatusMethod.Params.1();
  private final String a;

  private UpdateNativeGdpNuxStatusMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public UpdateNativeGdpNuxStatusMethod$Params(String paramString)
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
 * Qualified Name:     com.facebook.katana.server.protocol.UpdateNativeGdpNuxStatusMethod.Params
 * JD-Core Version:    0.6.0
 */