package com.facebook.feed.ui;

import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class ProfileListFragment$3
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    Feedback localFeedback = ((FetchFeedbackResult)paramOperationResult.h()).a;
    ProfileListFragment.a(this.a, localFeedback);
    ProfileListFragment.a(this.a, false);
  }

  public void a(Throwable paramThrowable)
  {
    ProfileListFragment.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ProfileListFragment.3
 * JD-Core Version:    0.6.0
 */