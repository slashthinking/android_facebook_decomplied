package com.google.common.base;

final class CharMatcher$9 extends CharMatcher
{
  CharMatcher$9(char paramChar)
  {
  }

  public boolean matches(char paramChar)
  {
    if (paramChar != this.val$match);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public CharMatcher negate()
  {
    return is(this.val$match);
  }

  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    if (paramCharMatcher.matches(this.val$match))
      this = ANY;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.9
 * JD-Core Version:    0.6.2
 */