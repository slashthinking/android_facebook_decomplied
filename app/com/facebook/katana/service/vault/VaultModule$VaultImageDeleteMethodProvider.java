package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultImageDeleteMethod;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultImageDeleteMethodProvider extends AbstractProvider<VaultImageDeleteMethod>
{
  private VaultModule$VaultImageDeleteMethodProvider(VaultModule paramVaultModule)
  {
  }

  public VaultImageDeleteMethod a()
  {
    return new VaultImageDeleteMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultImageDeleteMethodProvider
 * JD-Core Version:    0.6.0
 */