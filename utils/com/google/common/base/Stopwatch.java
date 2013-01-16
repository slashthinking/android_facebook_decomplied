package com.google.common.base;

import java.util.concurrent.TimeUnit;

public final class Stopwatch
{
  private long elapsedNanos;
  private boolean isRunning;
  private long startTick;
  private final Ticker ticker;

  public Stopwatch()
  {
    this(Ticker.systemTicker());
  }

  public Stopwatch(Ticker paramTicker)
  {
    this.ticker = ((Ticker)Preconditions.checkNotNull(paramTicker));
  }

  private static String abbreviate(TimeUnit paramTimeUnit)
  {
    String str;
    switch (Stopwatch.1.$SwitchMap$java$util$concurrent$TimeUnit[paramTimeUnit.ordinal()])
    {
    default:
      throw new AssertionError();
    case 1:
      str = "ns";
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return str;
      str = "μs";
      continue;
      str = "ms";
      continue;
      str = "s";
    }
  }

  private static TimeUnit chooseUnit(long paramLong)
  {
    TimeUnit localTimeUnit;
    if (TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L)
      localTimeUnit = TimeUnit.SECONDS;
    while (true)
    {
      return localTimeUnit;
      if (TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L)
        localTimeUnit = TimeUnit.MILLISECONDS;
      else if (TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L)
        localTimeUnit = TimeUnit.MICROSECONDS;
      else
        localTimeUnit = TimeUnit.NANOSECONDS;
    }
  }

  private long elapsedNanos()
  {
    if (this.isRunning);
    for (long l = this.ticker.read() - this.startTick + this.elapsedNanos; ; l = this.elapsedNanos)
      return l;
  }

  public long elapsedMillis()
  {
    return elapsedTime(TimeUnit.MILLISECONDS);
  }

  public long elapsedTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
  }

  public boolean isRunning()
  {
    return this.isRunning;
  }

  public Stopwatch reset()
  {
    this.elapsedNanos = 0L;
    this.isRunning = false;
    return this;
  }

  public Stopwatch start()
  {
    if (!this.isRunning);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.isRunning = true;
      this.startTick = this.ticker.read();
      return this;
    }
  }

  public String toString()
  {
    return toString(4);
  }

  public String toString(int paramInt)
  {
    long l = elapsedNanos();
    TimeUnit localTimeUnit = chooseUnit(l);
    double d = l / TimeUnit.NANOSECONDS.convert(1L, localTimeUnit);
    String str = "%." + paramInt + "g %s";
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Double.valueOf(d);
    arrayOfObject[1] = abbreviate(localTimeUnit);
    return String.format(str, arrayOfObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Stopwatch
 * JD-Core Version:    0.6.2
 */