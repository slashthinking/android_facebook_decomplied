package com.facebook.photos.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FbPhoto$1
  implements Parcelable.Creator<FbPhoto>
{
  public FbPhoto a(Parcel paramParcel)
  {
    return new FbPhoto(paramParcel, null);
  }

  public FbPhoto[] a(int paramInt)
  {
    return new FbPhoto[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.FbPhoto.1
 * JD-Core Version:    0.6.0
 */