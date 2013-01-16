package com.karmascience.gifts.controllers;

import android.net.Uri;
import com.facebook.graphql.model.GraphQLBirthdate;
import com.facebook.graphql.model.GraphQLMailingAddresses;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.AsyncMethodRunner;
import com.karmascience.gifts.content.model.AddressSaveResult;
import com.karmascience.gifts.content.model.CardCategory;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.views.AlcoholInfoEntryView.AddressHolder;

public class OrderManager
{
  private static final String a = OrderManager.class.getName();
  private final AsyncMethodRunner b;
  private OrderManager.Order c;
  private boolean d;

  public OrderManager(AsyncMethodRunner paramAsyncMethodRunner)
  {
    this.b = paramAsyncMethodRunner;
    a();
  }

  public void a()
  {
    this.c = new OrderManager.Order(this);
  }

  public void a(CardFront paramCardFront, CardCategory paramCardCategory)
  {
    OrderManager.Order.d(this.c).a(paramCardFront, paramCardCategory);
  }

  public void a(Product paramProduct, Sku paramSku)
  {
    OrderManager.Order.a(this.c).a = paramProduct;
    OrderManager.Order.a(this.c).b = paramSku;
  }

  public void a(OrderManager.OrderSubmissionListener paramOrderSubmissionListener, ThreadingService paramThreadingService)
  {
    if (this.d);
    while (true)
    {
      return;
      OrderManager.5 local5 = new OrderManager.5(this, b(), d(), f(), c(), paramThreadingService, OrderManager.Gift.class, paramOrderSubmissionListener, paramThreadingService);
      this.d = true;
      this.b.a(local5, null);
    }
  }

  public void a(OrderManager.SaveNewSenderAddressListener paramSaveNewSenderAddressListener, AlcoholInfoEntryView.AddressHolder paramAddressHolder, ThreadingService paramThreadingService)
  {
    OrderManager.4 local4 = new OrderManager.4(this, "SaveNewSenderAddress", paramThreadingService, 0, AddressSaveResult.class, "POST", "me/mailing_addresses", paramAddressHolder, paramSaveNewSenderAddressListener);
    this.b.a(local4, null);
  }

  public void a(OrderManager.SenderMailingAddressesListener paramSenderMailingAddressesListener, ThreadingService paramThreadingService)
  {
    OrderManager.3 local3 = new OrderManager.3(this, "GetSenderAddress", paramThreadingService, 2, GraphQLMailingAddresses.class, paramSenderMailingAddressesListener);
    this.b.a(local3, "me(){mailing_addresses{nodes{address{full_address},id}}}");
  }

  public void a(OrderManager.UserInfoListener paramUserInfoListener, ThreadingService paramThreadingService)
  {
    String str1 = OrderManager.Order.b(this.c).a;
    OrderManager.1 local1 = new OrderManager.1(this, "GetRecipientInfo", paramThreadingService, 1, OrderManager.BasicUser.class, str1, paramUserInfoListener);
    String str2 = StringLocaleUtil.a("node(%s){id, name, pic_square, birthdate{year, month, day}}", new Object[] { str1 });
    this.b.a(local1, str2);
  }

  public void a(String paramString1, Uri paramUri, String paramString2, GraphQLBirthdate paramGraphQLBirthdate)
  {
    OrderManager.Order.b(this.c).a(paramString1, paramString2, paramUri, paramGraphQLBirthdate);
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    OrderManager.Order.d(this.c).a(paramString2, paramString1, paramString3, paramString4);
  }

  public void a(boolean paramBoolean)
  {
    OrderManager.Order.a(this.c, paramBoolean);
  }

  public OrderManager.ProductInfo b()
  {
    return OrderManager.Order.a(this.c).a();
  }

  public void b(OrderManager.UserInfoListener paramUserInfoListener, ThreadingService paramThreadingService)
  {
    OrderManager.2 local2 = new OrderManager.2(this, "GetSenderInfo", paramThreadingService, 1, OrderManager.BasicUser.class, OrderManager.Order.c(this.c).a, paramUserInfoListener);
    this.b.a(local2, "me(){id, name, pic_square, birthdate{year, month, day}}");
  }

  public void b(String paramString1, Uri paramUri, String paramString2, GraphQLBirthdate paramGraphQLBirthdate)
  {
    OrderManager.Order.c(this.c).a(paramString1, paramString2, paramUri, paramGraphQLBirthdate);
  }

  public boolean c()
  {
    return OrderManager.Order.e(this.c);
  }

  public OrderManager.UserInfo d()
  {
    return OrderManager.Order.b(this.c).a();
  }

  public OrderManager.UserInfo e()
  {
    return OrderManager.Order.c(this.c).a();
  }

  public OrderManager.CardInfo f()
  {
    return OrderManager.Order.d(this.c).a();
  }

  public String g()
  {
    if (OrderManager.Order.f(this.c) != null);
    for (String str = OrderManager.Order.f(this.c).id; ; str = null)
      return str;
  }

  public boolean h()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager
 * JD-Core Version:    0.6.0
 */