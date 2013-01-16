package com.facebook.katana.service.vault;

import com.facebook.katana.features.vault.VaultConstants;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultConstantsProvider extends AbstractProvider<VaultConstants>
{
  private VaultModule$VaultConstantsProvider(VaultModule paramVaultModule)
  {
  }

  public VaultConstants a()
  {
    return new VaultConstants();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultConstantsProvider
 * JD-Core Version:    0.6.0
 */