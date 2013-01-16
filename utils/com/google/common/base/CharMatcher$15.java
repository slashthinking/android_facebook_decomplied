package com.google.common.base;

class CharMatcher$15 extends CharMatcher
{
  CharMatcher$15(CharMatcher paramCharMatcher, CharMatcher.LookupTable paramLookupTable)
  {
  }

  public boolean matches(char paramChar)
  {
    return this.val$table.get(paramChar);
  }

  public CharMatcher precomputed()
  {
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.15
 * JD-Core Version:    0.6.2
 */