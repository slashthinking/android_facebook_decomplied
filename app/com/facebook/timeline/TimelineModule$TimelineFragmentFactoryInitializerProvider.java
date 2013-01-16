package com.facebook.timeline;

import com.facebook.orca.inject.AbstractProvider;

class TimelineModule$TimelineFragmentFactoryInitializerProvider extends AbstractProvider<TimelineFragmentFactoryInitializer>
{
  private TimelineModule$TimelineFragmentFactoryInitializerProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineFragmentFactoryInitializer a()
  {
    return new TimelineFragmentFactoryInitializer(TimelineModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineFragmentFactoryInitializerProvider
 * JD-Core Version:    0.6.0
 */