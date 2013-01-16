package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchAllContactsResult$1
  implements Parcelable.Creator<FetchAllContactsResult>
{
  public FetchAllContactsResult a(Parcel paramParcel)
  {
    return new FetchAllContactsResult(paramParcel, null);
  }

  public FetchAllContactsResult[] a(int paramInt)
  {
    return new FetchAllContactsResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchAllContactsResult.1
 * JD-Core Version:    0.6.0
 */