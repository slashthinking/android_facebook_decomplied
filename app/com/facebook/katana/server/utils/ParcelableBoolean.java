package com.facebook.katana.server.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableBoolean
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableBoolean> CREATOR = new ParcelableBoolean.1();
  public final boolean a;

  public ParcelableBoolean(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.utils.ParcelableBoolean
 * JD-Core Version:    0.6.0
 */