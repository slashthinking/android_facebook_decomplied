package com.facebook.orca.sms;

import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$SmsSendMessageHandlerProvider extends AbstractProvider<SmsSendMessageHandler>
{
  private MmsSmsModule$SmsSendMessageHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public SmsSendMessageHandler a()
  {
    return new SmsSendMessageHandler(MmsSmsModule.a(this.a), (SmsContentResolverHandler)b(SmsContentResolverHandler.class), (MmsSmsLogger)b(MmsSmsLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.SmsSendMessageHandlerProvider
 * JD-Core Version:    0.6.0
 */