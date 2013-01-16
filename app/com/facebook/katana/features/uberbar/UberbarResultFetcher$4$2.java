package com.facebook.katana.features.uberbar;

import com.facebook.common.util.ErrorReporting;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;

class UberbarResultFetcher$4$2
  implements Runnable
{
  public void run()
  {
    if (UberbarResultFetcher.b(this.b.b))
      return;
    switch (UberbarResultFetcher.5.a[this.b.a.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      UberbarResultFetcher.d(this.b.b);
      ErrorReporting.a(UberbarResultFetcher.d(), "Local " + this.b.a.name() + " search failed: ", this.a);
      break;
      UberbarResultFetcher.b(this.b.b, UberbarResultFetcher.c());
      continue;
      UberbarResultFetcher.c(this.b.b, UberbarResultFetcher.c());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultFetcher.4.2
 * JD-Core Version:    0.6.0
 */