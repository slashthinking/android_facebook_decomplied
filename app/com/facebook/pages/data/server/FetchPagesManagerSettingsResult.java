package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import java.util.HashMap;
import java.util.Map;

public class FetchPagesManagerSettingsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchPagesManagerSettingsResult> CREATOR = new FetchPagesManagerSettingsResult.1();
  private final Map<String, String> a = new HashMap();

  protected FetchPagesManagerSettingsResult(Parcel paramParcel)
  {
    super(paramParcel);
    paramParcel.readMap(this.a, Map.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.FetchPagesManagerSettingsResult
 * JD-Core Version:    0.6.0
 */