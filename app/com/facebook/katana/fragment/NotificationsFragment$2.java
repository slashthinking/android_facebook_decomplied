package com.facebook.katana.fragment;

import com.facebook.katana.util.StringUtils;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class NotificationsFragment$2
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    NotificationsFragment.e(this.a);
    if (!paramOperationResult.c())
    {
      String str = StringUtils.a(this.a.n(), this.a.e(2131363017), paramOperationResult.d().ordinal(), paramOperationResult.e(), null);
      BLog.e(NotificationsFragment.i, str);
    }
  }

  public void a(Throwable paramThrowable)
  {
    NotificationsFragment.e(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.NotificationsFragment.2
 * JD-Core Version:    0.6.0
 */