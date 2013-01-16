package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.notifications.model.FacebookNotification;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class FetchNotificationsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNotificationsResult> CREATOR = new FetchNotificationsResult.1();
  public final ImmutableList<FacebookNotification> a;
  public final ImmutableMap<Long, FacebookProfile> b;

  protected FetchNotificationsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(null));
    this.b = ImmutableMap.a(paramParcel.readHashMap(null));
  }

  public FetchNotificationsResult(DataFreshnessResult paramDataFreshnessResult, ImmutableList<FacebookNotification> paramImmutableList, ImmutableMap<Long, FacebookProfile> paramImmutableMap, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramImmutableList;
    this.b = paramImmutableMap;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
    paramParcel.writeMap(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchNotificationsResult
 * JD-Core Version:    0.6.2
 */