package org.acra.util;

public class SimpleTraceLogger$TraceLogLine
{
  public final long time;
  public final String trace;

  SimpleTraceLogger$TraceLogLine(String paramString, long paramLong)
  {
    this.trace = paramString;
    this.time = paramLong;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(this.time);
    arrayOfObject[1] = this.trace;
    return String.format("[%d] %s", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.SimpleTraceLogger.TraceLogLine
 * JD-Core Version:    0.6.0
 */