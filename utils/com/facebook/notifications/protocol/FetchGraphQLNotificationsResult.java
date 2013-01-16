package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class FetchGraphQLNotificationsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchGraphQLNotificationsResult> CREATOR = new FetchGraphQLNotificationsResult.1();
  public final NotificationStories a;
  public final long b;

  public FetchGraphQLNotificationsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = paramParcel.readLong();
    this.a = ((NotificationStories)paramParcel.readParcelable(NotificationStories.class.getClassLoader()));
  }

  public FetchGraphQLNotificationsResult(NotificationStories paramNotificationStories, long paramLong1, DataFreshnessResult paramDataFreshnessResult, long paramLong2)
  {
    super(paramDataFreshnessResult, paramLong2);
    this.a = paramNotificationStories;
    this.b = paramLong1;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.b);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchGraphQLNotificationsResult
 * JD-Core Version:    0.6.2
 */