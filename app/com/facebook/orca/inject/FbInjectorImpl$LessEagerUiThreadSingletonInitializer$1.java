package com.facebook.orca.inject;

import android.os.MessageQueue.IdleHandler;
import com.facebook.orca.debug.Tracer;
import com.google.inject.Key;
import java.util.Iterator;
import java.util.Set;

class FbInjectorImpl$LessEagerUiThreadSingletonInitializer$1
  implements MessageQueue.IdleHandler
{
  public boolean queueIdle()
  {
    long l = System.currentTimeMillis();
    Tracer localTracer = Tracer.a("LessEagerUiThreadSingletonInitializer");
    Iterator localIterator = FbInjectorImpl.a(this.a.a).iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      Key localKey = (Key)localIterator.next();
      this.a.a.a(localKey);
      localIterator.remove();
    }
    while (System.currentTimeMillis() - l <= 50L);
    localTracer.a();
    return localIterator.hasNext();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.FbInjectorImpl.LessEagerUiThreadSingletonInitializer.1
 * JD-Core Version:    0.6.0
 */