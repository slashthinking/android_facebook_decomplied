package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchAllContactsParams$1
  implements Parcelable.Creator<FetchAllContactsParams>
{
  public FetchAllContactsParams a(Parcel paramParcel)
  {
    return new FetchAllContactsParams(paramParcel, null);
  }

  public FetchAllContactsParams[] a(int paramInt)
  {
    return new FetchAllContactsParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchAllContactsParams.1
 * JD-Core Version:    0.6.0
 */