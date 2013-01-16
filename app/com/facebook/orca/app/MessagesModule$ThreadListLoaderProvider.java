package com.facebook.orca.app;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.threadlist.ThreadListLoader;

class MessagesModule$ThreadListLoaderProvider extends AbstractProvider<ThreadListLoader>
{
  private MessagesModule$ThreadListLoaderProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadListLoader a()
  {
    return new ThreadListLoader((DataCache)b(DataCache.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadListLoaderProvider
 * JD-Core Version:    0.6.0
 */