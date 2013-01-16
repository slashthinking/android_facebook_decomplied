package com.facebook.photos.method;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchPhotoParams$1
  implements Parcelable.Creator<FetchPhotoParams>
{
  public FetchPhotoParams a(Parcel paramParcel)
  {
    return new FetchPhotoParams(paramParcel, null);
  }

  public FetchPhotoParams[] a(int paramInt)
  {
    return new FetchPhotoParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.method.FetchPhotoParams.1
 * JD-Core Version:    0.6.0
 */