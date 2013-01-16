package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class FetchParcelableResult extends BaseResult
  implements Parcelable
{
  public final Parcelable a;
  private String b;

  public FetchParcelableResult(Parcelable paramParcelable, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramParcelable;
    this.b = null;
  }

  public String a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
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
 * Qualified Name:     com.facebook.feed.protocol.FetchParcelableResult
 * JD-Core Version:    0.6.0
 */