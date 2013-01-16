package com.facebook.katana.service.vault;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.util.ImageUtil;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$VaultRowStatusUpdaterProvider extends AbstractProvider<VaultRowStatusUpdater>
{
  private VaultModule$VaultRowStatusUpdaterProvider(VaultModule paramVaultModule)
  {
  }

  public VaultRowStatusUpdater a()
  {
    return new VaultRowStatusUpdater((VaultLocalImageFetcher)b(VaultLocalImageFetcher.class), (ImageUtil)b(ImageUtil.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultRowStatusUpdaterProvider
 * JD-Core Version:    0.6.0
 */