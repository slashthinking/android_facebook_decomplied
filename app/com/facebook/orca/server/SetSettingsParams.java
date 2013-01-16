package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.notify.NotificationSetting;

public class SetSettingsParams
  implements Parcelable
{
  public static final Parcelable.Creator<SetSettingsParams> CREATOR = new SetSettingsParams.1();
  private boolean a;
  private NotificationSetting b;

  private SetSettingsParams(Parcel paramParcel)
  {
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.a = bool;
      this.b = ((NotificationSetting)paramParcel.readParcelable(NotificationSetting.class.getClassLoader()));
      return;
    }
  }

  SetSettingsParams(SetSettingsParamsBuilder paramSetSettingsParamsBuilder)
  {
    this.a = paramSetSettingsParamsBuilder.a();
    this.b = paramSetSettingsParamsBuilder.b();
  }

  public boolean a()
  {
    return this.a;
  }

  public NotificationSetting b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.b, paramInt);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.SetSettingsParams
 * JD-Core Version:    0.6.0
 */