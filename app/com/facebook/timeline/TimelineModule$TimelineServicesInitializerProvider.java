package com.facebook.timeline;

import com.facebook.feed.module.TimelineServicesInitializer;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceRegistry;

class TimelineModule$TimelineServicesInitializerProvider extends AbstractProvider<TimelineServicesInitializer>
{
  private TimelineModule$TimelineServicesInitializerProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineServicesInitializer a()
  {
    return new TimelineServicesInitializer((OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineServicesInitializerProvider
 * JD-Core Version:    0.6.0
 */