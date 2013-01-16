package com.facebook.analytics.performance;

import android.app.Activity;

class PerformanceLogger$1 extends Thread
{
  PerformanceLogger$1(PerformanceLogger paramPerformanceLogger, Activity paramActivity)
  {
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/facebook/analytics/performance/PerformanceLogger$1:b	Lcom/facebook/analytics/performance/PerformanceLogger;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 12	com/facebook/analytics/performance/PerformanceLogger$1:b	Lcom/facebook/analytics/performance/PerformanceLogger;
    //   11: invokestatic 23	com/facebook/analytics/performance/PerformanceLogger:a	(Lcom/facebook/analytics/performance/PerformanceLogger;)Ljava/util/concurrent/ConcurrentMap;
    //   14: invokeinterface 29 1 0
    //   19: invokeinterface 35 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 41 1 0
    //   31: ifeq +39 -> 70
    //   34: aload_3
    //   35: invokeinterface 45 1 0
    //   40: checkcast 47	com/facebook/analytics/performance/PerformanceLogger$PerformanceMarker
    //   43: aload_0
    //   44: getfield 14	com/facebook/analytics/performance/PerformanceLogger$1:a	Landroid/app/Activity;
    //   47: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: invokevirtual 56	com/facebook/analytics/performance/PerformanceLogger$PerformanceMarker:a	(Ljava/lang/Class;)Z
    //   53: ifne -28 -> 25
    //   56: aload_3
    //   57: invokeinterface 59 1 0
    //   62: goto -37 -> 25
    //   65: astore_2
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    //   70: aload_1
    //   71: monitorexit
    //   72: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	68	65	finally
    //   70	72	65	finally
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.PerformanceLogger.1
 * JD-Core Version:    0.6.2
 */