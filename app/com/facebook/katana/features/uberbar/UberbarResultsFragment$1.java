package com.facebook.katana.features.uberbar;

import com.facebook.ipc.data.uberbar.UberbarResult;
import java.util.List;

class UberbarResultsFragment$1
  implements UberbarResultFetcher.UberbarResultFetcherListener
{
  public void a(List<UberbarResult> paramList, boolean paramBoolean)
  {
    UberbarResultsFragment localUberbarResultsFragment = this.a;
    if (paramBoolean);
    for (UberSearchResultsAdapter.FetchStatus localFetchStatus = UberSearchResultsAdapter.FetchStatus.COMPLETED; ; localFetchStatus = UberSearchResultsAdapter.FetchStatus.ONGOING)
    {
      UberbarResultsFragment.a(localUberbarResultsFragment, paramList, localFetchStatus);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultsFragment.1
 * JD-Core Version:    0.6.0
 */