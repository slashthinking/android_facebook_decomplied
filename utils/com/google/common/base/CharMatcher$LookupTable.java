package com.google.common.base;

final class CharMatcher$LookupTable
{
  int[] data = new int[2048];

  boolean get(char paramChar)
  {
    char c = '\001';
    if ((this.data[(paramChar >> '\005')] & c << paramChar) != 0);
    while (true)
    {
      return c;
      c = '\000';
    }
  }

  void set(char paramChar)
  {
    int[] arrayOfInt = this.data;
    int i = paramChar >> '\005';
    arrayOfInt[i] |= '\001' << paramChar;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.LookupTable
 * JD-Core Version:    0.6.2
 */