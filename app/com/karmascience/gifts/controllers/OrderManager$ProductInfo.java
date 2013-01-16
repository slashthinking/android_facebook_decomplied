package com.karmascience.gifts.controllers;

import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;

public class OrderManager$ProductInfo
{
  public Product a;
  public Sku b;

  public ProductInfo a()
  {
    ProductInfo localProductInfo = new ProductInfo();
    localProductInfo.a = this.a;
    localProductInfo.b = this.b;
    return localProductInfo;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager.ProductInfo
 * JD-Core Version:    0.6.0
 */