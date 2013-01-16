package com.facebook.timeline;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackableGraphQLNode;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class TimelineFragment$7 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    TimelineFragment.d(this.c).a(this.a, this.b);
    TimelineFragment.e(this.c).i();
    TimelineFragment.f(this.c).a("timeline_story_like_fail", paramServiceException.getMessage(), false);
  }

  public void a(OperationResult paramOperationResult)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment.7
 * JD-Core Version:    0.6.0
 */