package com.facebook.katana.service.vault;

import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.service.vault.methods.VaultDeviceGetMethod;
import com.facebook.katana.service.vault.methods.VaultDevicePostMethod;
import com.facebook.katana.service.vault.methods.VaultDeviceUpdateMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class VaultModule$VaultDeviceSetupProvider extends AbstractProvider<VaultDeviceSetup>
{
  private VaultModule$VaultDeviceSetupProvider(VaultModule paramVaultModule)
  {
  }

  public VaultDeviceSetup a()
  {
    return new VaultDeviceSetup(VaultModule.a(this.a), (SingleMethodRunner)b(SingleMethodRunner.class), (VaultDevicePostMethod)b(VaultDevicePostMethod.class), (VaultDeviceGetMethod)b(VaultDeviceGetMethod.class), (VaultDeviceUpdateMethod)b(VaultDeviceUpdateMethod.class), (UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultDeviceSetupProvider
 * JD-Core Version:    0.6.0
 */