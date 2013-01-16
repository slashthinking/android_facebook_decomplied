package android_src.mms.transaction;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.orca.debug.BLog;
import java.io.IOException;
import java.util.ArrayList;

final class TransactionService$ServiceHandler extends Handler
{
  public TransactionService$ServiceHandler(TransactionService paramTransactionService, Looper paramLooper)
  {
    super(paramLooper);
  }

  private String a(int paramInt)
  {
    String str;
    if (paramInt == 0)
      str = "NOTIFICATION_TRANSACTION";
    while (true)
    {
      return str;
      if (paramInt == 1)
      {
        str = "RETRIEVE_TRANSACTION";
        continue;
      }
      if (paramInt == 2)
      {
        str = "SEND_TRANSACTION";
        continue;
      }
      if (paramInt == 3)
      {
        str = "READREC_TRANSACTION";
        continue;
      }
      str = "invalid transaction type";
    }
  }

  private String a(Message paramMessage)
  {
    String str;
    if (paramMessage.what == 100)
      str = "EVENT_QUIT";
    while (true)
    {
      return str;
      if (paramMessage.what == 3)
      {
        str = "EVENT_CONTINUE_MMS_CONNECTIVITY";
        continue;
      }
      if (paramMessage.what == 1)
      {
        str = "EVENT_TRANSACTION_REQUEST";
        continue;
      }
      if (paramMessage.what == 4)
      {
        str = "EVENT_HANDLE_NEXT_PENDING_TRANSACTION";
        continue;
      }
      str = "unknown message.what";
    }
  }

