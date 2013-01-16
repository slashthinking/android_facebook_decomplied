package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultQuotaGetMethod;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultQuotaGetMethodProvider extends AbstractProvider<VaultQuotaGetMethod>
{
  private VaultModule$VaultQuotaGetMethodProvider(VaultModule paramVaultModule)
  {
  }

  public VaultQuotaGetMethod a()
  {
    return new VaultQuotaGetMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultQuotaGetMethodProvider
 * JD-Core Version:    0.6.0
 */