package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$OrcaActivityBroadcasterProvider extends AbstractProvider<OrcaActivityBroadcaster>
{
  private MessagesModule$OrcaActivityBroadcasterProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaActivityBroadcaster a()
  {
    return new OrcaActivityBroadcaster(MessagesModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaActivityBroadcasterProvider
 * JD-Core Version:    0.6.0
 */