package com.facebook.contacts.server;

public enum UploadBulkContactFieldMatch$ValueType
{
  static
  {
    EMAIL = new ValueType("EMAIL", 1);
    PHONE = new ValueType("PHONE", 2);
    EMAIL_PUBLIC_HASH = new ValueType("EMAIL_PUBLIC_HASH", 3);
    PHONE_PUBLIC_HASH = new ValueType("PHONE_PUBLIC_HASH", 4);
    ValueType[] arrayOfValueType = new ValueType[5];
    arrayOfValueType[0] = NAME;
    arrayOfValueType[1] = EMAIL;
    arrayOfValueType[2] = PHONE;
    arrayOfValueType[3] = EMAIL_PUBLIC_HASH;
    arrayOfValueType[4] = PHONE_PUBLIC_HASH;
    $VALUES = arrayOfValueType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactFieldMatch.ValueType
 * JD-Core Version:    0.6.0
 */