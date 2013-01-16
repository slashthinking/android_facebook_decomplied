package com.facebook.orca.phone.module;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.phone.TelephonyReceiverWakeLockHolder;

class PhoneModule$TelephonyReceiverWakeLockHolderProvider extends AbstractProvider<TelephonyReceiverWakeLockHolder>
{
  private PhoneModule$TelephonyReceiverWakeLockHolderProvider(PhoneModule paramPhoneModule)
  {
  }

  public TelephonyReceiverWakeLockHolder a()
  {
    return new TelephonyReceiverWakeLockHolder((OrcaWakeLockManager)b(OrcaWakeLockManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.module.PhoneModule.TelephonyReceiverWakeLockHolderProvider
 * JD-Core Version:    0.6.0
 */