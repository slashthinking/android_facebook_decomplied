package com.facebook.katana.server.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ParcelableBoolean$1
  implements Parcelable.Creator<ParcelableBoolean>
{
  public ParcelableBoolean a(Parcel paramParcel)
  {
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
      return new ParcelableBoolean(bool);
  }

  public ParcelableBoolean[] a(int paramInt)
  {
    return new ParcelableBoolean[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.utils.ParcelableBoolean.1
 * JD-Core Version:    0.6.0
 */