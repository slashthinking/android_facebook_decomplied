package com.google.common.base;

final class CharMatcher$8 extends CharMatcher
{
  CharMatcher$8(char paramChar)
  {
  }

  public boolean matches(char paramChar)
  {
    if (paramChar == this.val$match);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public CharMatcher negate()
  {
    return isNot(this.val$match);
  }

  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    if (paramCharMatcher.matches(this.val$match));
    while (true)
    {
      return paramCharMatcher;
      paramCharMatcher = super.or(paramCharMatcher);
    }
  }

  public CharMatcher precomputed()
  {
    return this;
  }

  void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    paramLookupTable.set(this.val$match);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.8
 * JD-Core Version:    0.6.2
 */