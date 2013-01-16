package com.google.common.base;

final class CharMatcher$10 extends CharMatcher
{
  CharMatcher$10(char paramChar1, char paramChar2)
  {
  }

  public boolean matches(char paramChar)
  {
    if ((paramChar == this.val$match1) || (paramChar == this.val$match2));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public CharMatcher precomputed()
  {
    return this;
  }

  void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    paramLookupTable.set(this.val$match1);
    paramLookupTable.set(this.val$match2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.10
 * JD-Core Version:    0.6.2
 */