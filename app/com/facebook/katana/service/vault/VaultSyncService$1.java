package com.facebook.katana.service.vault;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;

class VaultSyncService$1
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Log.a(VaultSyncService.a(), "An exception occurred in " + paramThread.getName(), paramThrowable);
    ErrorReporting.a(paramThrowable.getClass().getName(), paramThrowable.getMessage(), paramThrowable, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncService.1
 * JD-Core Version:    0.6.0
 */