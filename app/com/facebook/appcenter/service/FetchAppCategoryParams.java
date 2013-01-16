package com.facebook.appcenter.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchAppCategoryParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAppCategoryParams> CREATOR = new FetchAppCategoryParams.1();

  public FetchAppCategoryParams()
  {
  }

  public FetchAppCategoryParams(Parcel paramParcel)
  {
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.service.FetchAppCategoryParams
 * JD-Core Version:    0.6.0
 */