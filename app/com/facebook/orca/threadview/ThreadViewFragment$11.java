package com.facebook.orca.threadview;

import android.app.Activity;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threadlist.ThreadListActivity;

class ThreadViewFragment$11 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    ThreadViewFragment.b(this.a, null);
    ThreadViewFragment.b(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    ThreadViewFragment.b(this.a, null);
    if ((this.a.n() instanceof ThreadListActivity))
      ThreadViewFragment.a(this.a);
    while (true)
    {
      return;
      ((Activity)this.a.p()).finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment.11
 * JD-Core Version:    0.6.0
 */