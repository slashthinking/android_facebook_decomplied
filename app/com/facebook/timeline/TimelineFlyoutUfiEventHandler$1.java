package com.facebook.timeline;

import com.facebook.feed.util.event.UfiEvents.FeedbackUpdatedEvent;
import com.facebook.feed.util.event.UfiEvents.FeedbackUpdatedEventSubscriber;

class TimelineFlyoutUfiEventHandler$1 extends UfiEvents.FeedbackUpdatedEventSubscriber
{
  public void a(UfiEvents.FeedbackUpdatedEvent paramFeedbackUpdatedEvent)
  {
    TimelineFlyoutUfiEventHandler.a(this.a, null);
    if ((paramFeedbackUpdatedEvent != null) && (paramFeedbackUpdatedEvent.a != null))
      TimelineFlyoutUfiEventHandler.a(this.a, paramFeedbackUpdatedEvent.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFlyoutUfiEventHandler.1
 * JD-Core Version:    0.6.0
 */