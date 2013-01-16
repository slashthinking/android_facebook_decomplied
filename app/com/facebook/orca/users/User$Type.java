package com.facebook.orca.users;

public enum User$Type
{
  static
  {
    ADDRESS_BOOK = new Type("ADDRESS_BOOK", 1);
    PHONE_NUMBER = new Type("PHONE_NUMBER", 2);
    FACEBOOK_OBJECT = new Type("FACEBOOK_OBJECT", 3);
    EMAIL = new Type("EMAIL", 4);
    FACEBOOK_CONTACT = new Type("FACEBOOK_CONTACT", 5);
    Type[] arrayOfType = new Type[6];
    arrayOfType[0] = FACEBOOK;
    arrayOfType[1] = ADDRESS_BOOK;
    arrayOfType[2] = PHONE_NUMBER;
    arrayOfType[3] = FACEBOOK_OBJECT;
    arrayOfType[4] = EMAIL;
    arrayOfType[5] = FACEBOOK_CONTACT;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.User.Type
 * JD-Core Version:    0.6.0
 */