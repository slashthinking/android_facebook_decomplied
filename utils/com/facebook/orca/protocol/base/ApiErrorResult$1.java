package com.facebook.orca.protocol.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ApiErrorResult$1
  implements Parcelable.Creator<ApiErrorResult>
{
  public ApiErrorResult a(Parcel paramParcel)
  {
    return new ApiErrorResult(paramParcel, null);
  }

  public ApiErrorResult[] a(int paramInt)
  {
    return new ApiErrorResult[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiErrorResult.1
 * JD-Core Version:    0.6.2
 */