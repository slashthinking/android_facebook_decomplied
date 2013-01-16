package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.ArchiveThreadManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;

class MessagesModule$ArchiveThreadManagerProvider extends AbstractProvider<ArchiveThreadManager>
{
  private MessagesModule$ArchiveThreadManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ArchiveThreadManager a()
  {
    return new ArchiveThreadManager((OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), a(OrcaServiceOperation.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ArchiveThreadManagerProvider
 * JD-Core Version:    0.6.0
 */