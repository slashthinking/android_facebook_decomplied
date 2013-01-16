package com.google.common.base;

final class CharMatcher$6 extends CharMatcher
{
  public int indexIn(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() == 0);
    for (int i = -1; ; i = 0)
      return i;
  }

  public boolean matches(char paramChar)
  {
    return true;
  }

  public CharMatcher negate()
  {
    return NONE;
  }

  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    return this;
  }

  public CharMatcher precomputed()
  {
    return this;
  }

  public String removeFrom(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return "";
  }

  public String trimFrom(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return "";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.CharMatcher.6
 * JD-Core Version:    0.6.2
 */