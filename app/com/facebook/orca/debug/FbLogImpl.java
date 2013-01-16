package com.facebook.orca.debug;

import android.util.Log;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.common.util.ExceptionUtil;
import com.facebook.orca.common.util.RateLimiter;
import com.facebook.orca.common.util.SystemClock;
import java.util.Iterator;
import java.util.Set;

public class FbLogImpl
  implements FbLog
{
  private static final RateLimiter a = new RateLimiter(SystemClock.b(), 5, 3600000L);
  private final String b;
  private final Set<FbLogWriter> c;
  private final FbErrorReporter d;

  public FbLogImpl(String paramString, Set<FbLogWriter> paramSet, FbErrorReporter paramFbErrorReporter)
  {
    this.b = paramString;
    this.c = paramSet;
    this.d = paramFbErrorReporter;
  }

  private String a(String paramString)
  {
    if (this.b != null)
      paramString = this.b + ":" + paramString;
    return paramString;
  }

  private void a(WtfToken paramWtfToken, String paramString1, String paramString2, TerribleFailure paramTerribleFailure)
  {
    if ((paramWtfToken.a()) && (a.a()))
      this.d.a(paramString1, paramString2, paramTerribleFailure, false, 1);
  }

  private int f(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(7, paramString1, ExceptionUtil.a(new TerribleFailure(paramString2, paramThrowable)));
  }

  public int a(int paramInt, String paramString1, String paramString2)
  {
    String str = a(paramString1);
    int i = Log.println(paramInt, str, paramString2);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FbLogWriter localFbLogWriter = (FbLogWriter)localIterator.next();
      try
      {
        localFbLogWriter.a(paramInt, str, paramString2);
      }
      catch (Throwable localThrowable)
      {
      }
    }
    return i;
  }

  public int a(WtfToken paramWtfToken, String paramString1, String paramString2)
  {
    a(paramWtfToken, paramString1, paramString2, new TerribleFailure(paramString1 + ": " + paramString2));
    return f(paramString1, paramString2, null);
  }

  public int a(WtfToken paramWtfToken, String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramWtfToken, paramString1, paramString2, new TerribleFailure(paramString1 + ": " + paramString2, paramThrowable));
    return f(paramString1, paramString2, paramThrowable);
  }

  public int a(WtfToken paramWtfToken, String paramString, Throwable paramThrowable)
  {
    a(paramWtfToken, paramString, paramThrowable.getMessage(), new TerribleFailure(paramString, paramThrowable));
    return f(paramString, paramThrowable.getMessage(), paramThrowable);
  }

  public int a(String paramString1, String paramString2)
  {
    return a(2, paramString1, paramString2);
  }

  public int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(2, paramString1, paramString2 + '\n' + ExceptionUtil.a(paramThrowable));
  }

  public int a(String paramString, Throwable paramThrowable)
  {
    return a(5, paramString, ExceptionUtil.a(paramThrowable));
  }

  public int b(String paramString1, String paramString2)
  {
    return a(3, paramString1, paramString2);
  }

  public int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(3, paramString1, paramString2 + '\n' + ExceptionUtil.a(paramThrowable));
  }

  public int c(String paramString1, String paramString2)
  {
    return a(4, paramString1, paramString2);
  }

  public int c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(4, paramString1, paramString2 + '\n' + ExceptionUtil.a(paramThrowable));
  }

  public int d(String paramString1, String paramString2)
  {
    return a(5, paramString1, paramString2);
  }

  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(5, paramString1, paramString2 + '\n' + ExceptionUtil.a(paramThrowable));
  }

  public int e(String paramString1, String paramString2)
  {
    return a(6, paramString1, paramString2);
  }

  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(6, paramString1, paramString2 + '\n' + ExceptionUtil.a(paramThrowable));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.FbLogImpl
 * JD-Core Version:    0.6.0
 */