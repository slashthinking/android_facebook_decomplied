package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchContactResult$1
  implements Parcelable.Creator<FetchContactResult>
{
  public FetchContactResult a(Parcel paramParcel)
  {
    return new FetchContactResult(paramParcel, null);
  }

  public FetchContactResult[] a(int paramInt)
  {
    return new FetchContactResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactResult.1
 * JD-Core Version:    0.6.0
 */