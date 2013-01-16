package com.facebook.abtest.qe.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SyncQuickExperimentResult$1
  implements Parcelable.Creator<SyncQuickExperimentResult>
{
  public SyncQuickExperimentResult a(Parcel paramParcel)
  {
    return new SyncQuickExperimentResult(paramParcel);
  }

  public SyncQuickExperimentResult[] a(int paramInt)
  {
    return new SyncQuickExperimentResult[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.SyncQuickExperimentResult.1
 * JD-Core Version:    0.6.2
 */