package com.facebook.katana.features.uberbar;

import com.facebook.common.util.ErrorReporting;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class UberbarResultFetcher$3
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    if (UberbarResultFetcher.b(this.a));
    while (true)
    {
      return;
      UberbarResultFetcher.a(this.a, paramOperationResult.i());
      UberbarResultFetcher.d(this.a);
    }
  }

  public void a(Throwable paramThrowable)
  {
    if (UberbarResultFetcher.b(this.a));
    while (true)
    {
      return;
      UberbarResultFetcher.a(this.a, UberbarResultFetcher.c());
      UberbarResultFetcher.d(this.a);
      ErrorReporting.a(UberbarResultFetcher.d(), "Remote ubersearch failed: ", paramThrowable);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultFetcher.3
 * JD-Core Version:    0.6.0
 */