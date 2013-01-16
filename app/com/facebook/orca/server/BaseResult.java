package com.facebook.orca.server;

import android.os.Parcel;

public class BaseResult
{
  private final DataFreshnessResult a;
  private final long b;

  protected BaseResult(Parcel paramParcel)
  {
    this.a = ((DataFreshnessResult)paramParcel.readSerializable());
    this.b = paramParcel.readLong();
  }

  protected BaseResult(DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    this.a = paramDataFreshnessResult;
    this.b = paramLong;
  }

  public DataFreshnessResult e()
  {
    return this.a;
  }

  public long f()
  {
    return this.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(e());
    paramParcel.writeLong(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.BaseResult
 * JD-Core Version:    0.6.0
 */