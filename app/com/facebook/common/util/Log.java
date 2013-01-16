package com.facebook.common.util;

import com.facebook.base.BuildConstants;
import com.facebook.debug.LogPrefixer;

public class Log
{
  private static final int a = "com.facebook.".length();
  private static final String b = Log.class.getName();

  private static String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    for (int i = 0; (i < arrayOfStackTraceElement.length) && (!b.equals(arrayOfStackTraceElement[i].getClassName())); i++);
    for (int j = i + 1; (j < arrayOfStackTraceElement.length) && (b.equals(arrayOfStackTraceElement[j].getClassName())); j++);
    if (j >= arrayOfStackTraceElement.length);
    StackTraceElement localStackTraceElement;
    String str1;
    for (String str2 = "unknown"; ; str2 = str1 + "." + localStackTraceElement.getMethodName() + ":" + localStackTraceElement.getLineNumber())
    {
      return str2;
      localStackTraceElement = Thread.currentThread().getStackTrace()[j];
      str1 = localStackTraceElement.getClassName();
      int k = str1.indexOf('.', a);
      if (k == -1)
        continue;
      str1 = str1.substring(k + 1);
    }
  }

  public static void a(Class<?> paramClass, String paramString)
  {
    if (BuildConstants.a())
      android.util.Log.e(LogPrefixer.a(paramClass), paramString);
  }

  public static void a(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.e(LogPrefixer.a(paramClass), paramString, paramThrowable);
  }

  public static void a(String paramString)
  {
    if (BuildConstants.a())
      a(a(), paramString);
  }

  public static void a(String paramString1, String paramString2)
  {
    if (BuildConstants.a())
      android.util.Log.e(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.e(paramString1, paramString2, paramThrowable);
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      a(a(), paramString, paramThrowable);
  }

  public static boolean a(Class<?> paramClass, int paramInt)
  {
    if (BuildConstants.a());
    while (true)
    {
      try
      {
        boolean bool2 = android.util.Log.isLoggable(LogPrefixer.a(paramClass), paramInt);
        bool1 = bool2;
        return bool1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        bool1 = true;
        continue;
      }
      boolean bool1 = false;
    }
  }

  public static boolean a(String paramString, int paramInt)
  {
    if (BuildConstants.a());
    while (true)
    {
      try
      {
        boolean bool2 = android.util.Log.isLoggable(paramString, paramInt);
        bool1 = bool2;
        return bool1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        bool1 = true;
        continue;
      }
      boolean bool1 = false;
    }
  }

  public static void b(Class<?> paramClass, String paramString)
  {
    if (BuildConstants.a())
      android.util.Log.w(LogPrefixer.a(paramClass), paramString);
  }

  public static void b(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.w(LogPrefixer.a(paramClass), paramString, paramThrowable);
  }

  public static void b(String paramString)
  {
    if (BuildConstants.a())
      b(a(), paramString);
  }

  public static void b(String paramString1, String paramString2)
  {
    if (BuildConstants.a())
      android.util.Log.w(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.w(paramString1, paramString2, paramThrowable);
  }

  public static void b(String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      a(a(), paramString, paramThrowable);
  }

  public static void c(Class<?> paramClass, String paramString)
  {
    if (BuildConstants.a())
      android.util.Log.i(LogPrefixer.a(paramClass), paramString);
  }

  public static void c(Class<?> paramClass, String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.d(LogPrefixer.a(paramClass), paramString, paramThrowable);
  }

  public static void c(String paramString)
  {
    if (BuildConstants.a())
      c(a(), paramString);
  }

  public static void c(String paramString1, String paramString2)
  {
    if (BuildConstants.a())
      android.util.Log.i(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.v(paramString1, paramString2, paramThrowable);
  }

  public static void c(String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      a(a(), paramString, paramThrowable);
  }

  public static void d(Class<?> paramClass, String paramString)
  {
    if (BuildConstants.a())
      android.util.Log.v(LogPrefixer.a(paramClass), paramString);
  }

  public static void d(String paramString)
  {
    if (BuildConstants.a())
      d(a(), paramString);
  }

  public static void d(String paramString1, String paramString2)
  {
    if (BuildConstants.a())
      android.util.Log.v(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (BuildConstants.a())
      android.util.Log.d(paramString1, paramString2, paramThrowable);
  }

  public static void e(Class<?> paramClass, String paramString)
  {
    if (BuildConstants.a())
      android.util.Log.d(LogPrefixer.a(paramClass), paramString);
  }

  public static void e(String paramString)
  {
    if (BuildConstants.a())
      e(a(), paramString);
  }

  public static void e(String paramString1, String paramString2)
  {
    if (BuildConstants.a())
      android.util.Log.d(paramString1, paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.Log
 * JD-Core Version:    0.6.0
 */