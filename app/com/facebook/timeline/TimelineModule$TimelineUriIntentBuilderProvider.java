package com.facebook.timeline;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.timeline.annotations.IsNativeTimelineEnabled;

class TimelineModule$TimelineUriIntentBuilderProvider extends AbstractProvider<TimelineUriIntentBuilder>
{
  private TimelineModule$TimelineUriIntentBuilderProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineUriIntentBuilder a()
  {
    return new TimelineUriIntentBuilder(a(Boolean.class, IsNativeTimelineEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineUriIntentBuilderProvider
 * JD-Core Version:    0.6.0
 */