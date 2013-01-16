package com.facebook.zero.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CarrierMccMnc$1
  implements Parcelable.Creator<CarrierMccMnc>
{
  public CarrierMccMnc a(Parcel paramParcel)
  {
    return new CarrierMccMnc(paramParcel.readString(), paramParcel.readString());
  }

  public CarrierMccMnc[] a(int paramInt)
  {
    return new CarrierMccMnc[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.protocol.CarrierMccMnc.1
 * JD-Core Version:    0.6.2
 */