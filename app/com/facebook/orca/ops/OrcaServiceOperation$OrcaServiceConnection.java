package com.facebook.orca.ops;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.orca.server.IOrcaService.Stub;

class OrcaServiceOperation$OrcaServiceConnection
  implements ServiceConnection
{
  private OrcaServiceOperation$OrcaServiceConnection(OrcaServiceOperation paramOrcaServiceOperation)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (!OrcaServiceOperation.a(this.a))
    {
      OrcaServiceOperation.a(this.a, IOrcaService.Stub.a(paramIBinder));
      OrcaServiceOperation.b(this.a);
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    OrcaServiceOperation.a(this.a, null);
    OrcaServiceOperation.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperation.OrcaServiceConnection
 * JD-Core Version:    0.6.0
 */