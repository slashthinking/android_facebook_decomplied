package com.facebook.katana.service.vault;

 enum VaultTable$AttemptStatus
{
  static
  {
    AttemptStatus[] arrayOfAttemptStatus = new AttemptStatus[3];
    arrayOfAttemptStatus[0] = FIRST;
    arrayOfAttemptStatus[1] = RETRY_SOFT_FAILURES_ONLY;
    arrayOfAttemptStatus[2] = RETRY_WITH_HARD_FAILURES;
    $VALUES = arrayOfAttemptStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultTable.AttemptStatus
 * JD-Core Version:    0.6.0
 */