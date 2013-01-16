package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import com.facebook.pages.data.model.PageNotificationCounts;
import java.util.HashMap;
import java.util.Map;

public class FetchNotificationCountsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNotificationCountsResult> CREATOR = new FetchNotificationCountsResult.1();
  private final Map<Long, PageNotificationCounts> a = new HashMap();

  protected FetchNotificationCountsResult(Parcel paramParcel)
  {
    super(paramParcel);
    paramParcel.readMap(this.a, PageNotificationCounts.class.getClassLoader());
  }

  public Map<Long, PageNotificationCounts> a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.FetchNotificationCountsResult
 * JD-Core Version:    0.6.0
 */