package com.facebook.katana.net;

import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.katana.UserAgent;
import com.facebook.katana.UserAgent.AppForegroundMode;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.service.BackgroundDetectionService;
import com.facebook.orca.common.http.OrcaHttpClient;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.entity.mime.MultipartEntityWithProgressListener;
import com.facebook.orca.entity.mime.StringEntityWithProgressListener;
import com.facebook.orca.inject.FbInjector;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.protocol.HttpContext;

public class HttpOperation
  implements Runnable
{
  protected static String a;
  private static Class<?> d = HttpOperation.class;
  private static String g = null;
  private static String h = null;
  private static long i = 0L;
  public final HttpRequestBase b;
  public final HttpContext c;
  private long e = 0L;
  private long f = 0L;
  private final NetAccessLogger j;
  private final OrcaHttpClient k;
  private final HttpOperation.HttpOperationListener l;
  private Thread m = null;

  public HttpOperation(Context paramContext, HttpOperation.Method paramMethod, String paramString1, HttpOperation.HttpOperationListener paramHttpOperationListener, String paramString2, String paramString3, String paramString4, HttpContext paramHttpContext)
  {
  }

  public HttpOperation(Context paramContext, HttpOperation.Method paramMethod, String paramString, HttpOperation.HttpOperationListener paramHttpOperationListener, boolean paramBoolean)
  {
  }

  public HttpOperation(Context paramContext, String paramString1, String paramString2, String paramString3, HttpOperation.HttpOperationListener paramHttpOperationListener, boolean paramBoolean)
  {
    this(paramContext, new HttpPost(paramString1), null, paramHttpOperationListener);
    try
    {
      StringEntityWithProgressListener localStringEntityWithProgressListener = new StringEntityWithProgressListener(paramString2);
      if (this.l != null)
      {
        long l1 = localStringEntityWithProgressListener.getContentLength();
        if (l1 > 0L)
          localStringEntityWithProgressListener.a(new HttpOperation.UploadProgressListener(this, l1));
      }
      ((HttpPost)this.b).setEntity(localStringEntityWithProgressListener);
      this.b.addHeader("Content-Type", paramString3);
      if (paramBoolean)
      {
        this.b.addHeader("User-Agent", a(paramContext));
        this.b.addHeader("X-FB-Connection-Type", b(paramContext));
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        BLog.e(d, "unsupported encoding", localUnsupportedEncodingException);
    }
  }

  public HttpOperation(Context paramContext, String paramString, List<FormBodyPart> paramList, HttpOperation.HttpOperationListener paramHttpOperationListener, boolean paramBoolean)
  {
    this(paramContext, new HttpPost(paramString), null, paramHttpOperationListener);
    if (paramList != null)
    {
      MultipartEntityWithProgressListener localMultipartEntityWithProgressListener = new MultipartEntityWithProgressListener();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localMultipartEntityWithProgressListener.a((FormBodyPart)localIterator.next());
      if (this.l != null)
      {
        long l1 = localMultipartEntityWithProgressListener.getContentLength();
        if (l1 > 0L)
          localMultipartEntityWithProgressListener.a(new HttpOperation.UploadProgressListener(this, l1));
      }
      ((HttpPost)this.b).setEntity(localMultipartEntityWithProgressListener);
    }
    if (paramBoolean)
    {
      this.b.addHeader("User-Agent", a(paramContext));
      this.b.addHeader("X-FB-Connection-Type", b(paramContext));
    }
  }

  private HttpOperation(Context paramContext, HttpRequestBase paramHttpRequestBase, HttpContext paramHttpContext, HttpOperation.HttpOperationListener paramHttpOperationListener)
  {
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.k = ((OrcaHttpClient)localFbInjector.a(OrcaHttpClient.class));
    this.j = ((NetAccessLogger)localFbInjector.a(NetAccessLogger.class));
    this.b = paramHttpRequestBase;
    this.c = paramHttpContext;
    this.l = paramHttpOperationListener;
  }

  protected static String a(Context paramContext)
  {
    if (a == null)
      a = UserAgent.a(paramContext, Boolean.valueOf(false));
    String str = c(paramContext);
    if (str != null);
    while (true)
    {
      return str;
      str = a;
    }
  }

  public static String b(Context paramContext)
  {
    AnalyticsLogger localAnalyticsLogger = LoggerUtils.a(paramContext);
    if (localAnalyticsLogger != null);
    for (String str = localAnalyticsLogger.e(); ; str = null)
      return str;
  }

  public static String c(Context paramContext)
  {
    monitorenter;
    try
    {
      if ((g == null) || (h == null))
      {
        g = UserAgent.a(paramContext, Boolean.valueOf(false), UserAgent.AppForegroundMode.Background);
        h = UserAgent.a(paramContext, Boolean.valueOf(false), UserAgent.AppForegroundMode.Foreground);
      }
      String str;
      if (!BackgroundDetectionService.b())
        str = g;
      while (true)
      {
        return str;
        if (i == 0L)
          i = KeyValueManager.a(paramContext, "LAST_FG_SIGNAL_TIME", 0L);
        long l1 = System.currentTimeMillis();
        if (Math.abs(l1 - i) > 21600000L)
        {
          i = l1;
          KeyValueManager.a(paramContext, "LAST_FG_SIGNAL_TIME", Long.valueOf(l1));
          str = h;
          continue;
        }
        str = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void c()
  {
    a = null;
  }

  public void a()
  {
    if (this.m != null)
      this.m.interrupt();
    this.b.abort();
  }

  public void b()
  {
    this.m = new Thread(this);
    this.m.setPriority(1);
    this.m.start();
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: invokestatic 263	com/facebook/katana/util/ThreadUtils:a	()Z
    //   3: invokestatic 268	com/facebook/debug/Assert:a	(Z)V
    //   6: aload_0
    //   7: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
    //   10: putfield 144	com/facebook/katana/net/HttpOperation:e	J
    //   13: aload_0
    //   14: getfield 57	com/facebook/katana/net/HttpOperation:b	Lorg/apache/http/client/methods/HttpRequestBase;
    //   17: invokevirtual 277	org/apache/http/client/methods/HttpRequestBase:getURI	()Ljava/net/URI;
    //   20: invokevirtual 282	java/net/URI:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 164	com/facebook/katana/net/HttpOperation:j	Lcom/facebook/common/util/NetAccessLogger;
    //   28: aload_1
    //   29: invokevirtual 284	com/facebook/common/util/NetAccessLogger:a	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 166	com/facebook/katana/net/HttpOperation:c	Lorg/apache/http/protocol/HttpContext;
    //   36: ifnull +208 -> 244
    //   39: aload_0
    //   40: getfield 160	com/facebook/katana/net/HttpOperation:k	Lcom/facebook/orca/common/http/OrcaHttpClient;
    //   43: aload_0
    //   44: getfield 57	com/facebook/katana/net/HttpOperation:b	Lorg/apache/http/client/methods/HttpRequestBase;
    //   47: aload_0
    //   48: getfield 166	com/facebook/katana/net/HttpOperation:c	Lorg/apache/http/protocol/HttpContext;
    //   51: invokeinterface 288 3 0
    //   56: astore 12
    //   58: aload 12
    //   60: invokeinterface 294 1 0
    //   65: invokeinterface 300 1 0
    //   70: istore 13
    //   72: aload 12
    //   74: invokeinterface 294 1 0
    //   79: invokeinterface 303 1 0
    //   84: astore 14
    //   86: iload 13
    //   88: sipush 200
    //   91: if_icmpne +341 -> 432
    //   94: aload 12
    //   96: invokeinterface 307 1 0
    //   101: astore 19
    //   103: aload 19
    //   105: astore 5
    //   107: aload 5
    //   109: ifnull +314 -> 423
    //   112: aload 5
    //   114: invokeinterface 313 1 0
    //   119: ifnull +147 -> 266
    //   122: aload 5
    //   124: invokeinterface 313 1 0
    //   129: invokeinterface 318 1 0
    //   134: astore 21
    //   136: aload 5
    //   138: invokeinterface 321 1 0
    //   143: ifnull +129 -> 272
    //   146: aload 5
    //   148: invokeinterface 321 1 0
    //   153: invokeinterface 318 1 0
    //   158: astore 22
    //   160: new 323	com/facebook/katana/net/HttpOperation$ResponseInputStream
    //   163: dup
    //   164: aload 5
    //   166: invokeinterface 327 1 0
    //   171: aload 22
    //   173: aload 21
    //   175: invokespecial 330	com/facebook/katana/net/HttpOperation$ResponseInputStream:<init>	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)V
    //   178: astore_3
    //   179: aload 5
    //   181: astore 8
    //   183: aload_0
    //   184: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
    //   187: putfield 146	com/facebook/katana/net/HttpOperation:f	J
    //   190: aload_0
    //   191: getfield 88	com/facebook/katana/net/HttpOperation:l	Lcom/facebook/katana/net/HttpOperation$HttpOperationListener;
    //   194: ifnull +19 -> 213
    //   197: aload_0
    //   198: getfield 88	com/facebook/katana/net/HttpOperation:l	Lcom/facebook/katana/net/HttpOperation$HttpOperationListener;
    //   201: aload_0
    //   202: iload 13
    //   204: aload 14
    //   206: aload_3
    //   207: aconst_null
    //   208: invokeinterface 335 6 0
    //   213: aload_3
    //   214: ifnull +13 -> 227
    //   217: aload_3
    //   218: invokevirtual 337	com/facebook/katana/net/HttpOperation$ResponseInputStream:a	()I
    //   221: istore 16
    //   223: iload 16
    //   225: i2l
    //   226: pop2
    //   227: aload_3
    //   228: invokestatic 342	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   231: aload 8
    //   233: ifnull +10 -> 243
    //   236: aload 8
    //   238: invokeinterface 345 1 0
    //   243: return
    //   244: aload_0
    //   245: getfield 160	com/facebook/katana/net/HttpOperation:k	Lcom/facebook/orca/common/http/OrcaHttpClient;
    //   248: aload_0
    //   249: getfield 57	com/facebook/katana/net/HttpOperation:b	Lorg/apache/http/client/methods/HttpRequestBase;
    //   252: invokeinterface 348 2 0
    //   257: astore 11
    //   259: aload 11
    //   261: astore 12
    //   263: goto -205 -> 58
    //   266: aconst_null
    //   267: astore 21
    //   269: goto -133 -> 136
    //   272: aconst_null
    //   273: astore 22
    //   275: goto -115 -> 160
    //   278: astore 7
    //   280: aconst_null
    //   281: astore 8
    //   283: aconst_null
    //   284: astore 9
    //   286: aload_0
    //   287: getfield 88	com/facebook/katana/net/HttpOperation:l	Lcom/facebook/katana/net/HttpOperation$HttpOperationListener;
    //   290: ifnull +18 -> 308
    //   293: aload_0
    //   294: getfield 88	com/facebook/katana/net/HttpOperation:l	Lcom/facebook/katana/net/HttpOperation$HttpOperationListener;
    //   297: aload_0
    //   298: iconst_0
    //   299: aconst_null
    //   300: aconst_null
    //   301: aload 7
    //   303: invokeinterface 335 6 0
    //   308: aload 9
    //   310: invokestatic 342	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   313: aload 8
    //   315: ifnull -72 -> 243
    //   318: aload 8
    //   320: invokeinterface 345 1 0
    //   325: goto -82 -> 243
    //   328: astore 10
    //   330: goto -87 -> 243
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_3
    //   336: aload_2
    //   337: astore 4
    //   339: aconst_null
    //   340: astore 5
    //   342: aload_3
    //   343: invokestatic 342	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   346: aload 5
    //   348: ifnull +10 -> 358
    //   351: aload 5
    //   353: invokeinterface 345 1 0
    //   358: aload 4
    //   360: athrow
    //   361: astore 15
    //   363: goto -120 -> 243
    //   366: astore 6
    //   368: goto -10 -> 358
    //   371: astore 20
    //   373: aload 20
    //   375: astore 4
    //   377: aconst_null
    //   378: astore_3
    //   379: goto -37 -> 342
    //   382: astore 4
    //   384: aload 8
    //   386: astore 5
    //   388: goto -46 -> 342
    //   391: astore 4
    //   393: aload 8
    //   395: astore 5
    //   397: aload 9
    //   399: astore_3
    //   400: goto -58 -> 342
    //   403: astore 7
    //   405: aload 5
    //   407: astore 8
    //   409: aconst_null
    //   410: astore 9
    //   412: goto -126 -> 286
    //   415: astore 7
    //   417: aload_3
    //   418: astore 9
    //   420: goto -134 -> 286
    //   423: aload 5
    //   425: astore 8
    //   427: aconst_null
    //   428: astore_3
    //   429: goto -246 -> 183
    //   432: aconst_null
    //   433: astore_3
    //   434: aconst_null
    //   435: astore 8
    //   437: goto -254 -> 183
    //
    // Exception table:
    //   from	to	target	type
    //   32	103	278	java/lang/Exception
    //   244	259	278	java/lang/Exception
    //   318	325	328	java/io/IOException
    //   32	103	333	finally
    //   244	259	333	finally
    //   236	243	361	java/io/IOException
    //   351	358	366	java/io/IOException
    //   112	179	371	finally
    //   183	223	382	finally
    //   286	308	391	finally
    //   112	179	403	java/lang/Exception
    //   183	223	415	java/lang/Exception
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.net.HttpOperation
 * JD-Core Version:    0.6.0
 */