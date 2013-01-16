package com.facebook.timeline;

import com.facebook.feed.protocol.TimelineServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.facebook.timeline.cache.db.TimelineDbCacheServiceHandler;
import com.facebook.timeline.cache.ram.TimelineCacheServiceHandler;

class TimelineModule$OrcaServiceHandlerForTimelineQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private TimelineModule$OrcaServiceHandlerForTimelineQueueProvider(TimelineModule paramTimelineModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink((OrcaServiceHandler.Filter)b(TimelineCacheServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(TimelineSectionPreRenderProcessFilter.class), new FilterChainLink((OrcaServiceHandler.Filter)b(TimelineDbCacheServiceHandler.class), (OrcaServiceHandler)b(TimelineServiceHandler.class))));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.OrcaServiceHandlerForTimelineQueueProvider
 * JD-Core Version:    0.6.0
 */