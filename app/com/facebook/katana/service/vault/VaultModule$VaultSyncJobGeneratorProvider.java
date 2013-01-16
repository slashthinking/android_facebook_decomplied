package com.facebook.katana.service.vault;

import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultSyncJobGeneratorProvider extends AbstractProvider<VaultSyncJobGenerator>
{
  private VaultModule$VaultSyncJobGeneratorProvider(VaultModule paramVaultModule)
  {
  }

  public VaultSyncJobGenerator a()
  {
    return new VaultSyncJobGenerator(VaultModule.a(this.a), (VaultTable)b(VaultTable.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultSyncJobGeneratorProvider
 * JD-Core Version:    0.6.0
 */