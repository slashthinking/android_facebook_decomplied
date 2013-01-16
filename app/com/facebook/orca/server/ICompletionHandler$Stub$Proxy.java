package com.facebook.orca.server;

import android.os.IBinder;
import android.os.Parcel;

class ICompletionHandler$Stub$Proxy
  implements ICompletionHandler
{
  private IBinder a;

  ICompletionHandler$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a(OperationResult paramOperationResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.facebook.orca.server.ICompletionHandler");
      if (paramOperationResult != null)
      {
        localParcel1.writeInt(1);
        paramOperationResult.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public IBinder asBinder()
  {
    return this.a;
  }

  public void b(OperationResult paramOperationResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.facebook.orca.server.ICompletionHandler");
      if (paramOperationResult != null)
      {
        localParcel1.writeInt(1);
        paramOperationResult.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ICompletionHandler.Stub.Proxy
 * JD-Core Version:    0.6.0
 */