package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchContactParams$1
  implements Parcelable.Creator<FetchContactParams>
{
  public FetchContactParams a(Parcel paramParcel)
  {
    return new FetchContactParams(paramParcel, null);
  }

  public FetchContactParams[] a(int paramInt)
  {
    return new FetchContactParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactParams.1
 * JD-Core Version:    0.6.0
 */