package com.facebook.analytics;

import android.os.IBinder;
import android.os.Parcel;

class IAnalyticsService$Stub$Proxy
  implements IAnalyticsService
{
  private IBinder a;

  IAnalyticsService$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a(AnalyticsServiceEvent paramAnalyticsServiceEvent)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.facebook.analytics.IAnalyticsService");
      if (paramAnalyticsServiceEvent != null)
      {
        localParcel.writeInt(1);
        paramAnalyticsServiceEvent.writeToParcel(localParcel, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel, null, 1);
        return;
        localParcel.writeInt(0);
      }
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.analytics.IAnalyticsService.Stub.Proxy
 * JD-Core Version:    0.6.0
 */