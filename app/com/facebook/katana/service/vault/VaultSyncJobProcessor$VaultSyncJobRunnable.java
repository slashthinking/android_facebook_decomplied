package com.facebook.katana.service.vault;

import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.orca.inject.FbInjector;

class VaultSyncJobProcessor$VaultSyncJobRunnable
  implements Runnable
{
  VaultImageProviderRow a;
  int b;

  public VaultSyncJobProcessor$VaultSyncJobRunnable(VaultSyncJobProcessor paramVaultSyncJobProcessor, VaultImageProviderRow paramVaultImageProviderRow, int paramInt)
  {
    this.a = paramVaultImageProviderRow;
    this.b = paramInt;
  }

  public void run()
  {
    VaultImageProviderRow localVaultImageProviderRow = ((VaultTable)FbInjector.a(VaultSyncJobProcessor.a(this.c)).a(VaultTable.class)).a(this.a.a);
    if ((localVaultImageProviderRow == null) || (localVaultImageProviderRow.f == 5))
    {
      ((VaultNotificationManager)FbInjector.a(VaultSyncJobProcessor.a(this.c)).a(VaultNotificationManager.class)).a(this.a.a);
      return;
    }
    VaultSyncJobProcessor localVaultSyncJobProcessor;
    if ((((VaultNewImageUploader)FbInjector.a(VaultSyncJobProcessor.a(this.c)).a(VaultNewImageUploader.class)).a(this.a, this.b)) && (VaultSyncJobProcessor.b(this.c) != VaultSyncJobProcessor.RetryType.RESET_RETRY))
    {
      localVaultSyncJobProcessor = this.c;
      if (this.b != 3)
        break label141;
    }
    label141: for (VaultSyncJobProcessor.RetryType localRetryType = VaultSyncJobProcessor.RetryType.MAINTAIN_RETRY; ; localRetryType = VaultSyncJobProcessor.RetryType.RESET_RETRY)
    {
      VaultSyncJobProcessor.a(localVaultSyncJobProcessor, localRetryType);
      break;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncJobProcessor.VaultSyncJobRunnable
 * JD-Core Version:    0.6.0
 */