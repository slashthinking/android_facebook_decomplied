package com.facebook.appcenter.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchAppDetailResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAppDetailResult> CREATOR;
  public static final FetchAppDetailResult a = new FetchAppDetailResult(null, DataFreshnessResult.NO_DATA, -1L);

  @JsonProperty
  private final AppDetail mAppDetail;

  static
  {
    CREATOR = new FetchAppDetailResult.1();
  }

  public FetchAppDetailResult()
  {
    super(null, 0L);
    this.mAppDetail = null;
  }

  public FetchAppDetailResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppDetail = ((AppDetail)paramParcel.readParcelable(AppDetail.class.getClassLoader()));
  }

  public FetchAppDetailResult(AppDetail paramAppDetail, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.mAppDetail = paramAppDetail;
  }

  public AppDetail a()
  {
    return this.mAppDetail;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppDetail, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.FetchAppDetailResult
 * JD-Core Version:    0.6.0
 */