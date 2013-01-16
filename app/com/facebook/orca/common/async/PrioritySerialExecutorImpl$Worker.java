package com.facebook.orca.common.async;

class PrioritySerialExecutorImpl$Worker
  implements Runnable
{
  private PrioritySerialExecutorImpl$Worker(PrioritySerialExecutorImpl paramPrioritySerialExecutorImpl)
  {
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   4: invokestatic 24	com/facebook/orca/common/async/PrioritySerialExecutorImpl:a	(Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;)Ljava/lang/Runnable;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnull +10 -> 21
    //   14: aload 5
    //   16: invokeinterface 26 1 0
    //   21: aload_0
    //   22: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   25: astore 6
    //   27: aload 6
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   34: invokevirtual 29	com/facebook/orca/common/async/PrioritySerialExecutorImpl:a	()Z
    //   37: ifeq +16 -> 53
    //   40: aload_0
    //   41: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   44: iconst_0
    //   45: invokestatic 32	com/facebook/orca/common/async/PrioritySerialExecutorImpl:a	(Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;Z)Z
    //   48: pop
    //   49: aload 6
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   57: invokestatic 36	com/facebook/orca/common/async/PrioritySerialExecutorImpl:b	(Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;)Ljava/util/concurrent/Executor;
    //   60: aload_0
    //   61: invokeinterface 42 2 0
    //   66: goto -17 -> 49
    //   69: astore 7
    //   71: aload 6
    //   73: monitorexit
    //   74: aload 7
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   82: astore_2
    //   83: aload_2
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   89: invokevirtual 29	com/facebook/orca/common/async/PrioritySerialExecutorImpl:a	()Z
    //   92: ifeq +16 -> 108
    //   95: aload_0
    //   96: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   99: iconst_0
    //   100: invokestatic 32	com/facebook/orca/common/async/PrioritySerialExecutorImpl:a	(Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;Z)Z
    //   103: pop
    //   104: aload_2
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: aload_0
    //   109: getfield 12	com/facebook/orca/common/async/PrioritySerialExecutorImpl$Worker:a	Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;
    //   112: invokestatic 36	com/facebook/orca/common/async/PrioritySerialExecutorImpl:b	(Lcom/facebook/orca/common/async/PrioritySerialExecutorImpl;)Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: invokeinterface 42 2 0
    //   121: goto -17 -> 104
    //   124: astore_3
    //   125: aload_2
    //   126: monitorexit
    //   127: aload_3
    //   128: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   30	74	69	finally
    //   0	21	77	finally
    //   85	106	124	finally
    //   108	127	124	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.PrioritySerialExecutorImpl.Worker
 * JD-Core Version:    0.6.0
 */