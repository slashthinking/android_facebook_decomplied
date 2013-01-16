package com.facebook.analytics;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AnalyticsServiceEvent$1
  implements Parcelable.Creator<AnalyticsServiceEvent>
{
  public AnalyticsServiceEvent a(Parcel paramParcel)
  {
    return new AnalyticsServiceEvent(paramParcel, null);
  }

  public AnalyticsServiceEvent[] a(int paramInt)
  {
    return new AnalyticsServiceEvent[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsServiceEvent.1
 * JD-Core Version:    0.6.0
 */