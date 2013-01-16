package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$SmsContentResolverHandlerProvider extends AbstractProvider<SmsContentResolverHandler>
{
  private MmsSmsModule$SmsContentResolverHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public SmsContentResolverHandler a()
  {
    return new SmsContentResolverHandler(MmsSmsModule.a(this.a), (MmsSmsUserUtils)b(MmsSmsUserUtils.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.SmsContentResolverHandlerProvider
 * JD-Core Version:    0.6.0
 */