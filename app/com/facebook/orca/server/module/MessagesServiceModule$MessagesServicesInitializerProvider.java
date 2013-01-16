package com.facebook.orca.server.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceRegistry;

class MessagesServiceModule$MessagesServicesInitializerProvider extends AbstractProvider<MessagesServicesInitializer>
{
  private MessagesServiceModule$MessagesServicesInitializerProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public MessagesServicesInitializer a()
  {
    return new MessagesServicesInitializer((OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.MessagesServicesInitializerProvider
 * JD-Core Version:    0.6.0
 */