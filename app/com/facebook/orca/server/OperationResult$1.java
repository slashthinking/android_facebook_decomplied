package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class OperationResult$1
  implements Parcelable.Creator<OperationResult>
{
  public OperationResult a(Parcel paramParcel)
  {
    return new OperationResult(paramParcel, null);
  }

  public OperationResult[] a(int paramInt)
  {
    return new OperationResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OperationResult.1
 * JD-Core Version:    0.6.0
 */