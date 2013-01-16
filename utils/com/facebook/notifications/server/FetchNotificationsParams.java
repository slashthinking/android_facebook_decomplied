package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;

public class FetchNotificationsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNotificationsParams> CREATOR = new FetchNotificationsParams.1();
  private DataFreshnessParam a;
  private long b;

  public FetchNotificationsParams(Parcel paramParcel)
  {
    this.a = DataFreshnessParam.valueOf(paramParcel.readString());
    this.b = paramParcel.readLong();
  }

  public DataFreshnessParam a()
  {
    return this.a;
  }

  public String b()
  {
    if (this.b == -1L);
    for (String str = "me()"; ; str = String.valueOf(this.b))
      return str;
  }

  public long c()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeLong(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.server.FetchNotificationsParams
 * JD-Core Version:    0.6.2
 */