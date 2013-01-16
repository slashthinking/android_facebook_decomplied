package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchMultipleThreadsParams$1
  implements Parcelable.Creator<FetchMultipleThreadsParams>
{
  public FetchMultipleThreadsParams a(Parcel paramParcel)
  {
    return new FetchMultipleThreadsParams(paramParcel, null);
  }

  public FetchMultipleThreadsParams[] a(int paramInt)
  {
    return new FetchMultipleThreadsParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMultipleThreadsParams.1
 * JD-Core Version:    0.6.0
 */