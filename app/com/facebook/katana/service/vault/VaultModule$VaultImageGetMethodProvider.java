package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultImageGetMethod;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultImageGetMethodProvider extends AbstractProvider<VaultImageGetMethod>
{
  private VaultModule$VaultImageGetMethodProvider(VaultModule paramVaultModule)
  {
  }

  public VaultImageGetMethod a()
  {
    return new VaultImageGetMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultImageGetMethodProvider
 * JD-Core Version:    0.6.0
 */