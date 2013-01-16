package com.facebook.app;

public enum Product
{
  static
  {
    FB4A = new Product("FB4A", 1);
    PAA = new Product("PAA", 2);
    UNKNOWN = new Product("UNKNOWN", 3);
    Product[] arrayOfProduct = new Product[4];
    arrayOfProduct[0] = MESSENGER;
    arrayOfProduct[1] = FB4A;
    arrayOfProduct[2] = PAA;
    arrayOfProduct[3] = UNKNOWN;
    $VALUES = arrayOfProduct;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.Product
 * JD-Core Version:    0.6.0
 */