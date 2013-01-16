package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreadSummary$1
  implements Parcelable.Creator<ThreadSummary>
{
  public ThreadSummary a(Parcel paramParcel)
  {
    return new ThreadSummary(paramParcel, null);
  }

  public ThreadSummary[] a(int paramInt)
  {
    return new ThreadSummary[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSummary.1
 * JD-Core Version:    0.6.0
 */