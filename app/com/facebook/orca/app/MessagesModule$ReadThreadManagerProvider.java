package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;

class MessagesModule$ReadThreadManagerProvider extends AbstractProvider<ReadThreadManager>
{
  private MessagesModule$ReadThreadManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ReadThreadManager a()
  {
    return new ReadThreadManager((OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), a(OrcaServiceOperation.class, FromApplication.class), (ThreadsCache)b(ThreadsCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ReadThreadManagerProvider
 * JD-Core Version:    0.6.0
 */