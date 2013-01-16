package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.FolderName;

public class FetchThreadListParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchThreadListParams> CREATOR = new FetchThreadListParams.1();
  private final DataFreshnessParam a;
  private final FolderName b;
  private final long c;
  private final int d;
  private final boolean e;

  private FetchThreadListParams(Parcel paramParcel)
  {
    this.a = DataFreshnessParam.valueOf(paramParcel.readString());
    this.b = ((FolderName)paramParcel.readParcelable(FolderName.class.getClassLoader()));
    this.c = paramParcel.readLong();
    this.d = paramParcel.readInt();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      return;
    }
  }

  FetchThreadListParams(FetchThreadListParamsBuilder paramFetchThreadListParamsBuilder)
  {
    this.a = paramFetchThreadListParamsBuilder.a();
    this.b = paramFetchThreadListParamsBuilder.b();
    this.c = paramFetchThreadListParamsBuilder.c();
    this.d = paramFetchThreadListParamsBuilder.d();
    this.e = paramFetchThreadListParamsBuilder.e();
  }

  public static FetchThreadListParamsBuilder newBuilder()
  {
    return new FetchThreadListParamsBuilder();
  }

  public DataFreshnessParam a()
  {
    return this.a;
  }

  public FolderName b()
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

  public boolean e()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeLong(this.c);
    paramParcel.writeInt(this.d);
    if (this.e);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadListParams
 * JD-Core Version:    0.6.0
 */