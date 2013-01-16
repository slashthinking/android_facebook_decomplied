package com.karmascience.gifts.views;

import com.facebook.graphql.model.GraphQLMailingAddresses;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.controllers.OrderManager.SenderMailingAddressesListener;

class AlcoholInfoEntryView$4
  implements OrderManager.SenderMailingAddressesListener
{
  public void a(int paramInt, String paramString)
  {
    if (this.a.l())
    {
      this.a.n().c("Address Fetch Failed").a();
      this.a.a(paramInt, paramString);
      this.a.b(CommonViewUtils.c(null));
    }
  }

  public void a(GraphQLMailingAddresses paramGraphQLMailingAddresses)
  {
    if (this.a.l())
    {
      AlcoholInfoEntryView.c(this.a);
      this.a.a(paramGraphQLMailingAddresses);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.AlcoholInfoEntryView.4
 * JD-Core Version:    0.6.0
 */