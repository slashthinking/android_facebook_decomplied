package com.facebook.katana.service.method;

public enum MarkJewelSeen$Jewel
{
  static
  {
    FRIEND_REQUESTS = new Jewel("FRIEND_REQUESTS", 1);
    NOTIFICATIONS = new Jewel("NOTIFICATIONS", 2);
    Jewel[] arrayOfJewel = new Jewel[3];
    arrayOfJewel[0] = INBOX;
    arrayOfJewel[1] = FRIEND_REQUESTS;
    arrayOfJewel[2] = NOTIFICATIONS;
    $VALUES = arrayOfJewel;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MarkJewelSeen.Jewel
 * JD-Core Version:    0.6.0
 */