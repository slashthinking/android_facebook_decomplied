package com.facebook.photos.method;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchPhotosResult$1
  implements Parcelable.Creator<FetchPhotosResult>
{
  public FetchPhotosResult a(Parcel paramParcel)
  {
    return new FetchPhotosResult(paramParcel, null);
  }

  public FetchPhotosResult[] a(int paramInt)
  {
    return new FetchPhotosResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.method.FetchPhotosResult.1
 * JD-Core Version:    0.6.0
 */