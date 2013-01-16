package com.facebook.orca.app;

import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$AppConfigSerializationProvider extends AbstractProvider<AppConfigSerialization>
{
  private MessagesModule$AppConfigSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public AppConfigSerialization a()
  {
    return new AppConfigSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AppConfigSerializationProvider
 * JD-Core Version:    0.6.0
 */