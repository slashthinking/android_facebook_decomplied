package com.facebook.katana.service.vault;

 enum VaultSyncJobProcessor$RetryType
{
  static
  {
    MAINTAIN_RETRY = new RetryType("MAINTAIN_RETRY", 2);
    RetryType[] arrayOfRetryType = new RetryType[3];
    arrayOfRetryType[0] = NO_RETRY;
    arrayOfRetryType[1] = RESET_RETRY;
    arrayOfRetryType[2] = MAINTAIN_RETRY;
    $VALUES = arrayOfRetryType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncJobProcessor.RetryType
 * JD-Core Version:    0.6.0
 */