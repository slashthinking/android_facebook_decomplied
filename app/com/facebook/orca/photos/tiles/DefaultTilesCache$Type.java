package com.facebook.orca.photos.tiles;

public enum DefaultTilesCache$Type
{
  static
  {
    THREAD = new Type("THREAD", 1);
    EMAIL = new Type("EMAIL", 2);
    SMS = new Type("SMS", 3);
    Type[] arrayOfType = new Type[4];
    arrayOfType[0] = USER;
    arrayOfType[1] = THREAD;
    arrayOfType[2] = EMAIL;
    arrayOfType[3] = SMS;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.DefaultTilesCache.Type
 * JD-Core Version:    0.6.0
 */