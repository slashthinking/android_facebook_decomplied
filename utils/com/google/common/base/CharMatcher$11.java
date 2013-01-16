package com.google.common.base;

import java.util.Arrays;

final class CharMatcher$11 extends CharMatcher
{
  CharMatcher$11(char[] paramArrayOfChar)
  {
  }

  public boolean matches(char paramChar)
  {
    if (Arrays.binarySearch(this.val$chars, paramChar) >= 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    char[] arrayOfChar = this.val$chars;
    int i = arrayOfChar.length;
    for (int j = 0; j < i; j++)
      paramLookupTable.set(arrayOfChar[j]);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.11
 * JD-Core Version:    0.6.2
 */