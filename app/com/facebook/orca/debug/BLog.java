package com.facebook.orca.debug;

import android.util.Log;
import com.facebook.debug.LogPrefixer;

public class BLog
{
  private static FbLog a;
  private static volatile int b = 2;

  public static void a(int paramInt)
  {
    b = paramInt;
  }

  public static void a(int paramInt, String paramString1, String paramString2)
  {
    if (b <= paramInt)
    {
      if (a == null)
        break label26;
      a.a(paramInt, paramString1, paramString2);
    }
    while (true)
    {
      return;
      label26: Log.println(paramInt, paramString1, paramString2);
    }
  }

  public static void a(FbLog paramFbLog)
  {
    a = paramFbLog;
  }

  public static void a(WtfToken paramWtfToken, Class<?> paramClass, String paramString)
  {
    if (b <= 6)
    {
      if (a == null)
        break label30;
      a.a(paramWtfToken, LogPrefixer.a(paramClass), paramString);
    }
    while (true)
    {
      return;
      label30: Log.wtf(LogPrefixer.a(paramClass), paramString);
    }
  }

  public static void a(WtfToken paramWtfToken, Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (b <= 6)
    {
      if (a == null)
        break label31;
      a.a(paramWtfToken, LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label31: Log.wtf(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
  }

  public static void a(WtfToken paramWtfToken, Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 6)
    {
      str = String.format(paramString, paramArrayOfObject);
      if (a == null)
        break label38;
      a.a(paramWtfToken, LogPrefixer.a(paramClass), str);
    }
    while (true)
    {
      return;
      label38: Log.wtf(LogPrefixer.a(paramClass), str);
    }
  }

  public static void a(WtfToken paramWtfToken, Class<?> paramClass, Throwable paramThrowable)
  {
    if (b <= 6)
    {
      if (a == null)
        break label30;
      a.a(paramWtfToken, LogPrefixer.a(paramClass), paramThrowable);
    }
    while (true)
    {
      return;
      label30: Log.wtf(LogPrefixer.a(paramClass), paramThrowable);
    }
  }

  public static void a(Class<?> paramClass, String paramString)
  {
    if (b <= 2)
    {
      if (a == null)
        break label28;
      a.a(LogPrefixer.a(paramClass), paramString);
    }
    while (true)
    {
      return;
      label28: Log.v(LogPrefixer.a(paramClass), paramString);
    }
  }

  public static void a(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (b <= 2)
    {
      if (a == null)
        break label29;
      a.a(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label29: Log.v(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
  }

  public static void a(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 2)
    {
      str = String.format(paramString, paramArrayOfObject);
      if (a == null)
        break label34;
      a.a(LogPrefixer.a(paramClass), str);
    }
    while (true)
    {
      return;
      label34: Log.v(LogPrefixer.a(paramClass), str);
    }
  }

  public static void a(Class<?> paramClass, Throwable paramThrowable)
  {
    if (b <= 5)
    {
      if (a == null)
        break label28;
      a.a(LogPrefixer.a(paramClass), paramThrowable);
    }
    while (true)
    {
      return;
      label28: Log.w(LogPrefixer.a(paramClass), paramThrowable);
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    if (b <= 2)
    {
      if (a == null)
        break label25;
      a.a(paramString1, paramString2);
    }
    while (true)
    {
      return;
      label25: Log.v(paramString1, paramString2);
    }
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b <= 3)
    {
      if (a == null)
        break label26;
      a.b(paramString1, paramString2, paramThrowable);
    }
    while (true)
    {
      return;
      label26: Log.d(paramString1, paramString2, paramThrowable);
    }
  }

  public static void a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 2)
    {
      str = String.format(paramString2, paramArrayOfObject);
      if (a == null)
        break label31;
      a.a(paramString1, str);
    }
    while (true)
    {
      return;
      label31: Log.v(paramString1, str);
    }
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    if (b <= 5)
    {
      if (a == null)
        break label25;
      a.a(paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label25: Log.w(paramString, paramThrowable);
    }
  }

  public static boolean a(String paramString, int paramInt)
  {
    if ((paramInt >= b) && (Log.isLoggable(paramString, paramInt)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static void b(int paramInt, String paramString1, String paramString2)
  {
    if (b <= paramInt)
    {
      if (a == null)
        break label26;
      a.a(paramInt, paramString1, paramString2);
    }
    while (true)
    {
      return;
      label26: Log.println(paramInt, paramString1, paramString2);
    }
  }

  public static void b(Class<?> paramClass, String paramString)
  {
    if (b <= 3)
    {
      if (a == null)
        break label28;
      a.b(LogPrefixer.a(paramClass), paramString);
    }
    while (true)
    {
      return;
      label28: Log.d(LogPrefixer.a(paramClass), paramString);
    }
  }

  public static void b(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (b <= 3)
    {
      if (a == null)
        break label29;
      a.b(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label29: Log.d(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
  }

  public static void b(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 3)
    {
      str = String.format(paramString, paramArrayOfObject);
      if (a == null)
        break label34;
      a.b(LogPrefixer.a(paramClass), str);
    }
    while (true)
    {
      return;
      label34: Log.d(LogPrefixer.a(paramClass), str);
    }
  }

  public static void b(String paramString1, String paramString2)
  {
    if (b <= 3)
    {
      if (a == null)
        break label25;
      a.b(paramString1, paramString2);
    }
    while (true)
    {
      return;
      label25: Log.d(paramString1, paramString2);
    }
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b <= 4)
    {
      if (a == null)
        break label26;
      a.c(paramString1, paramString2, paramThrowable);
    }
    while (true)
    {
      return;
      label26: Log.i(paramString1, paramString2, paramThrowable);
    }
  }

  public static boolean b(int paramInt)
  {
    if (paramInt >= b);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static void c(Class<?> paramClass, String paramString)
  {
    if (b <= 4)
    {
      if (a == null)
        break label28;
      a.c(LogPrefixer.a(paramClass), paramString);
    }
    while (true)
    {
      return;
      label28: Log.i(LogPrefixer.a(paramClass), paramString);
    }
  }

  public static void c(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (b <= 4)
    {
      if (a == null)
        break label29;
      a.c(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label29: Log.i(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
  }

  public static void c(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 4)
    {
      str = String.format(paramString, paramArrayOfObject);
      if (a == null)
        break label34;
      a.c(LogPrefixer.a(paramClass), str);
    }
    while (true)
    {
      return;
      label34: Log.i(LogPrefixer.a(paramClass), str);
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if (b <= 4)
    {
      if (a == null)
        break label25;
      a.c(paramString1, paramString2);
    }
    while (true)
    {
      return;
      label25: Log.i(paramString1, paramString2);
    }
  }

  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b <= 5)
    {
      if (a == null)
        break label26;
      a.d(paramString1, paramString2, paramThrowable);
    }
    while (true)
    {
      return;
      label26: Log.w(paramString1, paramString2, paramThrowable);
    }
  }

  public static void d(Class<?> paramClass, String paramString)
  {
    if (b <= 5)
    {
      if (a == null)
        break label28;
      a.d(LogPrefixer.a(paramClass), paramString);
    }
    while (true)
    {
      return;
      label28: Log.w(LogPrefixer.a(paramClass), paramString);
    }
  }

  public static void d(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (b <= 5)
    {
      if (a == null)
        break label29;
      a.d(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label29: Log.w(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
  }

  public static void d(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 5)
    {
      str = String.format(paramString, paramArrayOfObject);
      if (a == null)
        break label34;
      a.d(LogPrefixer.a(paramClass), str);
    }
    while (true)
    {
      return;
      label34: Log.w(LogPrefixer.a(paramClass), str);
    }
  }

  public static void d(String paramString1, String paramString2)
  {
    if (b <= 5)
    {
      if (a == null)
        break label25;
      a.d(paramString1, paramString2);
    }
    while (true)
    {
      return;
      label25: Log.w(paramString1, paramString2);
    }
  }

  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b <= 6)
    {
      if (a == null)
        break label27;
      a.e(paramString1, paramString2, paramThrowable);
    }
    while (true)
    {
      return;
      label27: Log.e(paramString1, paramString2, paramThrowable);
    }
  }

  public static void e(Class<?> paramClass, String paramString)
  {
    if (b <= 6)
    {
      if (a == null)
        break label29;
      a.e(LogPrefixer.a(paramClass), paramString);
    }
    while (true)
    {
      return;
      label29: Log.e(LogPrefixer.a(paramClass), paramString);
    }
  }

  public static void e(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (b <= 6)
    {
      if (a == null)
        break label30;
      a.e(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
    while (true)
    {
      return;
      label30: Log.e(LogPrefixer.a(paramClass), paramString, paramThrowable);
    }
  }

  public static void e(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (b <= 6)
    {
      str = String.format(paramString, paramArrayOfObject);
      if (a == null)
        break label35;
      a.e(LogPrefixer.a(paramClass), str);
    }
    while (true)
    {
      return;
      label35: Log.e(LogPrefixer.a(paramClass), str);
    }
  }

  public static void e(String paramString1, String paramString2)
  {
    if (b <= 6)
    {
      if (a == null)
        break label26;
      a.e(paramString1, paramString2);
    }
    while (true)
    {
      return;
      label26: Log.e(paramString1, paramString2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.BLog
 * JD-Core Version:    0.6.0
 */