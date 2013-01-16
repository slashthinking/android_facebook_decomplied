package com.karmascience.gifts.views;

import android.app.Activity;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.AddressSaveResult;
import com.karmascience.gifts.controllers.OrderManager.SaveNewSenderAddressListener;

class AlcoholInfoEntryView$1
  implements OrderManager.SaveNewSenderAddressListener
{
  public void a(int paramInt, String paramString)
  {
    if (this.a.l())
    {
      this.a.n().c("Address Save Failed").a();
      this.a.a(paramInt, this.a.g().getString(2131362238));
      this.a.u();
    }
  }

  public void a(AddressSaveResult paramAddressSaveResult)
  {
    this.a.u();
    AlcoholInfoEntryView.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.AlcoholInfoEntryView.1
 * JD-Core Version:    0.6.0
 */