package com.facebook.orca.sms;

import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.PickedUserUtils;
import com.facebook.orca.threads.ThreadParticipantUtils;

class MmsSmsModule$MmsSmsSendMessageHandlerProvider extends AbstractProvider<MmsSmsSendMessageHandler>
{
  private MmsSmsModule$MmsSmsSendMessageHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsSendMessageHandler a()
  {
    return new MmsSmsSendMessageHandler((PickedUserUtils)b(PickedUserUtils.class), (ThreadParticipantUtils)b(ThreadParticipantUtils.class), (MmsSmsContentResolverHandler)b(MmsSmsContentResolverHandler.class), (MmsSendMessageHandler)b(MmsSendMessageHandler.class), (SmsSendMessageHandler)b(SmsSendMessageHandler.class), (MmsSmsUserUtils)b(MmsSmsUserUtils.class), (MmsSmsLogger)b(MmsSmsLogger.class), (ReadThreadManager)b(ReadThreadManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsSendMessageHandlerProvider
 * JD-Core Version:    0.6.0
 */