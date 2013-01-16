package com.facebook.katana.binding;

import android.content.Context;

class StreamPhotosCache$1
  implements Runnable
{
  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/facebook/katana/binding/StreamPhotosCache$1:b	Lcom/facebook/katana/binding/StreamPhotosCache;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 14	com/facebook/katana/binding/StreamPhotosCache$1:b	Lcom/facebook/katana/binding/StreamPhotosCache;
    //   11: invokestatic 25	com/facebook/katana/binding/StreamPhotosCache:a	(Lcom/facebook/katana/binding/StreamPhotosCache;)Ljava/util/Map;
    //   14: aload_0
    //   15: getfield 16	com/facebook/katana/binding/StreamPhotosCache$1:a	Landroid/content/Context;
    //   18: invokestatic 28	com/facebook/katana/binding/StreamPhotosCache:a	(Landroid/content/Context;)Ljava/util/Map;
    //   21: invokeinterface 34 2 0
    //   26: aload_0
    //   27: getfield 14	com/facebook/katana/binding/StreamPhotosCache$1:b	Lcom/facebook/katana/binding/StreamPhotosCache;
    //   30: lconst_0
    //   31: invokestatic 37	com/facebook/katana/binding/StreamPhotosCache:a	(Lcom/facebook/katana/binding/StreamPhotosCache;J)J
    //   34: pop2
    //   35: aload_0
    //   36: getfield 14	com/facebook/katana/binding/StreamPhotosCache$1:b	Lcom/facebook/katana/binding/StreamPhotosCache;
    //   39: invokestatic 25	com/facebook/katana/binding/StreamPhotosCache:a	(Lcom/facebook/katana/binding/StreamPhotosCache;)Ljava/util/Map;
    //   42: invokeinterface 41 1 0
    //   47: invokeinterface 47 1 0
    //   52: astore 5
    //   54: aload 5
    //   56: invokeinterface 53 1 0
    //   61: ifeq +32 -> 93
    //   64: aload_0
    //   65: getfield 14	com/facebook/katana/binding/StreamPhotosCache$1:b	Lcom/facebook/katana/binding/StreamPhotosCache;
    //   68: aload 5
    //   70: invokeinterface 57 1 0
    //   75: checkcast 59	com/facebook/katana/binding/StreamPhoto
    //   78: invokevirtual 63	com/facebook/katana/binding/StreamPhoto:d	()J
    //   81: invokestatic 65	com/facebook/katana/binding/StreamPhotosCache:b	(Lcom/facebook/katana/binding/StreamPhotosCache;J)J
    //   84: pop2
    //   85: goto -31 -> 54
    //   88: astore_2
    //   89: aload_1
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    //   93: aload_1
    //   94: monitorexit
    //   95: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	91	88	finally
    //   93	95	88	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.StreamPhotosCache.1
 * JD-Core Version:    0.6.0
 */