package com.facebook.pages.identity.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchPageIdentityDataMethod$Params$1
  implements Parcelable.Creator<FetchPageIdentityDataMethod.Params>
{
  public FetchPageIdentityDataMethod.Params a(Parcel paramParcel)
  {
    return new FetchPageIdentityDataMethod.Params(paramParcel.readLong(), paramParcel.readInt());
  }

  public FetchPageIdentityDataMethod.Params[] a(int paramInt)
  {
    return new FetchPageIdentityDataMethod.Params[0];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod.Params.1
 * JD-Core Version:    0.6.2
 */