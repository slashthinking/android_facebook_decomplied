package com.facebook.orca.common.async;

import java.util.concurrent.atomic.AtomicInteger;

final class KeyedExecutor$1 extends ThreadLocal<AtomicInteger>
{
  protected AtomicInteger a()
  {
    return new AtomicInteger(0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.KeyedExecutor.1
 * JD-Core Version:    0.6.0
 */