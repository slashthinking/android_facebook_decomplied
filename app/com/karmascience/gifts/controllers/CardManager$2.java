package com.karmascience.gifts.controllers;

import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;
import com.karmascience.gifts.content.model.CardFronts;

class CardManager$2 extends GraphPOJOApiMethod<CardFronts>
{
  public void a(CardFronts paramCardFronts)
  {
    if (this.a != null)
      this.a.a(paramCardFronts);
  }

  public void b(int paramInt, String paramString)
  {
    if ((this.a != null) && (this.a.a(paramInt, paramString)))
      this.e.a(this.b, this.c, this.d, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.CardManager.2
 * JD-Core Version:    0.6.0
 */