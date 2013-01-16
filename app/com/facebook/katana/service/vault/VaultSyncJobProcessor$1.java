package com.facebook.katana.service.vault;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.orca.inject.FbInjector;

class VaultSyncJobProcessor$1
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Log.a("An exception occurred in " + paramThread.getName(), paramThrowable);
    ((VaultTable)FbInjector.a(VaultSyncJobProcessor.a(this.a)).a(VaultTable.class)).a(0L);
    this.a.stopSelf();
    ErrorReporting.a(paramThrowable.getClass().getName(), paramThrowable.getMessage(), paramThrowable, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncJobProcessor.1
 * JD-Core Version:    0.6.0
 */