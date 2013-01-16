package com.facebook.katana.service.vault;

import com.facebook.common.util.ProcessUtil;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultManagerProvider extends AbstractProvider<VaultManager>
{
  private VaultModule$VaultManagerProvider(VaultModule paramVaultModule)
  {
  }

  public VaultManager a()
  {
    return new VaultManager(VaultModule.a(this.a), (UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class), (ProcessUtil)b(ProcessUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultManagerProvider
 * JD-Core Version:    0.6.0
 */