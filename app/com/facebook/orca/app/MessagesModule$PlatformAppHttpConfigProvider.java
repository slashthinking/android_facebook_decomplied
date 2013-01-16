package com.facebook.orca.app;

import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$PlatformAppHttpConfigProvider extends AbstractProvider<PlatformAppHttpConfig>
{
  private MessagesModule$PlatformAppHttpConfigProvider(MessagesModule paramMessagesModule)
  {
  }

  public PlatformAppHttpConfig a()
  {
    return ((OrcaConfig)b(OrcaConfig.class)).f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PlatformAppHttpConfigProvider
 * JD-Core Version:    0.6.0
 */