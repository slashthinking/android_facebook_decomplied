package com.facebook.appcenter.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.graphql.model.AppList;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import java.util.List;

public class FetchAppListResult extends BaseResult
  implements Parcelable
{
  private final AppList a;

  public FetchAppListResult(AppList paramAppList, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramAppList;
  }

  public AppList a()
  {
    return this.a;
  }

  public List<AppDetail> b()
  {
    if (this.a == null);
    for (List localList = null; ; localList = this.a.a())
      return localList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.FetchAppListResult
 * JD-Core Version:    0.6.0
 */