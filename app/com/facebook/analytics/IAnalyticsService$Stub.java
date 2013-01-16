package com.facebook.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IAnalyticsService$Stub extends Binder
  implements IAnalyticsService
{
  public IAnalyticsService$Stub()
  {
    attachInterface(this, "com.facebook.analytics.IAnalyticsService");
  }

  public static IAnalyticsService a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.facebook.analytics.IAnalyticsService");
      if ((localIInterface != null) && ((localIInterface instanceof IAnalyticsService)))
      {
        localObject = (IAnalyticsService)localIInterface;
        continue;
      }
      localObject = new IAnalyticsService.Stub.Proxy(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default:
    case 1598968902:
      for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); ; bool = true)
      {
        return bool;
        paramParcel2.writeString("com.facebook.analytics.IAnalyticsService");
      }
    case 1:
    }
    paramParcel1.enforceInterface("com.facebook.analytics.IAnalyticsService");
    if (paramParcel1.readInt() != 0);
    for (AnalyticsServiceEvent localAnalyticsServiceEvent = (AnalyticsServiceEvent)AnalyticsServiceEvent.CREATOR.createFromParcel(paramParcel1); ; localAnalyticsServiceEvent = null)
    {
      a(localAnalyticsServiceEvent);
      bool = true;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.analytics.IAnalyticsService.Stub
 * JD-Core Version:    0.6.0
 */