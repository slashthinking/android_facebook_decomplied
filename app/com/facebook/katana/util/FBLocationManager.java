package com.facebook.katana.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import com.facebook.common.util.Log;

public class FBLocationManager
{
  protected static volatile ReentrantCallback<FBLocationManager.FBLocationListener> a;
  protected static FBLocationManager.LocationDispatcher b;
  protected static volatile LocationManager c;
  protected static volatile Runnable d;
  private static Handler e = new Handler();
  private static Runnable f;

  public static Location a(int paramInt)
  {
    if ((b != null) && (b.c != null) && (System.currentTimeMillis() - b.c.getTime() <= paramInt));
    for (Location localLocation = b.c; ; localLocation = null)
      return localLocation;
  }

  // ERROR //
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   6: ifnonnull +9 -> 15
    //   9: ldc 2
    //   11: monitorexit
    //   12: goto +133 -> 145
    //   15: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   18: invokevirtual 52	com/facebook/katana/util/ReentrantCallback:b	()I
    //   21: istore_1
    //   22: aconst_null
    //   23: astore_2
    //   24: iload_1
    //   25: ifeq +95 -> 120
    //   28: new 54	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 55	java/util/ArrayList:<init>	()V
    //   35: astore_3
    //   36: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   39: invokevirtual 58	com/facebook/katana/util/ReentrantCallback:a	()Ljava/util/Set;
    //   42: invokeinterface 64 1 0
    //   47: astore 4
    //   49: aload 4
    //   51: invokeinterface 70 1 0
    //   56: ifeq +32 -> 88
    //   59: aload_3
    //   60: aload 4
    //   62: invokeinterface 74 1 0
    //   67: checkcast 76	com/facebook/katana/util/FBLocationManager$FBLocationListener
    //   70: invokevirtual 80	java/lang/Object:toString	()Ljava/lang/String;
    //   73: invokeinterface 86 2 0
    //   78: pop
    //   79: goto -30 -> 49
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    //   88: new 88	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   95: ldc 91
    //   97: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 97
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: aastore
    //   110: invokestatic 102	com/facebook/katana/util/StringUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_2
    //   120: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   123: invokevirtual 105	com/facebook/katana/util/ReentrantCallback:c	()V
    //   126: getstatic 29	com/facebook/katana/util/FBLocationManager:b	Lcom/facebook/katana/util/FBLocationManager$LocationDispatcher;
    //   129: invokevirtual 107	com/facebook/katana/util/FBLocationManager$LocationDispatcher:b	()V
    //   132: ldc 2
    //   134: monitorexit
    //   135: aload_2
    //   136: ifnull +9 -> 145
    //   139: ldc 109
    //   141: aload_2
    //   142: invokestatic 114	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: return
    //
    // Exception table:
    //   from	to	target	type
    //   3	86	82	finally
    //   88	135	82	finally
  }

  public static void a(Context paramContext)
  {
    if ((c == null) || (b == null))
    {
      monitorenter;
      try
      {
        if (c == null)
          c = (LocationManager)paramContext.getSystemService("location");
        if (b == null)
          b = new FBLocationManager.LocationDispatcher();
        monitorexit;
      }
      finally
      {
        localObject = finally;
        monitorexit;
        throw localObject;
      }
    }
  }

  public static void a(Context paramContext, FBLocationManager.FBLocationListener paramFBLocationListener)
  {
    a(paramContext);
    monitorenter;
    try
    {
      if (a == null)
        a = new ReentrantCallback();
      a.a(paramFBLocationListener);
      b.a();
      if (b.c != null)
        paramFBLocationListener.a(b.c);
      if (f != null)
        e.removeCallbacks(f);
      if (d == null)
      {
        FBLocationManager.1 local1 = new FBLocationManager.1();
        d = local1;
        e.postDelayed(local1, 30000L);
      }
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
  public static void a(FBLocationManager.FBLocationListener paramFBLocationListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   6: ifnonnull +9 -> 15
    //   9: ldc 2
    //   11: monitorexit
    //   12: goto +97 -> 109
    //   15: getstatic 29	com/facebook/katana/util/FBLocationManager:b	Lcom/facebook/katana/util/FBLocationManager$LocationDispatcher;
    //   18: invokestatic 161	com/facebook/debug/Assert:a	(Ljava/lang/Object;)V
    //   21: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   24: aload_0
    //   25: invokevirtual 163	com/facebook/katana/util/ReentrantCallback:b	(Ljava/lang/Object;)V
    //   28: getstatic 47	com/facebook/katana/util/FBLocationManager:a	Lcom/facebook/katana/util/ReentrantCallback;
    //   31: invokevirtual 52	com/facebook/katana/util/ReentrantCallback:b	()I
    //   34: ifne +54 -> 88
    //   37: getstatic 29	com/facebook/katana/util/FBLocationManager:b	Lcom/facebook/katana/util/FBLocationManager$LocationDispatcher;
    //   40: getfield 166	com/facebook/katana/util/FBLocationManager$LocationDispatcher:b	Z
    //   43: ifeq +57 -> 100
    //   46: new 168	com/facebook/katana/util/FBLocationManager$2
    //   49: dup
    //   50: invokespecial 169	com/facebook/katana/util/FBLocationManager$2:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: putstatic 142	com/facebook/katana/util/FBLocationManager:f	Ljava/lang/Runnable;
    //   58: getstatic 25	com/facebook/katana/util/FBLocationManager:e	Landroid/os/Handler;
    //   61: aload_2
    //   62: ldc2_w 170
    //   65: invokevirtual 157	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   68: pop
    //   69: getstatic 148	com/facebook/katana/util/FBLocationManager:d	Ljava/lang/Runnable;
    //   72: ifnull +16 -> 88
    //   75: getstatic 25	com/facebook/katana/util/FBLocationManager:e	Landroid/os/Handler;
    //   78: getstatic 148	com/facebook/katana/util/FBLocationManager:d	Ljava/lang/Runnable;
    //   81: invokevirtual 146	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   84: aconst_null
    //   85: putstatic 148	com/facebook/katana/util/FBLocationManager:d	Ljava/lang/Runnable;
    //   88: ldc 2
    //   90: monitorexit
    //   91: goto +18 -> 109
    //   94: astore_1
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: getstatic 29	com/facebook/katana/util/FBLocationManager:b	Lcom/facebook/katana/util/FBLocationManager$LocationDispatcher;
    //   103: invokevirtual 107	com/facebook/katana/util/FBLocationManager$LocationDispatcher:b	()V
    //   106: goto -18 -> 88
    //   109: return
    //
    // Exception table:
    //   from	to	target	type
    //   3	98	94	finally
    //   100	106	94	finally
  }

  protected static boolean a(Location paramLocation)
  {
    if ((paramLocation != null) && (System.currentTimeMillis() - paramLocation.getTime() <= 90000L));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected static boolean a(Location paramLocation1, Location paramLocation2)
  {
    int i = 1;
    if (paramLocation2 == null);
    label29: label40: int m;
    label70: label76: label80: 
    while (true)
    {
      return i;
      long l = paramLocation1.getTime() - paramLocation2.getTime();
      int j;
      int k;
      if (l > 120000L)
      {
        j = i;
        if (l >= -120000L)
          break label70;
        k = i;
        if (l <= 0L)
          break label76;
      }
      for (m = i; ; m = 0)
      {
        if (j != 0)
          break label80;
        if (k == 0)
          break label82;
        i = 0;
        break;
        j = 0;
        break label29;
        k = 0;
        break label40;
      }
    }
    label82: int n = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    int i1;
    label102: int i2;
    if (n > 0)
    {
      i1 = i;
      if (n >= 0)
        break label175;
      i2 = i;
      label110: if (n <= 200)
        break label181;
    }
    label175: label181: for (int i3 = i; ; i3 = 0)
    {
      boolean bool = StringUtils.a(paramLocation1.getProvider(), paramLocation2.getProvider());
      if ((i2 != 0) || ((m != 0) && (i1 == 0)) || ((m != 0) && (i3 == 0) && (bool)))
        break;
      i = 0;
      break;
      i1 = 0;
      break label102;
      i2 = 0;
      break label110;
    }
  }

  public static boolean b(Context paramContext)
  {
    if ((c(paramContext)) || (d(paramContext)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean c(Context paramContext)
  {
    a(paramContext);
    try
    {
      LocationManager localLocationManager = c;
      i = 0;
      if (localLocationManager != null)
      {
        boolean bool = c.isProviderEnabled("gps");
        i = 0;
        if (bool)
          i = 1;
      }
      return i;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        Log.b("LOCATION", "Caught IllegalArgumentException while checking GPS state");
        int i = 0;
      }
    }
  }

  public static boolean d(Context paramContext)
  {
    a(paramContext);
    try
    {
      LocationManager localLocationManager = c;
      i = 0;
      if (localLocationManager != null)
      {
        boolean bool = c.isProviderEnabled("network");
        i = 0;
        if (bool)
          i = 1;
      }
      return i;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        Log.b("LOCATION", "Caught IllegalArgumentException while checking network state");
        int i = 0;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FBLocationManager
 * JD-Core Version:    0.6.0
 */