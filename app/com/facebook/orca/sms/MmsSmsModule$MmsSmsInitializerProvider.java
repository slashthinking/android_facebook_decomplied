package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsSmsInitializerProvider extends AbstractProvider<MmsSmsInitializer>
{
  private MmsSmsModule$MmsSmsInitializerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsInitializer a()
  {
    return new MmsSmsInitializer(MmsSmsModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsInitializerProvider
 * JD-Core Version:    0.6.0
 */