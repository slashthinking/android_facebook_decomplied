package com.facebook.timeline.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TimelineClearCacheParams
  implements Parcelable
{
  public static final Parcelable.Creator<TimelineClearCacheParams> CREATOR = new TimelineClearCacheParams.1();
  private final long a;
  private final String b;

  public TimelineClearCacheParams(long paramLong, String paramString)
  {
    this.a = paramLong;
    this.b = paramString;
  }

  private TimelineClearCacheParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
  }

  public long a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
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
 * Qualified Name:     com.facebook.timeline.cache.TimelineClearCacheParams
 * JD-Core Version:    0.6.0
 */