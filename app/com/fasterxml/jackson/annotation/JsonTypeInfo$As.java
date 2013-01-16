package com.fasterxml.jackson.annotation;

public enum JsonTypeInfo$As
{
  static
  {
    WRAPPER_ARRAY = new As("WRAPPER_ARRAY", 2);
    EXTERNAL_PROPERTY = new As("EXTERNAL_PROPERTY", 3);
    As[] arrayOfAs = new As[4];
    arrayOfAs[0] = PROPERTY;
    arrayOfAs[1] = WRAPPER_OBJECT;
    arrayOfAs[2] = WRAPPER_ARRAY;
    arrayOfAs[3] = EXTERNAL_PROPERTY;
    $VALUES = arrayOfAs;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonTypeInfo.As
 * JD-Core Version:    0.6.0
 */