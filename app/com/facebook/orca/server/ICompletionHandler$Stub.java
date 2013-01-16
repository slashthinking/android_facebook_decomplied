package com.facebook.orca.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ICompletionHandler$Stub extends Binder
  implements ICompletionHandler
{
  public ICompletionHandler$Stub()
  {
    attachInterface(this, "com.facebook.orca.server.ICompletionHandler");
  }

  public static ICompletionHandler a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.facebook.orca.server.ICompletionHandler");
      if ((localIInterface != null) && ((localIInterface instanceof ICompletionHandler)))
      {
        localObject = (ICompletionHandler)localIInterface;
        continue;
      }
      localObject = new ICompletionHandler.Stub.Proxy(paramIBinder);
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
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
    case 1:
    case 2:
    }
    while (true)
    {
      return bool;
      paramParcel2.writeString("com.facebook.orca.server.ICompletionHandler");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.facebook.orca.server.ICompletionHandler");
      int j = paramParcel1.readInt();
      OperationResult localOperationResult2 = null;
      if (j != 0)
        localOperationResult2 = (OperationResult)OperationResult.CREATOR.createFromParcel(paramParcel1);
      a(localOperationResult2);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.facebook.orca.server.ICompletionHandler");
      int i = paramParcel1.readInt();
      OperationResult localOperationResult1 = null;
      if (i != 0)
        localOperationResult1 = (OperationResult)OperationResult.CREATOR.createFromParcel(paramParcel1);
      b(localOperationResult1);
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ICompletionHandler.Stub
 * JD-Core Version:    0.6.0
 */