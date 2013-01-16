package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserSetContactInfoMethod$Params$1
  implements Parcelable.Creator<UserSetContactInfoMethod.Params>
{
  public UserSetContactInfoMethod.Params a(Parcel paramParcel)
  {
    int i = 1;
    String str = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      return new UserSetContactInfoMethod.Params(str, i);
      int j = 0;
    }
  }

  public UserSetContactInfoMethod.Params[] a(int paramInt)
  {
    return new UserSetContactInfoMethod.Params[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.UserSetContactInfoMethod.Params.1
 * JD-Core Version:    0.6.0
 */