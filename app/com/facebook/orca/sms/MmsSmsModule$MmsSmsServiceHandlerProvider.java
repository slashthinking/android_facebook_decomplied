package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MmsSmsModule$MmsSmsServiceHandlerProvider extends AbstractProvider<MmsSmsServiceHandler>
{
  private MmsSmsModule$MmsSmsServiceHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsServiceHandler a()
  {
    return new MmsSmsServiceHandler((MmsSmsFetchThreadsHandler)b(MmsSmsFetchThreadsHandler.class), (MmsSmsFetchThreadHandler)b(MmsSmsFetchThreadHandler.class), (MmsSmsSendMessageHandler)b(MmsSmsSendMessageHandler.class), (MmsSmsContentResolverHandler)b(MmsSmsContentResolverHandler.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (MmsSmsLogger)b(MmsSmsLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */