package org.acra.util;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleTraceLogger
{
  public static int NO_LIMIT = 0;
  public static final String TAG = "SimpleTraceLogger";
  private Queue<SimpleTraceLogger.TraceLogLine> mTrace;
  protected final int mTraceCountLimit;

  public SimpleTraceLogger(int paramInt)
  {
    this.mTraceCountLimit = paramInt;
    clear();
  }

  public void append(String paramString)
  {
    monitorenter;
    try
    {
      if ((this.mTraceCountLimit > NO_LIMIT) && (this.mTrace.size() == this.mTraceCountLimit))
        this.mTrace.remove();
      this.mTrace.offer(new SimpleTraceLogger.TraceLogLine(paramString, SystemClock.elapsedRealtime()));
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

  public void append(String paramString, Object[] paramArrayOfObject)
  {
    append(String.format(paramString, paramArrayOfObject));
  }

  public void clear()
  {
    monitorenter;
    try
    {
      this.mTrace = new LinkedList();
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

  public String toString()
  {
    monitorenter;
    StringBuilder localStringBuilder;
    try
    {
      localStringBuilder = new StringBuilder();
      Iterator localIterator = this.mTrace.iterator();
      while (localIterator.hasNext())
        localStringBuilder.append(((SimpleTraceLogger.TraceLogLine)localIterator.next()).toString()).append('\n');
    }
    finally
    {
      monitorexit;
    }
    String str = localStringBuilder.toString();
    monitorexit;
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.SimpleTraceLogger
 * JD-Core Version:    0.6.0
 */