  // ERROR //
  private boolean a(Transaction paramTransaction)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   4: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   14: invokestatic 50	android_src/mms/transaction/TransactionService:c	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   17: invokevirtual 56	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   20: astore 4
    //   22: aload 4
    //   24: invokeinterface 62 1 0
    //   29: ifeq +59 -> 88
    //   32: aload 4
    //   34: invokeinterface 66 1 0
    //   39: checkcast 68	android_src/mms/transaction/Transaction
    //   42: aload_1
    //   43: invokevirtual 70	android_src/mms/transaction/Transaction:a	(Landroid_src/mms/transaction/Transaction;)Z
    //   46: ifeq -24 -> 22
    //   49: iconst_2
    //   50: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   53: ifeq +30 -> 83
    //   56: ldc 78
    //   58: new 80	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   65: ldc 85
    //   67: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 93	android_src/mms/transaction/Transaction:e	()I
    //   74: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_2
    //   84: monitorexit
    //   85: goto +243 -> 328
    //   88: aload_0
    //   89: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   92: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   95: invokevirtual 56	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   98: astore 5
    //   100: aload 5
    //   102: invokeinterface 62 1 0
    //   107: ifeq +64 -> 171
    //   110: aload 5
    //   112: invokeinterface 66 1 0
    //   117: checkcast 68	android_src/mms/transaction/Transaction
    //   120: aload_1
    //   121: invokevirtual 70	android_src/mms/transaction/Transaction:a	(Landroid_src/mms/transaction/Transaction;)Z
    //   124: ifeq -24 -> 100
    //   127: iconst_2
    //   128: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   131: ifeq +30 -> 161
    //   134: ldc 78
    //   136: new 80	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   143: ldc 105
    //   145: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 93	android_src/mms/transaction/Transaction:e	()I
    //   152: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_2
    //   162: monitorexit
    //   163: goto +165 -> 328
    //   166: astore_3
    //   167: aload_2
    //   168: monitorexit
    //   169: aload_3
    //   170: athrow
    //   171: iconst_2
    //   172: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   175: ifeq +10 -> 185
    //   178: ldc 78
    //   180: ldc 107
    //   182: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_0
    //   186: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   189: invokevirtual 109	android_src/mms/transaction/TransactionService:a	()I
    //   192: iconst_1
    //   193: if_icmpne +34 -> 227
    //   196: aload_0
    //   197: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   200: invokestatic 50	android_src/mms/transaction/TransactionService:c	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   203: aload_1
    //   204: invokevirtual 113	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: iconst_2
    //   209: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   212: ifeq +10 -> 222
    //   215: ldc 78
    //   217: ldc 115
    //   219: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_2
    //   223: monitorexit
    //   224: goto +104 -> 328
    //   227: iconst_2
    //   228: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   231: ifeq +27 -> 258
    //   234: ldc 78
    //   236: new 80	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   243: ldc 117
    //   245: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   262: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   265: aload_1
    //   266: invokevirtual 113	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   269: pop
    //   270: aload_2
    //   271: monitorexit
    //   272: aload_0
    //   273: aload_0
    //   274: iconst_3
    //   275: invokevirtual 124	android_src/mms/transaction/TransactionService$ServiceHandler:obtainMessage	(I)Landroid/os/Message;
    //   278: ldc2_w 125
    //   281: invokevirtual 130	android_src/mms/transaction/TransactionService$ServiceHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   284: pop
    //   285: iconst_2
    //   286: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   289: ifeq +27 -> 316
    //   292: ldc 78
    //   294: new 80	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   301: ldc 132
    //   303: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: aload_0
    //   318: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   321: invokevirtual 135	android_src/mms/transaction/Transaction:a	(Landroid_src/mms/transaction/Observer;)V
    //   324: aload_1
    //   325: invokevirtual 137	android_src/mms/transaction/Transaction:a	()V
    //   328: iconst_1
    //   329: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   10	169	166	finally
    //   171	272	166	finally
  }

  public void a(Transaction paramTransaction, TransactionSettings paramTransactionSettings)
  {
    if (BLog.b(2))
      BLog.a("fb-mms:TransactionService", "processPendingTxn: transaction=" + paramTransaction);
    while (true)
    {
      int i;
      synchronized (TransactionService.a(this.a))
      {
        if (TransactionService.c(this.a).size() == 0)
          break label245;
        localTransaction = (Transaction)TransactionService.c(this.a).remove(0);
        i = TransactionService.a(this.a).size();
        if (localTransaction != null)
          if (paramTransactionSettings != null)
            localTransaction.a(paramTransactionSettings);
      }
      while (true)
      {
        try
        {
          int j = localTransaction.e();
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:TransactionService", "processPendingTxn: process " + j);
          if (!a(localTransaction))
            continue;
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:TransactionService", "Started deferred processing of transaction  " + localTransaction);
          return;
          localObject = finally;
          monitorexit;
          throw localObject;
          this.a.stopSelf(j);
          continue;
        }
        catch (IOException localIOException)
        {
          BLog.c("fb-mms:TransactionService", localIOException.getMessage(), localIOException);
          continue;
        }
        if (i != 0)
          continue;
        if (BLog.b(2))
          BLog.a("fb-mms:TransactionService", "processPendingTxn: no more transaction, endMmsConnectivity");
        this.a.b();
      }
      label245: Transaction localTransaction = paramTransaction;
    }
  }

  // ERROR //
  public void handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_2
    //   3: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   6: ifeq +40 -> 46
    //   9: ldc 78
    //   11: new 80	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   18: ldc 179
    //   20: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: ldc 181
    //   29: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial 183	android_src/mms/transaction/TransactionService$ServiceHandler:a	(Landroid/os/Message;)Ljava/lang/String;
    //   37: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_1
    //   47: getfield 31	android/os/Message:what	I
    //   50: lookupswitch	default:+42->92, 1:+205->255, 3:+80->130, 4:+1055->1105, 100:+70->120
    //   93: astore_3
    //   94: new 80	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   101: ldc 185
    //   103: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: getfield 31	android/os/Message:what	I
    //   110: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 188	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: return
    //   120: aload_0
    //   121: invokevirtual 192	android_src/mms/transaction/TransactionService$ServiceHandler:getLooper	()Landroid/os/Looper;
    //   124: invokevirtual 197	android/os/Looper:quit	()V
    //   127: goto -8 -> 119
    //   130: aload_0
    //   131: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   134: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   137: astore 20
    //   139: aload 20
    //   141: monitorenter
    //   142: aload_0
    //   143: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   146: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   149: invokevirtual 200	java/util/ArrayList:isEmpty	()Z
    //   152: ifeq +17 -> 169
    //   155: aload 20
    //   157: monitorexit
    //   158: goto -39 -> 119
    //   161: astore 21
    //   163: aload 20
    //   165: monitorexit
    //   166: aload 21
    //   168: athrow
    //   169: aload 20
    //   171: monitorexit
    //   172: iconst_2
    //   173: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   176: ifeq +10 -> 186
    //   179: ldc 78
    //   181: ldc 202
    //   183: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   190: invokevirtual 109	android_src/mms/transaction/TransactionService:a	()I
    //   193: istore 23
    //   195: iload 23
    //   197: ifeq +48 -> 245
    //   200: ldc 78
    //   202: new 80	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   209: ldc 204
    //   211: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 23
    //   216: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc 206
    //   221: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto -111 -> 119
    //   233: astore 22
    //   235: ldc 78
    //   237: ldc 208
    //   239: invokestatic 188	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -123 -> 119
    //   245: aload_0
    //   246: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   249: invokestatic 211	android_src/mms/transaction/TransactionService:b	(Landroid_src/mms/transaction/TransactionService;)V
    //   252: goto -133 -> 119
    //   255: aload_1
    //   256: getfield 214	android/os/Message:arg1	I
    //   259: istore_3
    //   260: aload_1
    //   261: getfield 218	android/os/Message:obj	Ljava/lang/Object;
    //   264: checkcast 220	android_src/mms/transaction/TransactionBundle
    //   267: astore 13
    //   269: iconst_2
    //   270: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   273: ifeq +44 -> 317
    //   276: ldc 78
    //   278: new 80	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   285: ldc 222
    //   287: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 13
    //   292: invokevirtual 224	android_src/mms/transaction/TransactionBundle:d	()Ljava/lang/String;
    //   295: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 226
    //   300: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 13
    //   305: invokevirtual 228	android_src/mms/transaction/TransactionBundle:e	()Ljava/lang/String;
    //   308: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload 13
    //   319: invokevirtual 224	android_src/mms/transaction/TransactionBundle:d	()Ljava/lang/String;
    //   322: astore 14
    //   324: aload 14
    //   326: ifnull +157 -> 483
    //   329: new 230	android_src/mms/transaction/TransactionSettings
    //   332: dup
    //   333: aload 14
    //   335: aload 13
    //   337: invokevirtual 228	android_src/mms/transaction/TransactionBundle:e	()Ljava/lang/String;
    //   340: aload 13
    //   342: invokevirtual 233	android_src/mms/transaction/TransactionBundle:f	()I
    //   345: invokespecial 236	android_src/mms/transaction/TransactionSettings:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   348: astore 15
    //   350: aload 13
    //   352: invokevirtual 237	android_src/mms/transaction/TransactionBundle:a	()I
    //   355: istore 16
    //   357: iconst_2
    //   358: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   361: ifeq +778 -> 1139
    //   364: ldc 78
    //   366: new 80	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   373: ldc 239
    //   375: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 16
    //   380: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: ldc 241
    //   385: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_0
    //   389: iload 16
    //   391: invokespecial 243	android_src/mms/transaction/TransactionService$ServiceHandler:a	(I)Ljava/lang/String;
    //   394: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: goto +736 -> 1139
    //   406: ldc 78
    //   408: new 80	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   415: ldc 245
    //   417: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: iload_3
    //   421: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 188	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: iconst_0
    //   431: ifne -312 -> 119
    //   434: iconst_2
    //   435: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   438: ifeq +27 -> 465
    //   441: ldc 78
    //   443: new 80	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   450: ldc 247
    //   452: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload_3
    //   456: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   469: invokevirtual 171	android_src/mms/transaction/TransactionService:b	()V
    //   472: aload_0
    //   473: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   476: iload_3
    //   477: invokevirtual 161	android_src/mms/transaction/TransactionService:stopSelf	(I)V
    //   480: goto -361 -> 119
    //   483: new 230	android_src/mms/transaction/TransactionSettings
    //   486: dup
    //   487: aload_0
    //   488: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   491: aconst_null
    //   492: invokespecial 250	android_src/mms/transaction/TransactionSettings:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   495: astore 15
    //   497: goto -147 -> 350
    //   500: aload 13
    //   502: invokevirtual 252	android_src/mms/transaction/TransactionBundle:b	()Ljava/lang/String;
    //   505: astore 18
    //   507: aload 18
    //   509: ifnull +87 -> 596
    //   512: new 254	android_src/mms/transaction/NotificationTransaction
    //   515: dup
    //   516: aload_0
    //   517: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   520: iload_3
    //   521: aload 15
    //   523: aload 18
    //   525: invokespecial 257	android_src/mms/transaction/NotificationTransaction:<init>	(Landroid/content/Context;ILandroid_src/mms/transaction/TransactionSettings;Ljava/lang/String;)V
    //   528: astore 6
    //   530: aload_0
    //   531: aload 6
    //   533: invokespecial 155	android_src/mms/transaction/TransactionService$ServiceHandler:a	(Landroid_src/mms/transaction/Transaction;)Z
    //   536: istore 17
    //   538: iload 17
    //   540: ifne +449 -> 989
    //   543: iconst_0
    //   544: ifne -425 -> 119
    //   547: iconst_2
    //   548: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   551: ifeq +27 -> 578
    //   554: ldc 78
    //   556: new 80	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   563: ldc 247
    //   565: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: iload_3
    //   569: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload_0
    //   579: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   582: invokevirtual 171	android_src/mms/transaction/TransactionService:b	()V
    //   585: aload_0
    //   586: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   589: iload_3
    //   590: invokevirtual 161	android_src/mms/transaction/TransactionService:stopSelf	(I)V
    //   593: goto -474 -> 119
    //   596: new 259	android_src/mms/pdu/PduParser
    //   599: dup
    //   600: aload 13
    //   602: invokevirtual 262	android_src/mms/transaction/TransactionBundle:c	()[B
    //   605: invokespecial 265	android_src/mms/pdu/PduParser:<init>	([B)V
    //   608: invokevirtual 268	android_src/mms/pdu/PduParser:a	()Landroid_src/mms/pdu/GenericPdu;
    //   611: astore 19
    //   613: aload 19
    //   615: ifnull +186 -> 801
    //   618: aload 19
    //   620: invokevirtual 271	android_src/mms/pdu/GenericPdu:f	()I
    //   623: sipush 130
    //   626: if_icmpne +175 -> 801
    //   629: new 254	android_src/mms/transaction/NotificationTransaction
    //   632: dup
    //   633: aload_0
    //   634: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   637: iload_3
    //   638: aload 15
    //   640: aload 19
    //   642: checkcast 273	android_src/mms/pdu/NotificationInd
    //   645: invokespecial 276	android_src/mms/transaction/NotificationTransaction:<init>	(Landroid/content/Context;ILandroid_src/mms/transaction/TransactionSettings;Landroid_src/mms/pdu/NotificationInd;)V
    //   648: astore 6
    //   650: goto -120 -> 530
    //   653: astore 5
    //   655: aconst_null
    //   656: astore 6
    //   658: ldc 78
    //   660: new 80	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 278
    //   670: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_1
    //   674: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: aload 5
    //   682: invokestatic 167	com/facebook/orca/debug/BLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload 6
    //   687: ifnull +446 -> 1133
    //   690: aload 6
    //   692: aload_0
    //   693: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   696: invokevirtual 280	android_src/mms/transaction/Transaction:b	(Landroid_src/mms/transaction/Observer;)V
    //   699: aload_0
    //   700: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   703: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   706: aload 6
    //   708: invokevirtual 283	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   711: istore 9
    //   713: aconst_null
    //   714: astore_2
    //   715: iload 9
    //   717: ifeq +31 -> 748
    //   720: aload_0
    //   721: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   724: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   727: astore 10
    //   729: aload 10
    //   731: monitorenter
    //   732: aload_0
    //   733: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   736: invokestatic 47	android_src/mms/transaction/TransactionService:a	(Landroid_src/mms/transaction/TransactionService;)Ljava/util/ArrayList;
    //   739: aload 6
    //   741: invokevirtual 285	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   744: pop
    //   745: aload 10
    //   747: monitorexit
    //   748: aload_2
    //   749: ifnonnull -630 -> 119
    //   752: iconst_2
    //   753: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   756: ifeq +27 -> 783
    //   759: ldc 78
    //   761: new 80	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   768: ldc 247
    //   770: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: iload_3
    //   774: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   777: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload_0
    //   784: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   787: invokevirtual 171	android_src/mms/transaction/TransactionService:b	()V
    //   790: aload_0
    //   791: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   794: iload_3
    //   795: invokevirtual 161	android_src/mms/transaction/TransactionService:stopSelf	(I)V
    //   798: goto -679 -> 119
    //   801: ldc 78
    //   803: ldc_w 287
    //   806: invokestatic 289	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   809: iconst_0
    //   810: ifne -691 -> 119
    //   813: iconst_2
    //   814: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   817: ifeq +27 -> 844
    //   820: ldc 78
    //   822: new 80	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   829: ldc 247
    //   831: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: iload_3
    //   835: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   838: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   844: aload_0
    //   845: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   848: invokevirtual 171	android_src/mms/transaction/TransactionService:b	()V
    //   851: aload_0
    //   852: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   855: iload_3
    //   856: invokevirtual 161	android_src/mms/transaction/TransactionService:stopSelf	(I)V
    //   859: goto -740 -> 119
    //   862: new 291	android_src/mms/transaction/RetrieveTransaction
    //   865: dup
    //   866: aload_0
    //   867: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   870: iload_3
    //   871: aload 15
    //   873: aload 13
    //   875: invokevirtual 252	android_src/mms/transaction/TransactionBundle:b	()Ljava/lang/String;
    //   878: invokespecial 292	android_src/mms/transaction/RetrieveTransaction:<init>	(Landroid/content/Context;ILandroid_src/mms/transaction/TransactionSettings;Ljava/lang/String;)V
    //   881: astore 6
    //   883: goto -353 -> 530
    //   886: astore 4
    //   888: aload_2
    //   889: ifnonnull +49 -> 938
    //   892: iconst_2
    //   893: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   896: ifeq +27 -> 923
    //   899: ldc 78
    //   901: new 80	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   908: ldc 247
    //   910: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: iload_3
    //   914: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   917: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload_0
    //   924: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   927: invokevirtual 171	android_src/mms/transaction/TransactionService:b	()V
    //   930: aload_0
    //   931: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   934: iload_3
    //   935: invokevirtual 161	android_src/mms/transaction/TransactionService:stopSelf	(I)V
    //   938: aload 4
    //   940: athrow
    //   941: new 294	android_src/mms/transaction/SendTransaction
    //   944: dup
    //   945: aload_0
    //   946: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   949: iload_3
    //   950: aload 15
    //   952: aload 13
    //   954: invokevirtual 252	android_src/mms/transaction/TransactionBundle:b	()Ljava/lang/String;
    //   957: invokespecial 295	android_src/mms/transaction/SendTransaction:<init>	(Landroid/content/Context;ILandroid_src/mms/transaction/TransactionSettings;Ljava/lang/String;)V
    //   960: astore 6
    //   962: goto -432 -> 530
    //   965: new 297	android_src/mms/transaction/ReadRecTransaction
    //   968: dup
    //   969: aload_0
    //   970: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   973: iload_3
    //   974: aload 15
    //   976: aload 13
    //   978: invokevirtual 252	android_src/mms/transaction/TransactionBundle:b	()Ljava/lang/String;
    //   981: invokespecial 298	android_src/mms/transaction/ReadRecTransaction:<init>	(Landroid/content/Context;ILandroid_src/mms/transaction/TransactionSettings;Ljava/lang/String;)V
    //   984: astore 6
    //   986: goto -456 -> 530
    //   989: iconst_2
    //   990: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   993: ifeq +28 -> 1021
    //   996: ldc 78
    //   998: new 80	java/lang/StringBuilder
    //   1001: dup
    //   1002: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1005: ldc_w 300
    //   1008: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload_1
    //   1012: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1021: aload 6
    //   1023: ifnonnull -904 -> 119
    //   1026: iconst_2
    //   1027: invokestatic 76	com/facebook/orca/debug/BLog:b	(I)Z
    //   1030: ifeq +27 -> 1057
    //   1033: ldc 78
    //   1035: new 80	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1042: ldc 247
    //   1044: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: iload_3
    //   1048: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1051: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1054: invokestatic 103	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1057: aload_0
    //   1058: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   1061: invokevirtual 171	android_src/mms/transaction/TransactionService:b	()V
    //   1064: aload_0
    //   1065: getfield 10	android_src/mms/transaction/TransactionService$ServiceHandler:a	Landroid_src/mms/transaction/TransactionService;
    //   1068: iload_3
    //   1069: invokevirtual 161	android_src/mms/transaction/TransactionService:stopSelf	(I)V
    //   1072: goto -953 -> 119
    //   1075: astore 11
    //   1077: aload 10
    //   1079: monitorexit
    //   1080: aload 11
    //   1082: athrow
    //   1083: astore 8
    //   1085: ldc 78
    //   1087: ldc_w 302
    //   1090: aload 8
    //   1092: invokestatic 304	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1095: aconst_null
    //   1096: astore_2
    //   1097: goto -349 -> 748
    //   1100: astore 7
    //   1102: aload 7
    //   1104: athrow
    //   1105: aload_0
    //   1106: aconst_null
    //   1107: aload_1
    //   1108: getfield 218	android/os/Message:obj	Ljava/lang/Object;
    //   1111: checkcast 230	android_src/mms/transaction/TransactionSettings
    //   1114: invokevirtual 306	android_src/mms/transaction/TransactionService$ServiceHandler:a	(Landroid_src/mms/transaction/Transaction;Landroid_src/mms/transaction/TransactionSettings;)V
    //   1117: goto -998 -> 119
    //   1120: astore 4
    //   1122: aload 6
    //   1124: astore_2
    //   1125: goto -237 -> 888
    //   1128: astore 5
    //   1130: goto -472 -> 658
    //   1133: aload 6
    //   1135: astore_2
    //   1136: goto -388 -> 748
    //   1139: iload 16
    //   1141: tableswitch	default:+-735 -> 406, 0:+-641->500, 1:+-279->862, 2:+-200->941, 3:+-176->965
    //
    // Exception table:
    //   from	to	target	type
    //   142	166	161	finally
    //   169	172	161	finally
    //   186	230	233	java/io/IOException
    //   260	430	653	java/lang/Exception
    //   483	530	653	java/lang/Exception
    //   596	650	653	java/lang/Exception
    //   801	809	653	java/lang/Exception
    //   862	883	653	java/lang/Exception
    //   941	986	653	java/lang/Exception
    //   260	430	886	finally
    //   483	530	886	finally
    //   596	650	886	finally
    //   801	809	886	finally
    //   862	883	886	finally
    //   941	986	886	finally
    //   1102	1105	886	finally
    //   732	748	1075	finally
    //   1077	1080	1075	finally
    //   690	732	1083	java/lang/Throwable
    //   1080	1083	1083	java/lang/Throwable
    //   690	732	1100	finally
    //   1080	1083	1100	finally
    //   1085	1095	1100	finally
    //   530	538	1120	finally
    //   658	685	1120	finally
    //   989	1021	1120	finally
    //   530	538	1128	java/lang/Exception
    //   989	1021	1128	java/lang/Exception
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.TransactionService.ServiceHandler
 * JD-Core Version:    0.6.0
 */