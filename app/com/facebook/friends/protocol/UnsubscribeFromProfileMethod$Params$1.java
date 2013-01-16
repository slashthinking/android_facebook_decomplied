package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UnsubscribeFromProfileMethod$Params$1
  implements Parcelable.Creator<UnsubscribeFromProfileMethod.Params>
{
  public UnsubscribeFromProfileMethod.Params a(Parcel paramParcel)
  {
    return new UnsubscribeFromProfileMethod.Params(paramParcel.readLong());
  }

  public UnsubscribeFromProfileMethod.Params[] a(int paramInt)
  {
    return new UnsubscribeFromProfileMethod.Params[0];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.UnsubscribeFromProfileMethod.Params.1
 * JD-Core Version:    0.6.0
 */