package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import com.facebook.pages.data.model.PageInfo;
import com.facebook.pages.data.model.PageNotificationCounts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FetchAllPagesResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAllPagesResult> CREATOR = new FetchAllPagesResult.1();
  private final ArrayList<PageInfo> a;
  private final Map<Long, PageNotificationCounts> b;

  private FetchAllPagesResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readArrayList(PageInfo.class.getClassLoader());
    this.b = new HashMap();
    paramParcel.readMap(this.b, Map.class.getClassLoader());
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

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.FetchAllPagesResult
 * JD-Core Version:    0.6.0
 */