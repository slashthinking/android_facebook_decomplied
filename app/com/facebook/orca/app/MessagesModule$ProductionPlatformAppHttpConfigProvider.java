package com.facebook.orca.app;

import com.facebook.orca.config.OrcaProductionConfig;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$ProductionPlatformAppHttpConfigProvider extends AbstractProvider<PlatformAppHttpConfig>
{
  private MessagesModule$ProductionPlatformAppHttpConfigProvider(MessagesModule paramMessagesModule)
  {
  }

  public PlatformAppHttpConfig a()
  {
    return ((OrcaProductionConfig)b(OrcaProductionConfig.class)).f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ProductionPlatformAppHttpConfigProvider
 * JD-Core Version:    0.6.0
 */