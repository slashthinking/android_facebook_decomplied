package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchNodeListParams$1
  implements Parcelable.Creator<FetchNodeListParams>
{
  public FetchNodeListParams a(Parcel paramParcel)
  {
    return new FetchNodeListParams(paramParcel);
  }

  public FetchNodeListParams[] a(int paramInt)
  {
    return new FetchNodeListParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNodeListParams.1
 * JD-Core Version:    0.6.0
 */