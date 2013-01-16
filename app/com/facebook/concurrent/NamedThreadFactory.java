package com.facebook.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
  implements ThreadFactory
{
  private final String a;
  private final int b;
  private final AtomicInteger c;

  public NamedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }

  public NamedThreadFactory(String paramString, int paramInt)
  {
    this.c = new AtomicInteger(i);
    if ((paramInt <= 19) && (paramInt >= -19));
    while (true)
    {
      Preconditions.checkArgument(i);
      this.a = paramString;
      this.b = paramInt;
      return;
      int j = 0;
    }
  }

  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(new NamedThreadFactory.1(this, paramRunnable), this.a + this.c.getAndIncrement());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.concurrent.NamedThreadFactory
 * JD-Core Version:    0.6.0
 */