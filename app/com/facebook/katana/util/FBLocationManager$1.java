package com.facebook.katana.util;

final class FBLocationManager$1
  implements Runnable
{
  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: ldc 13
    //   2: monitorenter
    //   3: getstatic 17	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   6: invokevirtual 22	com/facebook/katana/util/ReentrantCallback:a	()Ljava/util/Set;
    //   9: invokeinterface 28 1 0
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface 34 1 0
    //   21: ifeq +26 -> 47
    //   24: aload_2
    //   25: invokeinterface 38 1 0
    //   30: checkcast 40	com/facebook/katana/util/FBLocationManager$FBLocationListener
    //   33: invokeinterface 43 1 0
    //   38: goto -23 -> 15
    //   41: astore_1
    //   42: ldc 13
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: getstatic 47	com/facebook/katana/util/FBLocationManager:b	Lcom/facebook/katana/util/FBLocationManager$LocationDispatcher;
    //   50: iconst_1
    //   51: putfield 52	com/facebook/katana/util/FBLocationManager$LocationDispatcher:b	Z
    //   54: aconst_null
    //   55: putstatic 56	com/facebook/katana/util/FBLocationManager:d	Ljava/lang/Runnable;
    //   58: ldc 13
    //   60: monitorexit
    //   61: return
    //
    // Exception table:
    //   from	to	target	type
    //   3	45	41	finally
    //   47	61	41	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FBLocationManager.1
 * JD-Core Version:    0.6.0
 */