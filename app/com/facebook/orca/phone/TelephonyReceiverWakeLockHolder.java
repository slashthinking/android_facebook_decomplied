package com.facebook.orca.phone;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.common.WakeLockHolder;

public class TelephonyReceiverWakeLockHolder extends WakeLockHolder
{
  public TelephonyReceiverWakeLockHolder(OrcaWakeLockManager paramOrcaWakeLockManager)
  {
    super(paramOrcaWakeLockManager, 268435482, "TELEPHONY_LIB");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.TelephonyReceiverWakeLockHolder
 * JD-Core Version:    0.6.0
 */