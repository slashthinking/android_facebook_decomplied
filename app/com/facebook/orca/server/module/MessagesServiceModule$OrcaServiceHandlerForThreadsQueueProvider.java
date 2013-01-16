package com.facebook.orca.server.module;

import com.facebook.orca.cache.CacheServiceHandler;
import com.facebook.orca.database.DbServiceHandler;
import com.facebook.orca.dispatch.DispatchServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.merge.MergeServiceHandler;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.facebook.orca.server.PreProcessingServiceHandler;
import com.facebook.orca.server.TerminatingHandler;

class MessagesServiceModule$OrcaServiceHandlerForThreadsQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerForThreadsQueueProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink((OrcaServiceHandler.Filter)b(PreProcessingServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(CacheServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(MergeServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(DbServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(DispatchServiceHandler.class), new TerminatingHandler())))));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerForThreadsQueueProvider
 * JD-Core Version:    0.6.0
 */