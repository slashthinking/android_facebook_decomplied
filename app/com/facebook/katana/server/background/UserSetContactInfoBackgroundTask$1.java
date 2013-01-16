package com.facebook.katana.server.background;

import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.orca.server.OperationResult;

class UserSetContactInfoBackgroundTask$1 extends SimpleBackgroundResultFutureCallback
{
  private void c()
  {
    UserSetContactInfoBackgroundTask.a(this.b, null);
  }

  public void a(OperationResult paramOperationResult)
  {
    GrowthUtils.a().a(UserSetContactInfoBackgroundTask.a(this.b), this.a);
    c();
    super.a(paramOperationResult);
  }

  public void a(Throwable paramThrowable)
  {
    c();
    super.a(paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.background.UserSetContactInfoBackgroundTask.1
 * JD-Core Version:    0.6.0
 */