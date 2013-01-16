package com.facebook.katana.service.vault;

import com.facebook.orca.inject.FbInjector;

class VaultManager$3
  implements Runnable
{
  public void run()
  {
    ((VaultTable)FbInjector.a(VaultManager.c(this.a)).a(VaultTable.class)).a(0L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultManager.3
 * JD-Core Version:    0.6.0
 */