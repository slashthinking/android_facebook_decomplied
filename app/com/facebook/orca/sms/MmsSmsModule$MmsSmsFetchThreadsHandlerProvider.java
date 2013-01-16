package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsSmsFetchThreadsHandlerProvider extends AbstractProvider<MmsSmsFetchThreadsHandler>
{
  private MmsSmsModule$MmsSmsFetchThreadsHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsFetchThreadsHandler a()
  {
    return new MmsSmsFetchThreadsHandler((MmsSmsContentResolverHandler)b(MmsSmsContentResolverHandler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsFetchThreadsHandlerProvider
 * JD-Core Version:    0.6.0
 */