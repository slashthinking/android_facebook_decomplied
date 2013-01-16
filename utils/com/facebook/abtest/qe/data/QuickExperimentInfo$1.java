package com.facebook.abtest.qe.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QuickExperimentInfo$1
  implements Parcelable.Creator<QuickExperimentInfo>
{
  public QuickExperimentInfo a(Parcel paramParcel)
  {
    return new QuickExperimentInfo(paramParcel, null);
  }

  public QuickExperimentInfo[] a(int paramInt)
  {
    return new QuickExperimentInfo[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.data.QuickExperimentInfo.1
 * JD-Core Version:    0.6.2
 */