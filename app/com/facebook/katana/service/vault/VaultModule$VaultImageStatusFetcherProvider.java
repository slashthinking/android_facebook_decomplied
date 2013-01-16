package com.facebook.katana.service.vault;

import com.facebook.katana.features.vault.VaultConstants;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class VaultModule$VaultImageStatusFetcherProvider extends AbstractProvider<VaultImageStatusFetcher>
{
  private VaultModule$VaultImageStatusFetcherProvider(VaultModule paramVaultModule)
  {
  }

  public VaultImageStatusFetcher a()
  {
    return new VaultImageStatusFetcher((SingleMethodRunner)b(SingleMethodRunner.class), (VaultGetSyncedImageStatusMethod)b(VaultGetSyncedImageStatusMethod.class), (VaultConstants)b(VaultConstants.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultImageStatusFetcherProvider
 * JD-Core Version:    0.6.0
 */