package com.facebook.katana.service.vault;

import android.content.Context;
import android.content.Intent;

public class VaultSyncService$VaultSyncServiceRunnable
  implements Runnable
{
  Context a;
  Intent b;
  int c;

  public VaultSyncService$VaultSyncServiceRunnable(VaultSyncService paramVaultSyncService, Context paramContext, Intent paramIntent, int paramInt)
  {
    this.a = paramContext;
    this.b = paramIntent;
    this.c = paramInt;
  }

  public void run()
  {
    VaultSyncService.a(this.d, this.a, this.b, this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncService.VaultSyncServiceRunnable
 * JD-Core Version:    0.6.0
 */