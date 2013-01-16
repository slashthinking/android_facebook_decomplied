package com.karmascience.gifts.controllers;

import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;
import com.karmascience.gifts.content.model.CardCategories;

class CardManager$1 extends GraphPOJOApiMethod<CardCategories>
{
  public void a(CardCategories paramCardCategories)
  {
    CardManager.a(this.b, paramCardCategories);
    if (this.a != null)
      this.a.a(CardManager.a(this.b));
  }

  public void b(int paramInt, String paramString)
  {
    if ((this.a != null) && (this.a.a(paramInt, paramString)))
      this.b.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.CardManager.1
 * JD-Core Version:    0.6.0
 */