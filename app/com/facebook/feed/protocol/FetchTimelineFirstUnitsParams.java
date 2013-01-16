package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchTimelineFirstUnitsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchTimelineFirstUnitsParams> CREATOR = new FetchTimelineFirstUnitsParams.1();
  private final long a;
  private final boolean b;
  private final String c;

  public FetchTimelineFirstUnitsParams(long paramLong, boolean paramBoolean, String paramString)
  {
    this.a = paramLong;
    this.b = paramBoolean;
    this.c = paramString;
  }

  private FetchTimelineFirstUnitsParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      this.c = paramParcel.readString();
      return;
    }
  }

  public long a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.c);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineFirstUnitsParams
 * JD-Core Version:    0.6.0
 */