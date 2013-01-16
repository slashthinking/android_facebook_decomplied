package com.facebook.timeline;

import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.orca.inject.AbstractProvider;

class TimelineModule$TimelineSectionPreRenderProcessFilterProvider extends AbstractProvider<TimelineSectionPreRenderProcessFilter>
{
  private TimelineModule$TimelineSectionPreRenderProcessFilterProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineSectionPreRenderProcessFilter a()
  {
    return new TimelineSectionPreRenderProcessFilter((FeedLinkifyUtil)b(FeedLinkifyUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineSectionPreRenderProcessFilterProvider
 * JD-Core Version:    0.6.0
 */