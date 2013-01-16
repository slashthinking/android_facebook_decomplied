package com.facebook.katana.features.uberbar;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.ipc.data.uberbar.UberbarResult;
import java.util.List;

class UberbarResultsFragment$5
  implements UberbarResultView.CommunicationButtonListener
{
  public void a(UberbarResult paramUberbarResult)
  {
    String str = paramUberbarResult.a();
    if (str != null)
    {
      List localList = UberbarResultsFragment.b(this.a).a();
      UberbarResultsFragment.d(this.a).b(paramUberbarResult, UberbarResultsFragment.c(this.a), localList);
      UberbarResultsFragment.b(this.a.n(), "tel:" + str);
    }
    while (true)
    {
      return;
      UberbarResultsFragment.e(this.a).a("NullPointerException", "Ubersearch: Tried calling a person with no phone numbers");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultsFragment.5
 * JD-Core Version:    0.6.0
 */