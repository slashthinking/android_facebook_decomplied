package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreadCriteria$1
  implements Parcelable.Creator<ThreadCriteria>
{
  public ThreadCriteria a(Parcel paramParcel)
  {
    return new ThreadCriteria(paramParcel, null);
  }

  public ThreadCriteria[] a(int paramInt)
  {
    return new ThreadCriteria[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ThreadCriteria.1
 * JD-Core Version:    0.6.0
 */