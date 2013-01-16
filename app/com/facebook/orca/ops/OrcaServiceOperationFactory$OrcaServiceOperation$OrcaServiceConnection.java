package com.facebook.orca.ops;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.orca.server.IOrcaService.Stub;

class OrcaServiceOperationFactory$OrcaServiceOperation$OrcaServiceConnection
  implements ServiceConnection
{
  private OrcaServiceOperationFactory$OrcaServiceOperation$OrcaServiceConnection(OrcaServiceOperationFactory.OrcaServiceOperation paramOrcaServiceOperation)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (!this.a.b())
    {
      OrcaServiceOperationFactory.OrcaServiceOperation.a(this.a, IOrcaService.Stub.a(paramIBinder));
      OrcaServiceOperationFactory.OrcaServiceOperation.c(this.a);
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    OrcaServiceOperationFactory.OrcaServiceOperation.a(this.a, null);
    OrcaServiceOperationFactory.OrcaServiceOperation.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation.OrcaServiceConnection
 * JD-Core Version:    0.6.0
 */