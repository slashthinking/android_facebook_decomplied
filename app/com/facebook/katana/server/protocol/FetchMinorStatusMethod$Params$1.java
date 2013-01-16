package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchMinorStatusMethod$Params$1
  implements Parcelable.Creator<FetchMinorStatusMethod.Params>
{
  public FetchMinorStatusMethod.Params a(Parcel paramParcel)
  {
    return new FetchMinorStatusMethod.Params(paramParcel.readLong());
  }

  public FetchMinorStatusMethod.Params[] a(int paramInt)
  {
    return new FetchMinorStatusMethod.Params[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.FetchMinorStatusMethod.Params.1
 * JD-Core Version:    0.6.0
 */