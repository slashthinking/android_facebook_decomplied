package com.facebook.orca.app;

import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchAppConfigMethod;

class MessagesModule$FetchAppConfigMethodProvider extends AbstractProvider<FetchAppConfigMethod>
{
  private MessagesModule$FetchAppConfigMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchAppConfigMethod a()
  {
    return new FetchAppConfigMethod((OrcaAppType)b(OrcaAppType.class), (AppConfigSerialization)b(AppConfigSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchAppConfigMethodProvider
 * JD-Core Version:    0.6.0
 */