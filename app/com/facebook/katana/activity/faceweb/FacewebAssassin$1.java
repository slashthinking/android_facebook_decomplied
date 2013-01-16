package com.facebook.katana.activity.faceweb;

final class FacewebAssassin$1
  implements Runnable
{
  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: invokestatic 17	com/facebook/katana/activity/faceweb/FacewebAssassin:c	()Ljava/util/List;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iconst_m1
    //   7: invokestatic 17	com/facebook/katana/activity/faceweb/FacewebAssassin:c	()Ljava/util/List;
    //   10: invokeinterface 23 1 0
    //   15: iadd
    //   16: istore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: iload_3
    //   21: iflt +35 -> 56
    //   24: invokestatic 17	com/facebook/katana/activity/faceweb/FacewebAssassin:c	()Ljava/util/List;
    //   27: iload_3
    //   28: invokeinterface 27 2 0
    //   33: checkcast 29	com/facebook/katana/activity/faceweb/FacewebAssassin$FacewebFragmentRecord
    //   36: getfield 33	com/facebook/katana/activity/faceweb/FacewebAssassin$FacewebFragmentRecord:a	Ljava/lang/ref/WeakReference;
    //   39: invokevirtual 38	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   42: checkcast 40	com/facebook/katana/activity/faceweb/FacewebFragment
    //   45: astore 7
    //   47: aload 7
    //   49: ifnull +85 -> 134
    //   52: aload 7
    //   54: astore 4
    //   56: invokestatic 17	com/facebook/katana/activity/faceweb/FacewebAssassin:c	()Ljava/util/List;
    //   59: invokeinterface 44 1 0
    //   64: astore 5
    //   66: aload 5
    //   68: invokeinterface 50 1 0
    //   73: ifeq +67 -> 140
    //   76: aload 5
    //   78: invokeinterface 53 1 0
    //   83: checkcast 29	com/facebook/katana/activity/faceweb/FacewebAssassin$FacewebFragmentRecord
    //   86: getfield 33	com/facebook/katana/activity/faceweb/FacewebAssassin$FacewebFragmentRecord:a	Ljava/lang/ref/WeakReference;
    //   89: invokevirtual 38	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   92: checkcast 40	com/facebook/katana/activity/faceweb/FacewebFragment
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +10 -> 109
    //   102: aload 6
    //   104: aload 4
    //   106: if_acmpeq -40 -> 66
    //   109: aload 5
    //   111: invokeinterface 56 1 0
    //   116: aload 6
    //   118: ifnull -52 -> 66
    //   121: aload 6
    //   123: invokevirtual 59	com/facebook/katana/activity/faceweb/FacewebFragment:L	()V
    //   126: goto -60 -> 66
    //   129: astore_2
    //   130: aload_1
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    //   134: iinc 3 255
    //   137: goto -120 -> 17
    //   140: aload_1
    //   141: monitorexit
    //   142: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	132	129	finally
    //   140	142	129	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebAssassin.1
 * JD-Core Version:    0.6.0
 */