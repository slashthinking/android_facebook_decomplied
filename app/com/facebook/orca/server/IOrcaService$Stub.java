package com.facebook.orca.server;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IOrcaService$Stub extends Binder
  implements IOrcaService
{
  public IOrcaService$Stub()
  {
    attachInterface(this, "com.facebook.orca.server.IOrcaService");
  }

  public static IOrcaService a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.facebook.orca.server.IOrcaService");
      if ((localIInterface != null) && ((localIInterface instanceof IOrcaService)))
      {
        localObject = (IOrcaService)localIInterface;
        continue;
      }
      localObject = new IOrcaService.Stub.Proxy(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 1;
    switch (paramInt1)
    {
    default:
      i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      while (true)
      {
        return i;
        paramParcel2.writeString("com.facebook.orca.server.IOrcaService");
      }
    case 1:
      paramParcel1.enforceInterface("com.facebook.orca.server.IOrcaService");
      String str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle = null)
      {
        String str2 = a(str1, localBundle);
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        break;
      }
    case 2:
    }
    paramParcel1.enforceInterface("com.facebook.orca.server.IOrcaService");
    boolean bool = a(paramParcel1.readString(), ICompletionHandler.Stub.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    if (bool);
    int k;
    for (int j = i; ; k = 0)
    {
      paramParcel2.writeInt(j);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.IOrcaService.Stub
 * JD-Core Version:    0.6.0
 */