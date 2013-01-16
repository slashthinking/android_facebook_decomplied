package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultImageUploadMethod;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultImageUploadMethodProvider extends AbstractProvider<VaultImageUploadMethod>
{
  private VaultModule$VaultImageUploadMethodProvider(VaultModule paramVaultModule)
  {
  }

  public VaultImageUploadMethod a()
  {
    return new VaultImageUploadMethod(VaultModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultImageUploadMethodProvider
 * JD-Core Version:    0.6.0
 */