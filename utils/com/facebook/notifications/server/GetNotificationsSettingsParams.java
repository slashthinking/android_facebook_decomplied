package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;

public class GetNotificationsSettingsParams
  implements Parcelable
{
  public static final Parcelable.Creator<GetNotificationsSettingsParams> CREATOR = new GetNotificationsSettingsParams.1();
  private final String a;
  private final String b;
  private final DataFreshnessParam c;

  public GetNotificationsSettingsParams(Parcel paramParcel)
  {
    this.c = DataFreshnessParam.valueOf(paramParcel.readString());
    this.b = paramParcel.readString();
    this.a = "me()";
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c.toString());
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.server.GetNotificationsSettingsParams
 * JD-Core Version:    0.6.2
 */