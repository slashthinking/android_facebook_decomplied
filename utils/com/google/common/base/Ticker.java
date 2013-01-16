package com.google.common.base;

public abstract class Ticker
{
  private static final Ticker SYSTEM_TICKER = new Ticker.1();

  public static Ticker systemTicker()
  {
    return SYSTEM_TICKER;
  }

  public abstract long read();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Ticker
 * JD-Core Version:    0.6.2
 */