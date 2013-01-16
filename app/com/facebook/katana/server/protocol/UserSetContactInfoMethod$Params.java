package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserSetContactInfoMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new UserSetContactInfoMethod.Params.1();
  public final String a;
  public final boolean b;

  public UserSetContactInfoMethod$Params(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.UserSetContactInfoMethod.Params
 * JD-Core Version:    0.6.0
 */