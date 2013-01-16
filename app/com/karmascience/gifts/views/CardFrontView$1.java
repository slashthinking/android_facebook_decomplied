package com.karmascience.gifts.views;

import android.view.View;
import com.karmascience.gifts.content.model.CardCategories;
import com.karmascience.gifts.content.model.CardCategory;
import com.karmascience.gifts.controllers.CardManager.GraphQLCardCategoriesRequestListener;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.CardInfo;

class CardFrontView$1
  implements CardManager.GraphQLCardCategoriesRequestListener
{
  public void a(CardCategories paramCardCategories)
  {
    this.a.setVisibility(0);
    if (CardFrontView.a(this.c))
      this.b.findViewById(2131296480).setVisibility(4);
    CardFrontView.a(this.c, paramCardCategories);
    CardFrontView.b(this.c, CardFrontView.b(this.c));
    OrderManager.CardInfo localCardInfo = this.c.p().f();
    if ((localCardInfo.b != null) && (localCardInfo.a != null))
    {
      CardCategory localCardCategory = CardFrontView.b(this.c).a(localCardInfo.b.a());
      CardFrontView.a(this.c, localCardCategory);
    }
    while (true)
    {
      return;
      CardFrontView.a(this.c, CardFrontView.b(this.c).a(0));
    }
  }

  public boolean a(int paramInt, String paramString)
  {
    if (this.c.l())
      this.c.a(paramInt, paramString);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CardFrontView.1
 * JD-Core Version:    0.6.0
 */