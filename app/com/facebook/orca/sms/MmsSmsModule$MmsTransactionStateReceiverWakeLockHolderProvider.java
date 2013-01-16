package com.facebook.orca.sms;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsTransactionStateReceiverWakeLockHolderProvider extends AbstractProvider<MmsTransactionStateReceiverWakeLockHolder>
{
  private MmsSmsModule$MmsTransactionStateReceiverWakeLockHolderProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsTransactionStateReceiverWakeLockHolder a()
  {
    return new MmsTransactionStateReceiverWakeLockHolder((OrcaWakeLockManager)b(OrcaWakeLockManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsTransactionStateReceiverWakeLockHolderProvider
 * JD-Core Version:    0.6.0
 */