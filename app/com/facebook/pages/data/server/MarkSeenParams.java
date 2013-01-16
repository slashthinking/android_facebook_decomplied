package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MarkSeenParams
  implements Parcelable
{
  public static final Parcelable.Creator<MarkSeenParams> CREATOR = new MarkSeenParams.1();
  private final long a;
  private final String b;

  public MarkSeenParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.MarkSeenParams
 * JD-Core Version:    0.6.0
 */