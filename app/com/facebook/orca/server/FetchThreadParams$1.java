package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchThreadParams$1
  implements Parcelable.Creator<FetchThreadParams>
{
  public FetchThreadParams a(Parcel paramParcel)
  {
    return new FetchThreadParams(paramParcel, null);
  }

  public FetchThreadParams[] a(int paramInt)
  {
    return new FetchThreadParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadParams.1
 * JD-Core Version:    0.6.0
 */