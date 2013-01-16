package com.facebook.orca.sms;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.common.WakeLockHolder;

public class MmsTransactionStateReceiverWakeLockHolder extends WakeLockHolder
{
  public MmsTransactionStateReceiverWakeLockHolder(OrcaWakeLockManager paramOrcaWakeLockManager)
  {
    super(paramOrcaWakeLockManager, "MMS_TRANSACTION_STATE_LIB");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsTransactionStateReceiverWakeLockHolder
 * JD-Core Version:    0.6.0
 */