package com.facebook.orca.sms;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsReceiverWakeLockHolderProvider extends AbstractProvider<MmsReceiverWakeLockHolder>
{
  private MmsSmsModule$MmsReceiverWakeLockHolderProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsReceiverWakeLockHolder a()
  {
    return new MmsReceiverWakeLockHolder((OrcaWakeLockManager)b(OrcaWakeLockManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsReceiverWakeLockHolderProvider
 * JD-Core Version:    0.6.0
 */