package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchThreadParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchThreadParams> CREATOR = new FetchThreadParams.1();
  private final ThreadCriteria a;
  private final DataFreshnessParam b;
  private final DataFreshnessParam c;
  private final boolean d;
  private final long e;
  private final int f;
  private final long g;

  private FetchThreadParams(Parcel paramParcel)
  {
    this.a = ((ThreadCriteria)paramParcel.readParcelable(ThreadCriteria.class.getClassLoader()));
    this.b = DataFreshnessParam.valueOf(paramParcel.readString());
    this.c = DataFreshnessParam.valueOf(paramParcel.readString());
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      this.e = paramParcel.readLong();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readLong();
      return;
    }
  }

  FetchThreadParams(FetchThreadParamsBuilder paramFetchThreadParamsBuilder)
  {
    this.a = paramFetchThreadParamsBuilder.a();
    this.b = paramFetchThreadParamsBuilder.b();
    this.c = paramFetchThreadParamsBuilder.c();
    this.d = paramFetchThreadParamsBuilder.d();
    this.e = paramFetchThreadParamsBuilder.e();
    this.f = paramFetchThreadParamsBuilder.f();
    this.g = paramFetchThreadParamsBuilder.g();
  }

  public static FetchThreadParamsBuilder newBuilder()
  {
    return new FetchThreadParamsBuilder();
  }

  public ThreadCriteria a()
  {
    return this.a;
  }

  public DataFreshnessParam b()
  {
    return this.b;
  }

  public DataFreshnessParam c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public long e()
  {
    return this.e;
  }

  public int f()
  {
    return this.f;
  }

  public long g()
  {
    return this.g;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b.toString());
    paramParcel.writeString(this.c.toString());
    if (this.d);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeLong(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeLong(this.g);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadParams
 * JD-Core Version:    0.6.0
 */