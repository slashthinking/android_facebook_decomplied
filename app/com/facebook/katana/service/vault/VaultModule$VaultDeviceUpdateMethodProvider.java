package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultDeviceUpdateMethod;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultDeviceUpdateMethodProvider extends AbstractProvider<VaultDeviceUpdateMethod>
{
  private VaultModule$VaultDeviceUpdateMethodProvider(VaultModule paramVaultModule)
  {
  }

  public VaultDeviceUpdateMethod a()
  {
    return new VaultDeviceUpdateMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultDeviceUpdateMethodProvider
 * JD-Core Version:    0.6.0
 */