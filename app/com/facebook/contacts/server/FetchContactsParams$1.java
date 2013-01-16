package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchContactsParams$1
  implements Parcelable.Creator<FetchContactsParams>
{
  public FetchContactsParams a(Parcel paramParcel)
  {
    return new FetchContactsParams(paramParcel, null);
  }

  public FetchContactsParams[] a(int paramInt)
  {
    return new FetchContactsParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactsParams.1
 * JD-Core Version:    0.6.0
 */