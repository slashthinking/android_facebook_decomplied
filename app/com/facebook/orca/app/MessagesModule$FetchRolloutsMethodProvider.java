package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchRolloutsMethod;
import com.facebook.orca.rollout.OrcaRolloutManager;

class MessagesModule$FetchRolloutsMethodProvider extends AbstractProvider<FetchRolloutsMethod>
{
  private MessagesModule$FetchRolloutsMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchRolloutsMethod a()
  {
    return new FetchRolloutsMethod((OrcaRolloutManager)b(OrcaRolloutManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchRolloutsMethodProvider
 * JD-Core Version:    0.6.0
 */