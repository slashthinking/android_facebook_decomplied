package com.facebook.katana.binding;

import android.content.Context;
import com.facebook.katana.util.TraceLogger;
import com.facebook.orca.annotations.FromApplication;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ManagedDataStore<K, V>
  implements NetworkRequestCallback<K, V>
{
  public static int a = 60000;
  protected static int b = 0;
  public static final ExecutorService l = Executors.newSingleThreadExecutor();
  protected final ManagedDataStore.Client<K, V> c;
  protected final ManagedDataStore.Mode d;
  protected final Context e;
  protected final MDSMemoryCache<K, V> f;
  protected MDSDatabaseOperationHandler<K, V> g;
  protected int h;
  protected Map<K, Long> i;
  protected Long j;
  protected TraceLogger k;

  public ManagedDataStore(ManagedDataStore.Client<K, V> paramClient, Context paramContext)
  {
    this(paramClient, ManagedDataStore.Mode.UNRESTRICTED, paramContext);
  }

  public ManagedDataStore(ManagedDataStore.Client<K, V> paramClient, ManagedDataStore.Mode paramMode, @FromApplication Context paramContext)
  {
    this.c = paramClient;
    this.d = paramMode;
    this.e = paramContext.getApplicationContext();
    this.f = new MDSMemoryCache();
    this.g = new MDSDatabaseOperationHandler(paramClient, this.e.getContentResolver());
    if (paramMode == ManagedDataStore.Mode.SINGLE_REQUEST_BY_KEY)
      this.i = new HashMap();
    monitorenter;
    try
    {
      this.h = b;
      monitorexit;
      this.k = new TraceLogger(16384, 128);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void a()
  {
    monitorenter;
    try
    {
      b = 1 + b;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  public V a(K paramK)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 73	com/facebook/katana/binding/ManagedDataStore:e	Landroid/content/Context;
    //   6: invokestatic 112	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_0
    //   11: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   14: new 114	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   21: ldc 117
    //   23: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 124	com/facebook/katana/binding/ManagedDataStore:c	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokevirtual 131	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;)V
    //   40: ldc 2
    //   42: monitorenter
    //   43: aload_0
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 99	com/facebook/katana/binding/ManagedDataStore:h	I
    //   49: getstatic 40	com/facebook/katana/binding/ManagedDataStore:b	I
    //   52: if_icmpeq +17 -> 69
    //   55: aload_0
    //   56: getfield 78	com/facebook/katana/binding/ManagedDataStore:f	Lcom/facebook/katana/binding/MDSMemoryCache;
    //   59: invokevirtual 133	com/facebook/katana/binding/MDSMemoryCache:a	()V
    //   62: aload_0
    //   63: getstatic 40	com/facebook/katana/binding/ManagedDataStore:b	I
    //   66: putfield 99	com/facebook/katana/binding/ManagedDataStore:h	I
    //   69: aload_0
    //   70: monitorexit
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: monitorenter
    //   76: aload_0
    //   77: getfield 78	com/facebook/katana/binding/ManagedDataStore:f	Lcom/facebook/katana/binding/MDSMemoryCache;
    //   80: aload_1
    //   81: invokevirtual 136	com/facebook/katana/binding/MDSMemoryCache:a	(Ljava/lang/Object;)Lcom/facebook/katana/binding/MDSMemoryCache$MemoryStoreEntry;
    //   84: astore 7
    //   86: aconst_null
    //   87: astore 8
    //   89: aload 7
    //   91: ifnull +133 -> 224
    //   94: aload 7
    //   96: getfield 141	com/facebook/katana/binding/MDSMemoryCache$MemoryStoreEntry:a	Ljava/lang/Object;
    //   99: astore 10
    //   101: aload 7
    //   103: getfield 144	com/facebook/katana/binding/MDSMemoryCache$MemoryStoreEntry:b	J
    //   106: ldc2_w 145
    //   109: lcmp
    //   110: ifeq +91 -> 201
    //   113: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   116: aload 7
    //   118: getfield 144	com/facebook/katana/binding/MDSMemoryCache$MemoryStoreEntry:b	J
    //   121: sipush 1000
    //   124: aload_0
    //   125: getfield 63	com/facebook/katana/binding/ManagedDataStore:c	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   128: aload_1
    //   129: aload 7
    //   131: getfield 141	com/facebook/katana/binding/MDSMemoryCache$MemoryStoreEntry:a	Ljava/lang/Object;
    //   134: invokeinterface 158 3 0
    //   139: imul
    //   140: i2l
    //   141: ladd
    //   142: lcmp
    //   143: ifge +58 -> 201
    //   146: aload_0
    //   147: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   150: new 114	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   157: ldc 160
    //   159: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual 124	com/facebook/katana/binding/ManagedDataStore:c	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 162
    //   172: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokevirtual 131	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: monitorexit
    //   183: aload 10
    //   185: areturn
    //   186: astore 5
    //   188: aload_0
    //   189: monitorexit
    //   190: aload 5
    //   192: athrow
    //   193: astore 4
    //   195: ldc 2
    //   197: monitorexit
    //   198: aload 4
    //   200: athrow
    //   201: aload_0
    //   202: getfield 63	com/facebook/katana/binding/ManagedDataStore:c	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   205: aload_1
    //   206: aload 10
    //   208: invokeinterface 166 3 0
    //   213: ifne +599 -> 812
    //   216: aload_0
    //   217: getfield 78	com/facebook/katana/binding/ManagedDataStore:f	Lcom/facebook/katana/binding/MDSMemoryCache;
    //   220: aload_1
    //   221: invokevirtual 169	com/facebook/katana/binding/MDSMemoryCache:b	(Ljava/lang/Object;)V
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_0
    //   227: getfield 89	com/facebook/katana/binding/ManagedDataStore:g	Lcom/facebook/katana/binding/MDSDatabaseOperationHandler;
    //   230: aload_1
    //   231: invokevirtual 172	com/facebook/katana/binding/MDSDatabaseOperationHandler:a	(Ljava/lang/Object;)Lcom/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry;
    //   234: astore 9
    //   236: aload 9
    //   238: ifnull +567 -> 805
    //   241: aload 9
    //   243: getfield 175	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:b	J
    //   246: ldc2_w 145
    //   249: lcmp
    //   250: ifeq +102 -> 352
    //   253: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   256: aload 9
    //   258: getfield 175	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:b	J
    //   261: sipush 1000
    //   264: aload_0
    //   265: getfield 63	com/facebook/katana/binding/ManagedDataStore:c	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   268: aload_1
    //   269: aload 9
    //   271: getfield 176	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:a	Ljava/lang/Object;
    //   274: invokeinterface 179 3 0
    //   279: imul
    //   280: i2l
    //   281: ladd
    //   282: lcmp
    //   283: ifge +69 -> 352
    //   286: aload_0
    //   287: getfield 78	com/facebook/katana/binding/ManagedDataStore:f	Lcom/facebook/katana/binding/MDSMemoryCache;
    //   290: aload_1
    //   291: aload 9
    //   293: getfield 176	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:a	Ljava/lang/Object;
    //   296: aload 9
    //   298: getfield 175	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:b	J
    //   301: invokevirtual 182	com/facebook/katana/binding/MDSMemoryCache:a	(Ljava/lang/Object;Ljava/lang/Object;J)V
    //   304: aload_0
    //   305: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   308: new 114	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   315: ldc 160
    //   317: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: ldc 187
    //   326: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 131	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;)V
    //   335: aload 9
    //   337: getfield 176	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:a	Ljava/lang/Object;
    //   340: astore 10
    //   342: goto -159 -> 183
    //   345: astore 6
    //   347: aload_0
    //   348: monitorexit
    //   349: aload 6
    //   351: athrow
    //   352: aload_0
    //   353: getfield 63	com/facebook/katana/binding/ManagedDataStore:c	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   356: aload_1
    //   357: aload 9
    //   359: getfield 176	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:a	Ljava/lang/Object;
    //   362: invokeinterface 166 3 0
    //   367: ifne +110 -> 477
    //   370: aload_0
    //   371: getfield 89	com/facebook/katana/binding/ManagedDataStore:g	Lcom/facebook/katana/binding/MDSDatabaseOperationHandler;
    //   374: aload_1
    //   375: invokevirtual 188	com/facebook/katana/binding/MDSDatabaseOperationHandler:b	(Ljava/lang/Object;)V
    //   378: aload 8
    //   380: astore 10
    //   382: getstatic 193	com/facebook/katana/binding/ManagedDataStore$3:a	[I
    //   385: aload_0
    //   386: getfield 65	com/facebook/katana/binding/ManagedDataStore:d	Lcom/facebook/katana/binding/ManagedDataStore$Mode;
    //   389: invokevirtual 197	com/facebook/katana/binding/ManagedDataStore$Mode:ordinal	()I
    //   392: iaload
    //   393: tableswitch	default:+27 -> 420, 1:+94->487, 2:+102->495, 3:+232->625
    //   421: istore 12
    //   423: iload_2
    //   424: ifeq +18 -> 442
    //   427: aload_0
    //   428: getfield 63	com/facebook/katana/binding/ManagedDataStore:c	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   431: aload_0
    //   432: getfield 73	com/facebook/katana/binding/ManagedDataStore:e	Landroid/content/Context;
    //   435: aload_1
    //   436: aload_0
    //   437: invokeinterface 201 4 0
    //   442: iload 12
    //   444: ifeq -261 -> 183
    //   447: aload_0
    //   448: getfield 63	com/facebook/katana/binding/ManagedDataStore:c	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   451: invokevirtual 205	java/lang/Object:getClass	()Ljava/lang/Class;
    //   454: invokevirtual 208	java/lang/Class:toString	()Ljava/lang/String;
    //   457: aload_0
    //   458: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   461: invokevirtual 209	com/facebook/katana/util/TraceLogger:toString	()Ljava/lang/String;
    //   464: invokestatic 214	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload_0
    //   468: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   471: invokevirtual 215	com/facebook/katana/util/TraceLogger:a	()V
    //   474: goto -291 -> 183
    //   477: aload 9
    //   479: getfield 176	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:a	Ljava/lang/Object;
    //   482: astore 10
    //   484: goto -102 -> 382
    //   487: iconst_1
    //   488: istore_2
    //   489: iconst_0
    //   490: istore 12
    //   492: goto -69 -> 423
    //   495: aload_0
    //   496: getfield 97	com/facebook/katana/binding/ManagedDataStore:i	Ljava/util/Map;
    //   499: astore 19
    //   501: aload 19
    //   503: monitorenter
    //   504: aload_0
    //   505: getfield 97	com/facebook/katana/binding/ManagedDataStore:i	Ljava/util/Map;
    //   508: aload_1
    //   509: invokeinterface 220 2 0
    //   514: checkcast 222	java/lang/Long
    //   517: astore 21
    //   519: aload 21
    //   521: ifnonnull +43 -> 564
    //   524: iconst_0
    //   525: istore 12
    //   527: iconst_1
    //   528: istore_2
    //   529: iload_2
    //   530: ifeq +20 -> 550
    //   533: aload_0
    //   534: getfield 97	com/facebook/katana/binding/ManagedDataStore:i	Ljava/util/Map;
    //   537: aload_1
    //   538: invokestatic 227	android/os/SystemClock:elapsedRealtime	()J
    //   541: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   544: invokeinterface 235 3 0
    //   549: pop
    //   550: aload 19
    //   552: monitorexit
    //   553: goto -130 -> 423
    //   556: astore 20
    //   558: aload 19
    //   560: monitorexit
    //   561: aload 20
    //   563: athrow
    //   564: aload 21
    //   566: invokevirtual 238	java/lang/Long:longValue	()J
    //   569: getstatic 38	com/facebook/katana/binding/ManagedDataStore:a	I
    //   572: i2l
    //   573: ladd
    //   574: invokestatic 227	android/os/SystemClock:elapsedRealtime	()J
    //   577: lcmp
    //   578: ifge +219 -> 797
    //   581: aload_0
    //   582: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   585: astore 23
    //   587: iconst_2
    //   588: anewarray 5	java/lang/Object
    //   591: astore 24
    //   593: aload 24
    //   595: iconst_0
    //   596: aload 21
    //   598: aastore
    //   599: aload 24
    //   601: iconst_1
    //   602: aload_0
    //   603: aload_1
    //   604: invokevirtual 124	com/facebook/katana/binding/ManagedDataStore:c	(Ljava/lang/Object;)Ljava/lang/String;
    //   607: aastore
    //   608: aload 23
    //   610: ldc 240
    //   612: aload 24
    //   614: invokevirtual 243	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   617: iconst_1
    //   618: istore 12
    //   620: iconst_1
    //   621: istore_2
    //   622: goto -93 -> 529
    //   625: aload_0
    //   626: monitorenter
    //   627: aload_0
    //   628: getfield 245	com/facebook/katana/binding/ManagedDataStore:j	Ljava/lang/Long;
    //   631: ifnonnull +93 -> 724
    //   634: aload_0
    //   635: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   638: astore 17
    //   640: iconst_1
    //   641: anewarray 5	java/lang/Object
    //   644: astore 18
    //   646: aload 18
    //   648: iconst_0
    //   649: aload_0
    //   650: aload_1
    //   651: invokevirtual 124	com/facebook/katana/binding/ManagedDataStore:c	(Ljava/lang/Object;)Ljava/lang/String;
    //   654: aastore
    //   655: aload 17
    //   657: ldc 247
    //   659: aload 18
    //   661: invokevirtual 243	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   664: iconst_0
    //   665: istore 12
    //   667: iconst_1
    //   668: istore_2
    //   669: iload_2
    //   670: ifeq +42 -> 712
    //   673: aload_0
    //   674: invokestatic 227	android/os/SystemClock:elapsedRealtime	()J
    //   677: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   680: putfield 245	com/facebook/katana/binding/ManagedDataStore:j	Ljava/lang/Long;
    //   683: aload_0
    //   684: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   687: astore 13
    //   689: iconst_1
    //   690: anewarray 5	java/lang/Object
    //   693: astore 14
    //   695: aload 14
    //   697: iconst_0
    //   698: aload_0
    //   699: getfield 245	com/facebook/katana/binding/ManagedDataStore:j	Ljava/lang/Long;
    //   702: aastore
    //   703: aload 13
    //   705: ldc 249
    //   707: aload 14
    //   709: invokevirtual 243	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   712: aload_0
    //   713: monitorexit
    //   714: goto -291 -> 423
    //   717: astore 11
    //   719: aload_0
    //   720: monitorexit
    //   721: aload 11
    //   723: athrow
    //   724: aload_0
    //   725: getfield 245	com/facebook/katana/binding/ManagedDataStore:j	Ljava/lang/Long;
    //   728: invokevirtual 238	java/lang/Long:longValue	()J
    //   731: getstatic 38	com/facebook/katana/binding/ManagedDataStore:a	I
    //   734: i2l
    //   735: ladd
    //   736: invokestatic 227	android/os/SystemClock:elapsedRealtime	()J
    //   739: lcmp
    //   740: ifge +49 -> 789
    //   743: aload_0
    //   744: getfield 106	com/facebook/katana/binding/ManagedDataStore:k	Lcom/facebook/katana/util/TraceLogger;
    //   747: astore 15
    //   749: iconst_2
    //   750: anewarray 5	java/lang/Object
    //   753: astore 16
    //   755: aload 16
    //   757: iconst_0
    //   758: aload_0
    //   759: getfield 245	com/facebook/katana/binding/ManagedDataStore:j	Ljava/lang/Long;
    //   762: aastore
    //   763: aload 16
    //   765: iconst_1
    //   766: aload_0
    //   767: aload_1
    //   768: invokevirtual 124	com/facebook/katana/binding/ManagedDataStore:c	(Ljava/lang/Object;)Ljava/lang/String;
    //   771: aastore
    //   772: aload 15
    //   774: ldc 251
    //   776: aload 16
    //   778: invokevirtual 243	com/facebook/katana/util/TraceLogger:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   781: iconst_1
    //   782: istore 12
    //   784: iconst_1
    //   785: istore_2
    //   786: goto -117 -> 669
    //   789: iconst_0
    //   790: istore 12
    //   792: iconst_0
    //   793: istore_2
    //   794: goto -125 -> 669
    //   797: iconst_0
    //   798: istore 12
    //   800: iconst_0
    //   801: istore_2
    //   802: goto -273 -> 529
    //   805: aload 8
    //   807: astore 10
    //   809: goto -427 -> 382
    //   812: aload 10
    //   814: astore 8
    //   816: goto -592 -> 224
    //
    // Exception table:
    //   from	to	target	type
    //   45	71	186	finally
    //   188	190	186	finally
    //   43	45	193	finally
    //   71	74	193	finally
    //   190	198	193	finally
    //   76	183	345	finally
    //   201	226	345	finally
    //   347	349	345	finally
    //   504	561	556	finally
    //   564	617	556	finally
    //   627	721	717	finally
    //   724	781	717	finally
  }

  public void a(Context paramContext, boolean paramBoolean, K paramK, String paramString, V paramV)
  {
    this.k.a("got callback at MDS for key " + c(paramK));
    switch (ManagedDataStore.3.a[this.d.ordinal()])
    {
    default:
      if (paramBoolean)
        break;
    case 2:
    case 3:
    }
    while (true)
    {
      while (true)
      {
        while (true)
        {
          return;
          synchronized (this.i)
          {
            this.i.remove(paramK);
          }
        }
        monitorenter;
        try
        {
          TraceLogger localTraceLogger = this.k;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = c(paramK);
          localTraceLogger.a("released global lock (key: %s)", arrayOfObject);
          this.j = null;
          monitorexit;
          break;
        }
        finally
        {
          localObject1 = finally;
          monitorexit;
          throw localObject1;
        }
      }
      long l1 = System.currentTimeMillis();
      int m = this.c.getCacheTtl(paramK, paramV);
      if (m > 0)
        this.f.a(paramK, paramV, l1);
      if (this.c.getPersistentStoreTtl(paramK, paramV) <= 0)
        continue;
      this.k.a("Writing key " + paramK + " to disk");
      if (m > 0)
      {
        l.execute(new ManagedDataStore.1(this, paramK, paramString, l1));
        continue;
      }
      this.g.a(paramK, paramString, l1);
    }
  }

  public void a(ManagedDataStore.ClearType paramClearType)
  {
    monitorenter;
    try
    {
      if ((paramClearType == ManagedDataStore.ClearType.CLEAR_DISK) || (paramClearType == ManagedDataStore.ClearType.CLEAR_ALL))
      {
        c();
        this.g.a();
      }
      if ((paramClearType == ManagedDataStore.ClearType.CLEAR_MEMORY) || (paramClearType == ManagedDataStore.ClearType.CLEAR_ALL))
        this.f.a();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(ManagedDataStore.ClearType paramClearType, long paramLong)
  {
    monitorenter;
    try
    {
      if ((paramClearType == ManagedDataStore.ClearType.CLEAR_DISK) || (paramClearType == ManagedDataStore.ClearType.CLEAR_ALL))
      {
        c();
        this.g.a(paramLong);
      }
      if ((paramClearType == ManagedDataStore.ClearType.CLEAR_MEMORY) || (paramClearType == ManagedDataStore.ClearType.CLEAR_ALL))
        this.f.a(paramLong);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public TraceLogger b()
  {
    return this.k;
  }

  public void b(ManagedDataStore.ClearType paramClearType)
  {
    monitorenter;
    try
    {
      if ((paramClearType == ManagedDataStore.ClearType.CLEAR_DISK) || (paramClearType == ManagedDataStore.ClearType.CLEAR_ALL))
      {
        c();
        this.g.b();
      }
      if ((paramClearType == ManagedDataStore.ClearType.CLEAR_MEMORY) || (paramClearType == ManagedDataStore.ClearType.CLEAR_ALL))
        this.f.b();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b(K paramK)
  {
    this.f.b(paramK);
    c();
    this.g.b(paramK);
  }

  protected String c(K paramK)
  {
    if (paramK == null);
    for (String str = "(null)"; ; str = paramK.toString())
      return str;
  }

  public void c()
  {
    Future localFuture = l.submit(new ManagedDataStore.2(this));
    try
    {
      localFuture.get();
      label24: return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label24;
    }
    catch (ExecutionException localExecutionException)
    {
      break label24;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ManagedDataStore
 * JD-Core Version:    0.6.0
 */