package com.facebook.katana.activity.media.vault;

import android.os.AsyncTask;
import com.facebook.katana.service.vault.VaultTable;

class VaultSyncScreenFragment$RefreshVaultTableTask extends AsyncTask<Void, Void, Void>
{
  private final boolean b;

  public VaultSyncScreenFragment$RefreshVaultTableTask(VaultSyncScreenFragment paramVaultSyncScreenFragment, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    VaultSyncScreenFragment.g(this.a).b();
    return null;
  }

  protected void a(Void paramVoid)
  {
    new VaultSyncScreenFragment.RefreshGridTask(this.a, this.b).execute(new Void[0]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.RefreshVaultTableTask
 * JD-Core Version:    0.6.0
 */