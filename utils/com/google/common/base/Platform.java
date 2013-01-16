package com.google.common.base;

final class Platform
{
  private static final ThreadLocal<char[]> DEST_TL = new Platform.1();

  static CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher)
  {
    return paramCharMatcher.precomputedInternal();
  }

  static long systemNanoTime()
  {
    return System.nanoTime();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Platform
 * JD-Core Version:    0.6.2
 */