package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.FolderName;

public class FetchMoreThreadsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMoreThreadsParams> CREATOR = new FetchMoreThreadsParams.1();
  private final FolderName a;
  private final long b;
  private final int c;

  private FetchMoreThreadsParams(Parcel paramParcel)
  {
    this.a = ((FolderName)paramParcel.readParcelable(FolderName.class.getClassLoader()));
    this.b = paramParcel.readLong();
    this.c = paramParcel.readInt();
  }

  public FetchMoreThreadsParams(FolderName paramFolderName, long paramLong, int paramInt)
  {
    this.a = paramFolderName;
    this.b = paramLong;
    this.c = paramInt;
  }

  public FolderName a()
  {
    return this.a;
  }

  public long b()
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
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeLong(this.b);
    paramParcel.writeInt(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMoreThreadsParams
 * JD-Core Version:    0.6.0
 */