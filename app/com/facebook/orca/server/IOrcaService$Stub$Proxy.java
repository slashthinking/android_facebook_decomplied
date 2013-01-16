package com.facebook.orca.server;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IOrcaService$Stub$Proxy
  implements IOrcaService
{
  private IBinder a;

  IOrcaService$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public String a(String paramString, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.facebook.orca.server.IOrcaService");
      localParcel1.writeString(paramString);
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
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

  public boolean a(String paramString, ICompletionHandler paramICompletionHandler)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.facebook.orca.server.IOrcaService");
      localParcel1.writeString(paramString);
      if (paramICompletionHandler != null)
      {
        localIBinder = paramICompletionHandler.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        int j = 0;
        if (i != 0)
          j = 1;
        return j;
      }
      IBinder localIBinder = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.IOrcaService.Stub.Proxy
 * JD-Core Version:    0.6.0
 */