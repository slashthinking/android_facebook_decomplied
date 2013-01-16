package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FolderCounts
  implements Parcelable
{
  public static final Parcelable.Creator<FolderCounts> CREATOR = new FolderCounts.1();
  private final int a;
  private final int b;
  private final long c;
  private final long d;

  public FolderCounts(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong1;
    this.d = paramLong2;
  }

  private FolderCounts(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.FolderCounts
 * JD-Core Version:    0.6.0
 */