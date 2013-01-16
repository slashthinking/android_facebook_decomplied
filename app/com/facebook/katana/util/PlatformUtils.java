package com.facebook.katana.util;

import android.content.Context;
import android.os.Build;
import com.facebook.katana.platform.PlatformStorage;

public final class PlatformUtils
{
  private static boolean a = false;
  private static boolean b;

  public static boolean a()
  {
    return "sdk".equals(Build.MODEL);
  }

  // ERROR //
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 11	com/facebook/katana/util/PlatformUtils:a	Z
    //   6: ifeq +12 -> 18
    //   9: getstatic 34	com/facebook/katana/util/PlatformUtils:b	Z
    //   12: istore_3
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: iconst_0
    //   19: putstatic 34	com/facebook/katana/util/PlatformUtils:b	Z
    //   22: aload_0
    //   23: invokestatic 38	com/facebook/katana/platform/PlatformStorage:a	(Landroid/content/Context;)Z
    //   26: putstatic 34	com/facebook/katana/util/PlatformUtils:b	Z
    //   29: iconst_1
    //   30: putstatic 11	com/facebook/katana/util/PlatformUtils:a	Z
    //   33: getstatic 34	com/facebook/katana/util/PlatformUtils:b	Z
    //   36: istore_3
    //   37: goto -24 -> 13
    //   40: astore_1
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_2
    //   47: goto -18 -> 29
    //
    // Exception table:
    //   from	to	target	type
    //   3	13	40	finally
    //   18	22	40	finally
    //   22	29	40	finally
    //   29	37	40	finally
    //   22	29	46	java/lang/Exception
  }

  public static void b(Context paramContext)
  {
    if (!a(paramContext));
    try
    {
      PlatformStorage.b(paramContext);
      label11: return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.PlatformUtils
 * JD-Core Version:    0.6.0
 */