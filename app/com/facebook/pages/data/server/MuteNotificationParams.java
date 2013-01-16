package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MuteNotificationParams
  implements Parcelable
{
  public static final Parcelable.Creator<MuteNotificationParams> CREATOR = new MuteNotificationParams.1();
  private final long a;

  public MuteNotificationParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.MuteNotificationParams
 * JD-Core Version:    0.6.0
 */