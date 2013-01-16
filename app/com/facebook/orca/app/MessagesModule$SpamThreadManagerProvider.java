package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.SpamThreadManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;

class MessagesModule$SpamThreadManagerProvider extends AbstractProvider<SpamThreadManager>
{
  private MessagesModule$SpamThreadManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public SpamThreadManager a()
  {
    return new SpamThreadManager((OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), a(OrcaServiceOperation.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SpamThreadManagerProvider
 * JD-Core Version:    0.6.0
 */