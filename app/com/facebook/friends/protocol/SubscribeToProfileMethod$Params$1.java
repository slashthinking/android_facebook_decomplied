package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SubscribeToProfileMethod$Params$1
  implements Parcelable.Creator<SubscribeToProfileMethod.Params>
{
  public SubscribeToProfileMethod.Params a(Parcel paramParcel)
  {
    return new SubscribeToProfileMethod.Params(paramParcel.readLong());
  }

  public SubscribeToProfileMethod.Params[] a(int paramInt)
  {
    return new SubscribeToProfileMethod.Params[0];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.SubscribeToProfileMethod.Params.1
 * JD-Core Version:    0.6.0
 */