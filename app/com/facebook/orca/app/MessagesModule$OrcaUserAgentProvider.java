package com.facebook.orca.app;

import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$OrcaUserAgentProvider extends AbstractProvider<String>
{
  private MessagesModule$OrcaUserAgentProvider(MessagesModule paramMessagesModule)
  {
  }

  public String a()
  {
    return ((OrcaConfig)b(OrcaConfig.class)).e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaUserAgentProvider
 * JD-Core Version:    0.6.0
 */