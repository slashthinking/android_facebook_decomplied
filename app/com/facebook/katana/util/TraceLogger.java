package com.facebook.katana.util;

import android.os.SystemClock;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TraceLogger
{
  public static final Class<?> a = TraceLogger.class;
  public static int b = 0;
  protected final int c;
  protected final int d;
  protected boolean e;
  private Queue<TraceLogger.TraceLogLine> f;
  private int g;

  public TraceLogger(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt1 < "overly large log entry skipped".length()))
      throw new IllegalArgumentException("trace size limit must be at least " + "overly large log entry skipped".length() + " chars long");
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = false;
    a();
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.f = new LinkedList();
      this.g = 0;
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
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/facebook/katana/util/TraceLogger:d	I
    //   6: ifle +34 -> 40
    //   9: iconst_1
    //   10: aload_0
    //   11: getfield 71	com/facebook/katana/util/TraceLogger:f	Ljava/util/Queue;
    //   14: invokeinterface 78 1 0
    //   19: iadd
    //   20: aload_0
    //   21: getfield 62	com/facebook/katana/util/TraceLogger:d	I
    //   24: if_icmple +16 -> 40
    //   27: aload_0
    //   28: invokevirtual 81	com/facebook/katana/util/TraceLogger:b	()Lcom/facebook/katana/util/TraceLogger$TraceLogLine;
    //   31: pop
    //   32: goto -23 -> 9
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    //   40: aload_0
    //   41: getfield 60	com/facebook/katana/util/TraceLogger:c	I
    //   44: ifle +41 -> 85
    //   47: aload_1
    //   48: invokevirtual 35	java/lang/String:length	()I
    //   51: aload_0
    //   52: getfield 60	com/facebook/katana/util/TraceLogger:c	I
    //   55: if_icmple +6 -> 61
    //   58: ldc 29
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 73	com/facebook/katana/util/TraceLogger:g	I
    //   65: aload_1
    //   66: invokevirtual 35	java/lang/String:length	()I
    //   69: iadd
    //   70: aload_0
    //   71: getfield 60	com/facebook/katana/util/TraceLogger:c	I
    //   74: if_icmple +11 -> 85
    //   77: aload_0
    //   78: invokevirtual 81	com/facebook/katana/util/TraceLogger:b	()Lcom/facebook/katana/util/TraceLogger$TraceLogLine;
    //   81: pop
    //   82: goto -21 -> 61
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 83	com/facebook/katana/util/TraceLogger:b	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_0
    //   93: getfield 64	com/facebook/katana/util/TraceLogger:e	Z
    //   96: ifeq +28 -> 124
    //   99: new 39	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   106: getstatic 21	com/facebook/katana/util/TraceLogger:a	Ljava/lang/Class;
    //   109: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: ldc 88
    //   114: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_1
    //   121: invokestatic 93	com/facebook/common/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: return
    //
    // Exception table:
    //   from	to	target	type
    //   2	38	35	finally
    //   40	92	35	finally
  }

  public void a(String paramString, Object[] paramArrayOfObject)
  {
    a(StringLocaleUtil.a(paramString, paramArrayOfObject));
  }

  protected final TraceLogger.TraceLogLine b()
  {
    TraceLogger.TraceLogLine localTraceLogLine = (TraceLogger.TraceLogLine)this.f.remove();
    this.g -= localTraceLogLine.a.length();
    return localTraceLogLine;
  }

  protected final void b(String paramString)
  {
    this.f.offer(new TraceLogger.TraceLogLine(paramString, SystemClock.elapsedRealtime()));
    this.g += paramString.length();
  }

  public String toString()
  {
    int i = 1;
    monitorenter;
    StringBuilder localStringBuilder;
    while (true)
    {
      try
      {
        localStringBuilder = new StringBuilder(this.g + 30 * this.f.size());
        Iterator localIterator = this.f.iterator();
        if (!localIterator.hasNext())
          break;
        TraceLogger.TraceLogLine localTraceLogLine = (TraceLogger.TraceLogLine)localIterator.next();
        if (i != 0)
        {
          i = 0;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Long.valueOf(localTraceLogLine.b);
          arrayOfObject[1] = localTraceLogLine.a;
          localStringBuilder.append(StringLocaleUtil.a("[%d] %s", arrayOfObject));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localStringBuilder.append('\n');
    }
    String str = localStringBuilder.toString();
    monitorexit;
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.TraceLogger
 * JD-Core Version:    0.6.0
 */