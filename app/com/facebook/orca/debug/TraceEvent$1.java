package com.facebook.orca.debug;

import com.facebook.orca.common.util.ObjectPool.BasicAllocator;

final class TraceEvent$1 extends ObjectPool.BasicAllocator<TraceEvent>
{
  public void a(TraceEvent paramTraceEvent)
  {
    TraceEvent.a(paramTraceEvent, null);
    TraceEvent.b(paramTraceEvent, null);
  }

  public TraceEvent b()
  {
    return new TraceEvent(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.TraceEvent.1
 * JD-Core Version:    0.6.0
 */