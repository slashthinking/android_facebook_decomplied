package com.facebook.orca.app;

import com.facebook.orca.common.util.OfflineThreadingIdGenerator;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$OfflineThreadingIdGeneratorProvider extends AbstractProvider<OfflineThreadingIdGenerator>
{
  private MessagesModule$OfflineThreadingIdGeneratorProvider(MessagesModule paramMessagesModule)
  {
  }

  public OfflineThreadingIdGenerator a()
  {
    return new OfflineThreadingIdGenerator();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OfflineThreadingIdGeneratorProvider
 * JD-Core Version:    0.6.0
 */