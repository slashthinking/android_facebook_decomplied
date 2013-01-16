package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusMethod;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultGetSyncedImageStatusMethodProvider extends AbstractProvider<VaultGetSyncedImageStatusMethod>
{
  private VaultModule$VaultGetSyncedImageStatusMethodProvider(VaultModule paramVaultModule)
  {
  }

  public VaultGetSyncedImageStatusMethod a()
  {
    return new VaultGetSyncedImageStatusMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultGetSyncedImageStatusMethodProvider
 * JD-Core Version:    0.6.0
 */