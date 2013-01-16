package com.facebook.orca.common.http;

import com.facebook.orca.debug.BLog;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

public class OrcaHttpRequestProcessor
{
  private static Class<?> a = OrcaHttpRequestProcessor.class;
  private static String b = "OrcaHttpRequestProcessor";
  private static final Logger c = Logger.getLogger(OrcaHttpRequestProcessor.class.getName());
  private final OrcaHttpClient d;
  private final OrcaHttpDebugProcessorHook e;
  private final ConcurrentMap<HttpUriRequest, HttpUriRequest> f;
  private volatile boolean g;

  public OrcaHttpRequestProcessor(OrcaHttpClient paramOrcaHttpClient, OrcaHttpDebugProcessorHook paramOrcaHttpDebugProcessorHook)
  {
    this.d = paramOrcaHttpClient;
    this.e = paramOrcaHttpDebugProcessorHook;
    this.f = Maps.c();
  }

  private <T> T a(String paramString, ResponseHandler<? extends T> paramResponseHandler, HttpResponse paramHttpResponse)
  {
    try
    {
      Object localObject = paramResponseHandler.handleResponse(paramHttpResponse);
      return localObject;
    }
    catch (Throwable localThrowable1)
    {
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      if (localHttpEntity != null);
      try
      {
        localHttpEntity.consumeContent();
        if ((localThrowable1 instanceof Error))
        {
          BLog.b(b + "[" + paramString + "]", "Error", localThrowable1);
          throw ((Error)localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          c.log(Level.WARNING, "Error consuming content after an exception.", localThrowable2);
        if ((localThrowable1 instanceof RuntimeException))
        {
          BLog.b(b + "[" + paramString + "]", "RuntimeException", localThrowable1);
          throw ((RuntimeException)localThrowable1);
        }
        if ((localThrowable1 instanceof IOException))
        {
          BLog.b(b + "[" + paramString + "]", "IOException", localThrowable1);
          throw ((IOException)localThrowable1);
        }
        BLog.b(b + "[" + paramString + "]", "Throwable", localThrowable1);
      }
      throw new UndeclaredThrowableException(localThrowable1);
    }
  }

  private RuntimeException a(Throwable paramThrowable)
  {
    if (ProtocolExceptions.a(paramThrowable))
      this.d.a().clear();
    Throwables.propagateIfPossible(paramThrowable);
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    throw new UndeclaredThrowableException(paramThrowable);
  }

  private HttpHost a(HttpUriRequest paramHttpUriRequest)
  {
    URI localURI = paramHttpUriRequest.getURI();
    boolean bool = localURI.isAbsolute();
    HttpHost localHttpHost = null;
    if (bool)
      localHttpHost = new HttpHost(localURI.getHost(), localURI.getPort(), localURI.getScheme());
    return localHttpHost;
  }

  private void a(String paramString, boolean paramBoolean, HttpResponse paramHttpResponse, Throwable paramThrowable, long paramLong)
  {
    if (paramHttpResponse != null)
      paramHttpResponse.getStatusLine().getStatusCode();
  }

  private void a(HttpResponse paramHttpResponse)
  {
  }

  private void d()
  {
    if (this.g)
      throw new IOException("In lame duck mode");
  }

  // ERROR //
  public <T> T a(String paramString, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +13 -> 14
    //   4: new 200	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 202
    //   10: invokespecial 203	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: invokespecial 205	com/facebook/orca/common/http/OrcaHttpRequestProcessor:d	()V
    //   18: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   21: lstore 4
    //   23: new 81	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   30: getstatic 28	com/facebook/orca/common/http/OrcaHttpRequestProcessor:b	Ljava/lang/String;
    //   33: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 88
    //   38: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 90
    //   47: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 216	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 57	com/facebook/orca/common/http/OrcaHttpRequestProcessor:f	Ljava/util/concurrent/ConcurrentMap;
    //   62: aload_2
    //   63: aload_2
    //   64: invokeinterface 222 3 0
    //   69: pop
    //   70: aload_0
    //   71: getfield 50	com/facebook/orca/common/http/OrcaHttpRequestProcessor:e	Lcom/facebook/orca/common/http/OrcaHttpDebugProcessorHook;
    //   74: aload_2
    //   75: invokevirtual 227	com/facebook/orca/common/http/OrcaHttpDebugProcessorHook:a	(Lorg/apache/http/HttpRequest;)V
    //   78: aload_0
    //   79: getfield 48	com/facebook/orca/common/http/OrcaHttpRequestProcessor:d	Lcom/facebook/orca/common/http/OrcaHttpClient;
    //   82: aload_0
    //   83: aload_2
    //   84: invokespecial 229	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpHost;
    //   87: aload_2
    //   88: aconst_null
    //   89: checkcast 231	org/apache/http/protocol/HttpContext
    //   92: invokeinterface 235 4 0
    //   97: astore 17
    //   99: aload 17
    //   101: astore 10
    //   103: aload_0
    //   104: aload 10
    //   106: invokespecial 237	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Lorg/apache/http/HttpResponse;)V
    //   109: aload_0
    //   110: aload_1
    //   111: aload_3
    //   112: aload 10
    //   114: invokespecial 239	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/String;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/HttpResponse;)Ljava/lang/Object;
    //   117: astore 19
    //   119: aload_0
    //   120: getfield 50	com/facebook/orca/common/http/OrcaHttpRequestProcessor:e	Lcom/facebook/orca/common/http/OrcaHttpDebugProcessorHook;
    //   123: aload 10
    //   125: aload 19
    //   127: invokevirtual 242	com/facebook/orca/common/http/OrcaHttpDebugProcessorHook:a	(Lorg/apache/http/HttpResponse;Ljava/lang/Object;)V
    //   130: aload 10
    //   132: invokeinterface 72 1 0
    //   137: astore 20
    //   139: aload 20
    //   141: ifnull +10 -> 151
    //   144: aload 20
    //   146: invokeinterface 77 1 0
    //   151: aload_0
    //   152: getfield 57	com/facebook/orca/common/http/OrcaHttpRequestProcessor:f	Ljava/util/concurrent/ConcurrentMap;
    //   155: aload_2
    //   156: invokeinterface 246 2 0
    //   161: pop
    //   162: aload 6
    //   164: invokevirtual 248	com/facebook/orca/debug/Tracer:a	()J
    //   167: pop2
    //   168: aload_0
    //   169: aload_1
    //   170: iconst_1
    //   171: aload 10
    //   173: aconst_null
    //   174: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   177: lload 4
    //   179: lsub
    //   180: invokespecial 250	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/String;ZLorg/apache/http/HttpResponse;Ljava/lang/Throwable;J)V
    //   183: aload 19
    //   185: areturn
    //   186: astore 15
    //   188: aconst_null
    //   189: astore 10
    //   191: aload_0
    //   192: aload 15
    //   194: invokespecial 252	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   197: athrow
    //   198: astore 16
    //   200: aload 16
    //   202: astore 9
    //   204: aload 15
    //   206: astore 11
    //   208: aload_0
    //   209: getfield 57	com/facebook/orca/common/http/OrcaHttpRequestProcessor:f	Ljava/util/concurrent/ConcurrentMap;
    //   212: aload_2
    //   213: invokeinterface 246 2 0
    //   218: pop
    //   219: aload 6
    //   221: invokevirtual 248	com/facebook/orca/debug/Tracer:a	()J
    //   224: pop2
    //   225: aload_0
    //   226: aload_1
    //   227: iconst_0
    //   228: aload 10
    //   230: aload 11
    //   232: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   235: lload 4
    //   237: lsub
    //   238: invokespecial 250	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/String;ZLorg/apache/http/HttpResponse;Ljava/lang/Throwable;J)V
    //   241: aload 9
    //   243: athrow
    //   244: astore 8
    //   246: aload 8
    //   248: astore 9
    //   250: aconst_null
    //   251: astore 10
    //   253: aconst_null
    //   254: astore 11
    //   256: goto -48 -> 208
    //   259: astore 18
    //   261: aload 18
    //   263: astore 9
    //   265: aconst_null
    //   266: astore 11
    //   268: goto -60 -> 208
    //   271: astore 15
    //   273: goto -82 -> 191
    //
    // Exception table:
    //   from	to	target	type
    //   70	99	186	java/lang/Throwable
    //   191	198	198	finally
    //   70	99	244	finally
    //   103	151	259	finally
    //   103	151	271	java/lang/Throwable
  }

  // ERROR //
  public HttpResponse a(String paramString, HttpUriRequest paramHttpUriRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokespecial 205	com/facebook/orca/common/http/OrcaHttpRequestProcessor:d	()V
    //   6: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: getstatic 28	com/facebook/orca/common/http/OrcaHttpRequestProcessor:b	Ljava/lang/String;
    //   21: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 88
    //   26: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 90
    //   35: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 216	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   44: astore 6
    //   46: aload_0
    //   47: getfield 57	com/facebook/orca/common/http/OrcaHttpRequestProcessor:f	Ljava/util/concurrent/ConcurrentMap;
    //   50: aload_2
    //   51: aload_2
    //   52: invokeinterface 222 3 0
    //   57: pop
    //   58: aload_0
    //   59: getfield 50	com/facebook/orca/common/http/OrcaHttpRequestProcessor:e	Lcom/facebook/orca/common/http/OrcaHttpDebugProcessorHook;
    //   62: aload_2
    //   63: invokevirtual 227	com/facebook/orca/common/http/OrcaHttpDebugProcessorHook:a	(Lorg/apache/http/HttpRequest;)V
    //   66: aload_0
    //   67: getfield 48	com/facebook/orca/common/http/OrcaHttpRequestProcessor:d	Lcom/facebook/orca/common/http/OrcaHttpClient;
    //   70: aload_0
    //   71: aload_2
    //   72: invokespecial 229	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpHost;
    //   75: aload_2
    //   76: aconst_null
    //   77: checkcast 231	org/apache/http/protocol/HttpContext
    //   80: invokeinterface 235 4 0
    //   85: astore 17
    //   87: aload 17
    //   89: astore 9
    //   91: aload_0
    //   92: getfield 50	com/facebook/orca/common/http/OrcaHttpRequestProcessor:e	Lcom/facebook/orca/common/http/OrcaHttpDebugProcessorHook;
    //   95: aload 9
    //   97: aconst_null
    //   98: invokevirtual 242	com/facebook/orca/common/http/OrcaHttpDebugProcessorHook:a	(Lorg/apache/http/HttpResponse;Ljava/lang/Object;)V
    //   101: aload_0
    //   102: aload 9
    //   104: invokespecial 237	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Lorg/apache/http/HttpResponse;)V
    //   107: aload_0
    //   108: getfield 57	com/facebook/orca/common/http/OrcaHttpRequestProcessor:f	Ljava/util/concurrent/ConcurrentMap;
    //   111: aload_2
    //   112: invokeinterface 246 2 0
    //   117: pop
    //   118: aload 6
    //   120: invokevirtual 248	com/facebook/orca/debug/Tracer:a	()J
    //   123: pop2
    //   124: aload_0
    //   125: aload_1
    //   126: iconst_1
    //   127: aload 9
    //   129: aconst_null
    //   130: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   133: lload 4
    //   135: lsub
    //   136: invokespecial 250	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/String;ZLorg/apache/http/HttpResponse;Ljava/lang/Throwable;J)V
    //   139: aload 9
    //   141: areturn
    //   142: astore 14
    //   144: aload_0
    //   145: aload 14
    //   147: invokespecial 252	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   150: athrow
    //   151: astore 15
    //   153: aload 15
    //   155: astore 8
    //   157: aload_3
    //   158: astore 9
    //   160: aload 14
    //   162: astore 10
    //   164: aload_0
    //   165: getfield 57	com/facebook/orca/common/http/OrcaHttpRequestProcessor:f	Ljava/util/concurrent/ConcurrentMap;
    //   168: aload_2
    //   169: invokeinterface 246 2 0
    //   174: pop
    //   175: aload 6
    //   177: invokevirtual 248	com/facebook/orca/debug/Tracer:a	()J
    //   180: pop2
    //   181: aload_0
    //   182: aload_1
    //   183: iconst_0
    //   184: aload 9
    //   186: aload 10
    //   188: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   191: lload 4
    //   193: lsub
    //   194: invokespecial 250	com/facebook/orca/common/http/OrcaHttpRequestProcessor:a	(Ljava/lang/String;ZLorg/apache/http/HttpResponse;Ljava/lang/Throwable;J)V
    //   197: aload 8
    //   199: athrow
    //   200: astore 7
    //   202: aload 7
    //   204: astore 8
    //   206: aconst_null
    //   207: astore 9
    //   209: aconst_null
    //   210: astore 10
    //   212: goto -48 -> 164
    //   215: astore 18
    //   217: aload 18
    //   219: astore 8
    //   221: aconst_null
    //   222: astore 10
    //   224: goto -60 -> 164
    //   227: astore 14
    //   229: aload 9
    //   231: astore_3
    //   232: goto -88 -> 144
    //
    // Exception table:
    //   from	to	target	type
    //   46	87	142	java/lang/Throwable
    //   144	151	151	finally
    //   46	87	200	finally
    //   91	107	215	finally
    //   91	107	227	java/lang/Throwable
  }

  public void a()
  {
    this.g = true;
  }

  public void b()
  {
    this.g = false;
  }

  public void c()
  {
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext())
      ((HttpUriRequest)localIterator.next()).abort();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpRequestProcessor
 * JD-Core Version:    0.6.2
 */