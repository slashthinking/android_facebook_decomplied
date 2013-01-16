package com.facebook.photos.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FbPhotoTag$1
  implements Parcelable.Creator<FbPhotoTag>
{
  public FbPhotoTag a(Parcel paramParcel)
  {
    return new FbPhotoTag(paramParcel, null);
  }

  public FbPhotoTag[] a(int paramInt)
  {
    return new FbPhotoTag[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.FbPhotoTag.1
 * JD-Core Version:    0.6.0
 */