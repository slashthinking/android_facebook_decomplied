package com.facebook.contacts.data;

public enum DbInsertContactHandler$InsertionType
{
  static
  {
    INSERT = new InsertionType("INSERT", 1);
    InsertionType[] arrayOfInsertionType = new InsertionType[2];
    arrayOfInsertionType[0] = REPLACE_ALL;
    arrayOfInsertionType[1] = INSERT;
    $VALUES = arrayOfInsertionType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.DbInsertContactHandler.InsertionType
 * JD-Core Version:    0.6.0
 */