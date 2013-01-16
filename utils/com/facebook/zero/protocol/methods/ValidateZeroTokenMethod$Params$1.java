package com.facebook.zero.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ValidateZeroTokenMethod$Params$1
  implements Parcelable.Creator<ValidateZeroTokenMethod.Params>
{
  public ValidateZeroTokenMethod.Params a(Parcel paramParcel)
  {
    return new ValidateZeroTokenMethod.Params(paramParcel.readString());
  }

  public ValidateZeroTokenMethod.Params[] a(int paramInt)
  {
    return new ValidateZeroTokenMethod.Params[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.protocol.methods.ValidateZeroTokenMethod.Params.1
 * JD-Core Version:    0.6.2
 */