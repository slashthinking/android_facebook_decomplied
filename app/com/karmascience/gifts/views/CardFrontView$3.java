package com.karmascience.gifts.views;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.karmascience.gifts.content.model.CardFronts;
import com.karmascience.gifts.controllers.CardManager.GraphQLCardFrontsRequestListener;

class CardFrontView$3
  implements CardManager.GraphQLCardFrontsRequestListener
{
  public void a(CardFronts paramCardFronts)
  {
    if (this == CardFrontView.d(this.a))
    {
      CardFrontView.CardAdapter localCardAdapter = new CardFrontView.CardAdapter(this.a, paramCardFronts);
      CardFrontView.e(this.a).setAdapter(localCardAdapter);
      CardFrontView.f(this.a).setVisibility(8);
    }
  }

  public boolean a(int paramInt, String paramString)
  {
    if (this == CardFrontView.d(this.a))
      this.a.a(paramInt, paramString);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CardFrontView.3
 * JD-Core Version:    0.6.0
 */