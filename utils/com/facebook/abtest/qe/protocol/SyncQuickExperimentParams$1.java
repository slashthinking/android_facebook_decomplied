package com.facebook.abtest.qe.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SyncQuickExperimentParams$1
  implements Parcelable.Creator<SyncQuickExperimentParams>
{
  public SyncQuickExperimentParams a(Parcel paramParcel)
  {
    return new SyncQuickExperimentParams(paramParcel);
  }

  public SyncQuickExperimentParams[] a(int paramInt)
  {
    return new SyncQuickExperimentParams[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.SyncQuickExperimentParams.1
 * JD-Core Version:    0.6.2
 */