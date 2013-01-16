package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchContactsResult$1
  implements Parcelable.Creator<FetchContactsResult>
{
  public FetchContactsResult a(Parcel paramParcel)
  {
    return new FetchContactsResult(paramParcel, null);
  }

  public FetchContactsResult[] a(int paramInt)
  {
    return new FetchContactsResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactsResult.1
 * JD-Core Version:    0.6.0
 */