package com.facebook.feed.db;

public enum NewsFeedUserDataCleaner$StoreType
{
  static
  {
    Disk = new StoreType("Disk", 1);
    StoreType[] arrayOfStoreType = new StoreType[2];
    arrayOfStoreType[0] = Memory;
    arrayOfStoreType[1] = Disk;
    $VALUES = arrayOfStoreType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedUserDataCleaner.StoreType
 * JD-Core Version:    0.6.0
 */