package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchTimelineHeaderParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchTimelineHeaderParams> CREATOR = new FetchTimelineHeaderParams.1();
  private final long a;
  private final int b;
  private final int c;

  public FetchTimelineHeaderParams(long paramLong, int paramInt1, int paramInt2)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramInt2;
  }

  private FetchTimelineHeaderParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }

  public long a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
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
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineHeaderParams
 * JD-Core Version:    0.6.0
 */