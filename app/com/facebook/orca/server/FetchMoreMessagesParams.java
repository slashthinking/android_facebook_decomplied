package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchMoreMessagesParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMoreMessagesParams> CREATOR = new FetchMoreMessagesParams.1();
  private final ThreadCriteria a;
  private final long b;
  private final long c;
  private final int d;

  private FetchMoreMessagesParams(Parcel paramParcel)
  {
    this.a = ((ThreadCriteria)paramParcel.readParcelable(ThreadCriteria.class.getClassLoader()));
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readInt();
  }

  public FetchMoreMessagesParams(ThreadCriteria paramThreadCriteria, long paramLong1, long paramLong2, int paramInt)
  {
    this.a = paramThreadCriteria;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt;
  }

  public ThreadCriteria a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeInt(this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMoreMessagesParams
 * JD-Core Version:    0.6.0
 */