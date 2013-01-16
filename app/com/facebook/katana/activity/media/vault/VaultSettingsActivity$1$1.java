package com.facebook.katana.activity.media.vault;

import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.VaultDeviceSetup;
import com.facebook.orca.inject.FbInjector;

class VaultSettingsActivity$1$1 extends Thread
{
  public void run()
  {
    long l = UserValuesManager.g(this.b.a);
    ((VaultDeviceSetup)FbInjector.a(this.b.a).a(VaultDeviceSetup.class)).a(l, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSettingsActivity.1.1
 * JD-Core Version:    0.6.0
 */