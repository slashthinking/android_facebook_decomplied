package com.google.common.base;

final class CharMatcher$7 extends CharMatcher
{
  public int indexIn(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return -1;
  }

  public boolean matches(char paramChar)
  {
    return false;
  }

  public CharMatcher negate()
  {
    return ANY;
  }

  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    return (CharMatcher)Preconditions.checkNotNull(paramCharMatcher);
  }

  public CharMatcher precomputed()
  {
    return this;
  }

  public String removeFrom(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }

  void setBits(CharMatcher.LookupTable paramLookupTable)
  {
  }

  public String trimFrom(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.7
 * JD-Core Version:    0.6.2
 */