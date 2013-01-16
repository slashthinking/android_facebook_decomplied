package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$CallLogContentResolverHandlerProvider extends AbstractProvider<CallLogContentResolverHandler>
{
  private MmsSmsModule$CallLogContentResolverHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public CallLogContentResolverHandler a()
  {
    return new CallLogContentResolverHandler(MmsSmsModule.a(this.a), (MmsSmsUserUtils)b(MmsSmsUserUtils.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.CallLogContentResolverHandlerProvider
 * JD-Core Version:    0.6.0
 */