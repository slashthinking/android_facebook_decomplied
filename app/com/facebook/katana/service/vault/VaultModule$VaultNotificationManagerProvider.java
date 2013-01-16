package com.facebook.katana.service.vault;

import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultNotificationManagerProvider extends AbstractProvider<VaultNotificationManager>
{
  private VaultModule$VaultNotificationManagerProvider(VaultModule paramVaultModule)
  {
  }

  public VaultNotificationManager a()
  {
    return new VaultNotificationManager(VaultModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultNotificationManagerProvider
 * JD-Core Version:    0.6.0
 */