package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchPageInsightsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchPageInsightsResult> CREATOR = new FetchPageInsightsResult.1();
  private final Map<String, List<Long>> a = new HashMap();

  protected FetchPageInsightsResult(Parcel paramParcel)
  {
    super(paramParcel);
    paramParcel.readMap(this.a, Map.class.getClassLoader());
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
 * Qualified Name:     com.facebook.pages.data.server.FetchPageInsightsResult
 * JD-Core Version:    0.6.0
 */