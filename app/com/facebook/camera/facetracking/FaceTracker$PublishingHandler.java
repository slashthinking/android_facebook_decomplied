package com.facebook.camera.facetracking;

import android.os.Handler;

class FaceTracker$PublishingHandler extends Handler
{
  private FaceTracker$PublishingHandler(FaceTracker paramFaceTracker)
  {
  }

  // ERROR //
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 24	android/os/Message:what	I
    //   4: tableswitch	default:+24 -> 28, 10:+53->57, 11:+64->68
    //   29: nop
    //   30: iload_3
    //   31: new 31	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   38: ldc 34
    //   40: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 24	android/os/Message:what	I
    //   47: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 50	com/facebook/common/util/Log:a	(Ljava/lang/Class;Ljava/lang/String;)V
    //   56: return
    //   57: aload_0
    //   58: getfield 10	com/facebook/camera/facetracking/FaceTracker$PublishingHandler:a	Lcom/facebook/camera/facetracking/FaceTracker;
    //   61: aconst_null
    //   62: invokestatic 53	com/facebook/camera/facetracking/FaceTracker:a	(Lcom/facebook/camera/facetracking/FaceTracker;Ljava/util/List;)V
    //   65: goto -9 -> 56
    //   68: aload_0
    //   69: monitorenter
    //   70: invokestatic 58	com/google/common/collect/Lists:a	()Ljava/util/ArrayList;
    //   73: astore_3
    //   74: aload_0
    //   75: getfield 10	com/facebook/camera/facetracking/FaceTracker$PublishingHandler:a	Lcom/facebook/camera/facetracking/FaceTracker;
    //   78: invokestatic 61	com/facebook/camera/facetracking/FaceTracker:a	(Lcom/facebook/camera/facetracking/FaceTracker;)Ljava/util/ArrayList;
    //   81: invokevirtual 67	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   84: astore 4
    //   86: aload 4
    //   88: invokeinterface 73 1 0
    //   93: ifeq +29 -> 122
    //   96: aload_3
    //   97: aload 4
    //   99: invokeinterface 77 1 0
    //   104: checkcast 79	com/facebook/camera/facetracking/TrackedFace
    //   107: invokevirtual 83	com/facebook/camera/facetracking/TrackedFace:b	()Lcom/facebook/camera/facetracking/TrackedFace;
    //   110: invokevirtual 87	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: goto -28 -> 86
    //   117: astore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    //   122: aload_3
    //   123: invokestatic 93	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   126: astore 5
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 10	com/facebook/camera/facetracking/FaceTracker$PublishingHandler:a	Lcom/facebook/camera/facetracking/FaceTracker;
    //   134: aload 5
    //   136: invokestatic 53	com/facebook/camera/facetracking/FaceTracker:a	(Lcom/facebook/camera/facetracking/FaceTracker;Ljava/util/List;)V
    //   139: goto -83 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   70	120	117	finally
    //   122	130	117	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.facetracking.FaceTracker.PublishingHandler
 * JD-Core Version:    0.6.0
 */