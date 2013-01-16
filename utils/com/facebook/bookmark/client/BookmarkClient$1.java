package com.facebook.bookmark.client;

import com.facebook.orca.ops.ServiceException;

class BookmarkClient$1
  implements Runnable
{
  BookmarkClient$1(BookmarkClient paramBookmarkClient, ServiceException paramServiceException)
  {
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/facebook/bookmark/client/BookmarkClient$1:b	Lcom/facebook/bookmark/client/BookmarkClient;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 14	com/facebook/bookmark/client/BookmarkClient$1:b	Lcom/facebook/bookmark/client/BookmarkClient;
    //   11: invokestatic 25	com/facebook/bookmark/client/BookmarkClient:a	(Lcom/facebook/bookmark/client/BookmarkClient;)Ljava/util/Set;
    //   14: invokeinterface 31 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 37 1 0
    //   26: ifeq +29 -> 55
    //   29: aload_3
    //   30: invokeinterface 41 1 0
    //   35: checkcast 43	com/facebook/bookmark/BookmarkManager$BookmarkCallback
    //   38: aload_0
    //   39: getfield 16	com/facebook/bookmark/client/BookmarkClient$1:a	Lcom/facebook/orca/ops/ServiceException;
    //   42: invokeinterface 46 2 0
    //   47: goto -27 -> 20
    //   50: astore_2
    //   51: aload_1
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    //   55: aload_1
    //   56: monitorexit
    //   57: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	53	50	finally
    //   55	57	50	finally
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClient.1
 * JD-Core Version:    0.6.2
 */