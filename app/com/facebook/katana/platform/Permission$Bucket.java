package com.facebook.katana.platform;

public enum Permission$Bucket
{
  static
  {
    FRIEND_READ_OBJECT = new Bucket("FRIEND_READ_OBJECT", 2);
    WRITE = new Bucket("WRITE", 3);
    MANAGE = new Bucket("MANAGE", 4);
    Bucket[] arrayOfBucket = new Bucket[5];
    arrayOfBucket[0] = UNKNOWN;
    arrayOfBucket[1] = USER_READ_OBJECT;
    arrayOfBucket[2] = FRIEND_READ_OBJECT;
    arrayOfBucket[3] = WRITE;
    arrayOfBucket[4] = MANAGE;
    $VALUES = arrayOfBucket;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.Permission.Bucket
 * JD-Core Version:    0.6.0
 */