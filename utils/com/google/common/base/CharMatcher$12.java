package com.google.common.base;

final class CharMatcher$12 extends CharMatcher
{
  CharMatcher$12(char paramChar1, char paramChar2)
  {
  }

  public boolean matches(char paramChar)
  {
    if ((this.val$startInclusive <= paramChar) && (paramChar <= this.val$endInclusive));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public CharMatcher precomputed()
  {
    return this;
  }

  void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    char c2;
    for (char c1 = this.val$startInclusive; ; c1 = c2)
    {
      paramLookupTable.set(c1);
      c2 = (char)(c1 + '\001');
      if (c1 == this.val$endInclusive)
        return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.12
 * JD-Core Version:    0.6.2
 */