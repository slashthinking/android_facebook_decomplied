package com.facebook.timeline;

import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class TimelineFlyoutUfiEventHandler$2
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    Feedback localFeedback = ((FetchFeedbackResult)paramOperationResult.h()).a;
    if (localFeedback != null)
      TimelineFlyoutUfiEventHandler.a(this.a, localFeedback);
  }

  public void a(Throwable paramThrowable)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFlyoutUfiEventHandler.2
 * JD-Core Version:    0.6.0
 */