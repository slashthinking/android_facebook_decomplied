package com.facebook.katana.service.vault;

import com.facebook.katana.service.vault.methods.VaultImageUploadMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class VaultModule$VaultNewImageUploaderProvider extends AbstractProvider<VaultNewImageUploader>
{
  private VaultModule$VaultNewImageUploaderProvider(VaultModule paramVaultModule)
  {
  }

  public VaultNewImageUploader a()
  {
    return new VaultNewImageUploader(VaultModule.a(this.a), (SingleMethodRunner)b(SingleMethodRunner.class), (VaultImageUploadMethod)b(VaultImageUploadMethod.class), (VaultLocalImageFetcher)b(VaultLocalImageFetcher.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.VaultNewImageUploaderProvider
 * JD-Core Version:    0.6.0
 */