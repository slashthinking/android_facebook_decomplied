package com.google.common.base;

final class Platform$1 extends ThreadLocal<char[]>
{
  protected char[] initialValue()
  {
    return new char[1024];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Platform.1
 * JD-Core Version:    0.6.2
 */