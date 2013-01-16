package com.facebook.bugreporter;

import android.app.Activity;
import com.google.common.util.concurrent.FutureCallback;

class BugReporter$2
  implements FutureCallback<BugReport>
{
  public void a(BugReport paramBugReport)
  {
    BugReporter.a(this.b, this.a, paramBugReport);
  }

  public void a(Throwable paramThrowable)
  {
    BugReporter.a(this.b, paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporter.2
 * JD-Core Version:    0.6.0
 */