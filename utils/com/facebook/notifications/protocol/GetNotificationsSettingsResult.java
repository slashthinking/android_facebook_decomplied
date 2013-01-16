package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.notifications.model.FacebookNotificationSetting;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.collect.ImmutableList;

public class GetNotificationsSettingsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetNotificationsSettingsResult> CREATOR = new GetNotificationsSettingsResult.1();
  public final ImmutableList<FacebookNotificationSetting> a;

  protected GetNotificationsSettingsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(null));
  }

  public GetNotificationsSettingsResult(DataFreshnessResult paramDataFreshnessResult, ImmutableList<FacebookNotificationSetting> paramImmutableList, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramImmutableList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.GetNotificationsSettingsResult
 * JD-Core Version:    0.6.2
 */