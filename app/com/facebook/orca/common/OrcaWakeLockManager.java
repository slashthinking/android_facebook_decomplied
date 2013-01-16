package com.facebook.orca.common;

import android.os.PowerManager;
import com.google.common.collect.Maps;
import java.util.Map;

public class OrcaWakeLockManager
{
  private final PowerManager a;
  private final Map<OrcaWakeLockManager.WakeLock, OrcaWakeLockManager.WakeLock> b = Maps.c();
  private long c = 0L;

  public OrcaWakeLockManager(PowerManager paramPowerManager)
  {
    this.a = paramPowerManager;
  }

  public OrcaWakeLockManager.WakeLock a(int paramInt, String paramString)
  {
    monitorenter;
    try
    {
      OrcaWakeLockManager.WakeLock localWakeLock = new OrcaWakeLockManager.WakeLock(this, this.a.newWakeLock(paramInt, paramString), paramString);
      this.b.put(localWakeLock, localWakeLock);
      monitorexit;
      return localWakeLock;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.OrcaWakeLockManager
 * JD-Core Version:    0.6.0
 */