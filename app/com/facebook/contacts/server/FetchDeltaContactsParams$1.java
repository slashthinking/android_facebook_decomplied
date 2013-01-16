package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchDeltaContactsParams$1
  implements Parcelable.Creator<FetchDeltaContactsParams>
{
  public FetchDeltaContactsParams a(Parcel paramParcel)
  {
    return new FetchDeltaContactsParams(paramParcel, null);
  }

  public FetchDeltaContactsParams[] a(int paramInt)
  {
    return new FetchDeltaContactsParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchDeltaContactsParams.1
 * JD-Core Version:    0.6.0
 */