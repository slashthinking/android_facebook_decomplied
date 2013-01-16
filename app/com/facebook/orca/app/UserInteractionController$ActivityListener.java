package com.facebook.orca.app;

import com.facebook.orca.activity.AbstractFbActivityListener;

public class UserInteractionController$ActivityListener extends AbstractFbActivityListener
{
  public UserInteractionController$ActivityListener(UserInteractionController paramUserInteractionController)
  {
  }

  // ERROR //
  public void c(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/facebook/orca/app/UserInteractionController$ActivityListener:a	Lcom/facebook/orca/app/UserInteractionController;
    //   4: invokestatic 21	com/facebook/orca/app/UserInteractionController:b	(Lcom/facebook/orca/app/UserInteractionController;)Ljava/lang/Object;
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 10	com/facebook/orca/app/UserInteractionController$ActivityListener:a	Lcom/facebook/orca/app/UserInteractionController;
    //   14: invokestatic 24	com/facebook/orca/app/UserInteractionController:c	(Lcom/facebook/orca/app/UserInteractionController;)Ljava/util/WeakHashMap;
    //   17: invokevirtual 30	java/util/WeakHashMap:keySet	()Ljava/util/Set;
    //   20: invokeinterface 36 1 0
    //   25: astore 4
    //   27: aload 4
    //   29: invokeinterface 42 1 0
    //   34: ifeq +74 -> 108
    //   37: aload 4
    //   39: invokeinterface 46 1 0
    //   44: checkcast 48	android/view/View
    //   47: astore 5
    //   49: aload 5
    //   51: invokevirtual 52	android/view/View:getContext	()Landroid/content/Context;
    //   54: aload_1
    //   55: if_acmpne -28 -> 27
    //   58: ldc 54
    //   60: new 56	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   67: ldc 59
    //   69: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 5
    //   74: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: ldc 68
    //   79: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 70
    //   84: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 79	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: invokeinterface 82 1 0
    //   100: goto -73 -> 27
    //   103: astore_3
    //   104: aload_2
    //   105: monitorexit
    //   106: aload_3
    //   107: athrow
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 10	com/facebook/orca/app/UserInteractionController$ActivityListener:a	Lcom/facebook/orca/app/UserInteractionController;
    //   114: invokestatic 84	com/facebook/orca/app/UserInteractionController:a	(Lcom/facebook/orca/app/UserInteractionController;)V
    //   117: return
    //
    // Exception table:
    //   from	to	target	type
    //   10	106	103	finally
    //   108	110	103	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.UserInteractionController.ActivityListener
 * JD-Core Version:    0.6.0
 */