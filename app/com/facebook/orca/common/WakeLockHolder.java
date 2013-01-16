package com.facebook.orca.common;

public abstract class WakeLockHolder
{
  public final OrcaWakeLockManager.WakeLock a;

  public WakeLockHolder(OrcaWakeLockManager paramOrcaWakeLockManager, int paramInt, String paramString)
  {
    this.a = paramOrcaWakeLockManager.a(paramInt, paramString);
  }

  public WakeLockHolder(OrcaWakeLockManager paramOrcaWakeLockManager, String paramString)
  {
    this.a = paramOrcaWakeLockManager.a(1, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.WakeLockHolder
 * JD-Core Version:    0.6.0
 */