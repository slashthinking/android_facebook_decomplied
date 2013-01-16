package com.karmascience.gifts.controllers;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.AsyncMethodRunner;
import com.karmascience.gifts.content.model.CardCategories;
import com.karmascience.gifts.content.model.CardFronts;

public class CardManager
{
  private static final String a = CardManager.class.getSimpleName();
  private final ThreadingService b;
  private final AsyncMethodRunner c;
  private CardCategories d;

  public CardManager(AsyncMethodRunner paramAsyncMethodRunner, ThreadingService paramThreadingService)
  {
    this.b = paramThreadingService;
    this.c = paramAsyncMethodRunner;
  }

  public void a(CardManager.GraphQLCardCategoriesRequestListener paramGraphQLCardCategoriesRequestListener)
  {
    if (this.d != null)
      if (paramGraphQLCardCategoriesRequestListener != null)
        paramGraphQLCardCategoriesRequestListener.a(this.d);
    while (true)
    {
      return;
      CardManager.1 local1 = new CardManager.1(this, "GetCardCategories", this.b, 2, CardCategories.class, paramGraphQLCardCategoriesRequestListener);
      this.c.a(local1, "node(295377273895016){gift_card_categories{nodes{id,name}}}");
    }
  }

  public void a(String paramString, int paramInt1, int paramInt2, CardManager.GraphQLCardFrontsRequestListener paramGraphQLCardFrontsRequestListener)
  {
    CardManager.2 local2 = new CardManager.2(this, "GetCardFronts", this.b, 2, CardFronts.class, paramGraphQLCardFrontsRequestListener, paramString, paramInt1, paramInt2);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.toString(paramInt1);
    arrayOfObject[2] = Integer.toString(paramInt2);
    String str = StringLocaleUtil.a("node(%s) {gift_card_templates{nodes{background_color, closings, id, image.size(%s,%s), name, default_message}}}", arrayOfObject);
    this.c.a(local2, str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.CardManager
 * JD-Core Version:    0.6.0
 */