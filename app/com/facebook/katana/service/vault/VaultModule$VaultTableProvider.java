package com.facebook.katana.service.vault;

import android.app.Application;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultTableProvider extends AbstractProvider<VaultTable>
{
  private VaultModule$VaultTableProvider(VaultModule paramVaultModule)
  {
  }

  public VaultTable a()
  {
    return new VaultTable(VaultModule.a(this.a), VaultModule.a(this.a).getContentResolver(), (VaultLocalImageFetcher)b(VaultLocalImageFetcher.class), (VaultRowStatusUpdater)b(VaultRowStatusUpdater.class), (VaultImageStatusFetcher)b(VaultImageStatusFetcher.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultTableProvider
 * JD-Core Version:    0.6.0
 */