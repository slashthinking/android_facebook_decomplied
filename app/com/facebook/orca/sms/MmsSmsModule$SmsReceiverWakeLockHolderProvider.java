package com.facebook.orca.sms;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$SmsReceiverWakeLockHolderProvider extends AbstractProvider<SmsReceiverWakeLockHolder>
{
  private MmsSmsModule$SmsReceiverWakeLockHolderProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public SmsReceiverWakeLockHolder a()
  {
    return new SmsReceiverWakeLockHolder((OrcaWakeLockManager)b(OrcaWakeLockManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.SmsReceiverWakeLockHolderProvider
 * JD-Core Version:    0.6.0
 */