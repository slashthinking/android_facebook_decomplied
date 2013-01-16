package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsSmsFetchThreadHandlerProvider extends AbstractProvider<MmsSmsFetchThreadHandler>
{
  private MmsSmsModule$MmsSmsFetchThreadHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsFetchThreadHandler a()
  {
    return new MmsSmsFetchThreadHandler((MmsSmsContentResolverHandler)b(MmsSmsContentResolverHandler.class), (MmsSmsUserUtils)b(MmsSmsUserUtils.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsFetchThreadHandlerProvider
 * JD-Core Version:    0.6.0
 */