package com.facebook.katana.service.vault;

import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultLocalImageFetcherProvider extends AbstractProvider<VaultLocalImageFetcher>
{
  private VaultModule$VaultLocalImageFetcherProvider(VaultModule paramVaultModule)
  {
  }

  public VaultLocalImageFetcher a()
  {
    return new VaultLocalImageFetcher(VaultModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultLocalImageFetcherProvider
 * JD-Core Version:    0.6.0
 */