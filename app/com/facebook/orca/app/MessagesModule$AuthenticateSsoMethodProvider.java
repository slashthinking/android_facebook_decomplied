package com.facebook.orca.app;

import com.facebook.orca.config.PlatformAppConfig;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.AuthenticateSsoMethod;

class MessagesModule$AuthenticateSsoMethodProvider extends AbstractProvider<AuthenticateSsoMethod>
{
  private MessagesModule$AuthenticateSsoMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public AuthenticateSsoMethod a()
  {
    return new AuthenticateSsoMethod((PlatformAppConfig)b(PlatformAppConfig.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AuthenticateSsoMethodProvider
 * JD-Core Version:    0.6.0
 */