package com.facebook.katana.features.uberbar;

import com.facebook.common.util.ErrorReporting;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class UberbarResultFetcher$4
  implements FutureCallback<List<UberbarResult>>
{
  public void a(Throwable paramThrowable)
  {
    UberbarResultFetcher.e(this.b).b(new UberbarResultFetcher.4.2(this, paramThrowable));
  }

  public void a(List<UberbarResult> paramList)
  {
    if (UberbarResultFetcher.b(this.b))
      return;
    switch (UberbarResultFetcher.5.a[this.a.ordinal()])
    {
    default:
      ErrorReporting.a(UberbarResultFetcher.d(), "Unsupported search type found in creating future.");
    case 1:
    case 2:
    }
    while (true)
    {
      UberbarResultFetcher.e(this.b).b(new UberbarResultFetcher.4.1(this));
      break;
      UberbarResultFetcher.b(this.b, paramList);
      continue;
      UberbarResultFetcher.c(this.b, paramList);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultFetcher.4
 * JD-Core Version:    0.6.0
 */