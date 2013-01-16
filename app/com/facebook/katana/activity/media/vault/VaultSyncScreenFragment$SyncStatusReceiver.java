package com.facebook.katana.activity.media.vault;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class VaultSyncScreenFragment$SyncStatusReceiver extends BroadcastReceiver
{
  private VaultSyncScreenFragment$SyncStatusReceiver(VaultSyncScreenFragment paramVaultSyncScreenFragment)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("vault.table_refreshed_key", false))
      new VaultSyncScreenFragment.RefreshGridTask(this.a, false).execute(new Void[0]);
    while (true)
    {
      return;
      if ((paramIntent.getBooleanExtra("vault.sync_start", false)) || (paramIntent.getBooleanExtra("vault.sync_end", false)))
      {
        VaultSyncScreenFragment.a(this.a).a();
        continue;
      }
      if (!paramIntent.hasExtra("vault.row_upload_key"))
        continue;
      VaultSyncScreenFragment.a(this.a, paramIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.SyncStatusReceiver
 * JD-Core Version:    0.6.0
 */