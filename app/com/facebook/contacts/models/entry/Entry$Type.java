package com.facebook.contacts.models.entry;

public enum Entry$Type
{
  static
  {
    EMAIL = new Type("EMAIL", 1);
    ADDRESS = new Type("ADDRESS", 2);
    DEFAULT = new Type("DEFAULT", 3);
    Type[] arrayOfType = new Type[4];
    arrayOfType[0] = PHONE_NUMBER;
    arrayOfType[1] = EMAIL;
    arrayOfType[2] = ADDRESS;
    arrayOfType[3] = DEFAULT;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.entry.Entry.Type
 * JD-Core Version:    0.6.0
 */