package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.threadlist.MeOnlinePresenceManager;

class MessagesModule$MeOnlinePresenceManagerProvider extends AbstractProvider<MeOnlinePresenceManager>
{
  private MessagesModule$MeOnlinePresenceManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public MeOnlinePresenceManager a()
  {
    return new MeOnlinePresenceManager(a(OrcaServiceOperation.class, FromApplication.class), (DataCache)b(DataCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MeOnlinePresenceManagerProvider
 * JD-Core Version:    0.6.0
 */