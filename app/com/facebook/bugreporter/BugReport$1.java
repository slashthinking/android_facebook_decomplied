package com.facebook.bugreporter;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BugReport$1
  implements Parcelable.Creator<BugReport>
{
  public BugReport a(Parcel paramParcel)
  {
    return new BugReport(paramParcel, null);
  }

  public BugReport[] a(int paramInt)
  {
    return new BugReport[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReport.1
 * JD-Core Version:    0.6.0
 */