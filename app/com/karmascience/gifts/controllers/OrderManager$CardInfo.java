package com.karmascience.gifts.controllers;

import com.karmascience.gifts.content.model.CardCategory;
import com.karmascience.gifts.content.model.CardFront;

public class OrderManager$CardInfo
{
  public CardFront a;
  public CardCategory b;
  public String c;
  public String d;
  public String e;
  public String f;

  public CardInfo a()
  {
    CardInfo localCardInfo = new CardInfo();
    localCardInfo.a(this.c, this.d, this.e, this.f);
    localCardInfo.a(this.a, this.b);
    return localCardInfo;
  }

  void a(CardFront paramCardFront, CardCategory paramCardCategory)
  {
    this.a = paramCardFront;
    this.b = paramCardCategory;
  }

  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager.CardInfo
 * JD-Core Version:    0.6.0
 */