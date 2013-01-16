package android_src.mms.util;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android_src.provider.Telephony.Mms.Rate;
import com.facebook.orca.debug.BLog;

public class RateController
{
  private static RateController a;
  private static boolean b;
  private final Context c;
  private int d;
  private final BroadcastReceiver e = new RateController.1(this);

  private RateController(Context paramContext)
  {
    this.c = paramContext;
  }

  public static RateController a()
  {
    if (a == null)
      throw new IllegalStateException("Uninitialized.");
    return a;
  }

  public static void a(Context paramContext)
  {
    if (a != null)
      BLog.d("RateController", "Already initialized.");
    a = new RateController(paramContext);
  }

  private int e()
  {
    monitorenter;
    int i = 0;
    try
    {
      while (true)
      {
        int j = this.d;
        if ((j == 0) && (i < 20000));
        try
        {
          wait(1000L);
          label27: i += 1000;
          continue;
          int k = this.d;
          monitorexit;
          return k;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label27;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final void b()
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("sent_time", Long.valueOf(System.currentTimeMillis()));
    SqliteWrapper.a(this.c, this.c.getContentResolver(), Telephony.Mms.Rate.a, localContentValues);
  }

  public final boolean c()
  {
    long l = System.currentTimeMillis() - 3600000L;
    Cursor localCursor = SqliteWrapper.a(this.c, this.c.getContentResolver(), Telephony.Mms.Rate.a, new String[] { "COUNT(*) AS rate" }, "sent_time>" + l, null, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        int j = localCursor.getInt(0);
        if (j >= 100);
        for (i = 1; ; i = 0)
          return i;
      }
      localCursor.close();
      int i = 0;
    }
    finally
    {
      localCursor.close();
    }
  }

  // ERROR //
  public boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 140	android_src/mms/util/RateController:b	Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +15 -> 24
    //   12: aload_0
    //   13: invokevirtual 142	java/lang/Object:wait	()V
    //   16: goto -12 -> 4
    //   19: astore 9
    //   21: goto -17 -> 4
    //   24: iconst_1
    //   25: putstatic 140	android_src/mms/util/RateController:b	Z
    //   28: aload_0
    //   29: getfield 28	android_src/mms/util/RateController:c	Landroid/content/Context;
    //   32: aload_0
    //   33: getfield 26	android_src/mms/util/RateController:e	Landroid/content/BroadcastReceiver;
    //   36: new 144	android/content/IntentFilter
    //   39: dup
    //   40: ldc 146
    //   42: invokespecial 147	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 151	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   48: pop
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 31	android_src/mms/util/RateController:d	I
    //   54: new 153	android/content/Intent
    //   57: dup
    //   58: ldc 155
    //   60: invokespecial 156	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   63: astore 5
    //   65: aload 5
    //   67: ldc 157
    //   69: invokevirtual 161	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   72: pop
    //   73: aload_0
    //   74: getfield 28	android_src/mms/util/RateController:c	Landroid/content/Context;
    //   77: aload 5
    //   79: invokevirtual 165	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   82: aload_0
    //   83: invokespecial 167	android_src/mms/util/RateController:e	()I
    //   86: istore 8
    //   88: iload 8
    //   90: iload_1
    //   91: if_icmpne +26 -> 117
    //   94: aload_0
    //   95: getfield 28	android_src/mms/util/RateController:c	Landroid/content/Context;
    //   98: aload_0
    //   99: getfield 26	android_src/mms/util/RateController:e	Landroid/content/BroadcastReceiver;
    //   102: invokevirtual 171	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   105: iconst_0
    //   106: putstatic 140	android_src/mms/util/RateController:b	Z
    //   109: aload_0
    //   110: invokevirtual 174	java/lang/Object:notifyAll	()V
    //   113: aload_0
    //   114: monitorexit
    //   115: iload_1
    //   116: ireturn
    //   117: iconst_0
    //   118: istore_1
    //   119: goto -25 -> 94
    //   122: astore 6
    //   124: aload_0
    //   125: getfield 28	android_src/mms/util/RateController:c	Landroid/content/Context;
    //   128: aload_0
    //   129: getfield 26	android_src/mms/util/RateController:e	Landroid/content/BroadcastReceiver;
    //   132: invokevirtual 171	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   135: iconst_0
    //   136: putstatic 140	android_src/mms/util/RateController:b	Z
    //   139: aload_0
    //   140: invokevirtual 174	java/lang/Object:notifyAll	()V
    //   143: aload 6
    //   145: athrow
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   12	16	19	java/lang/InterruptedException
    //   54	88	122	finally
    //   4	8	146	finally
    //   12	16	146	finally
    //   24	54	146	finally
    //   94	113	146	finally
    //   124	146	146	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.RateController
 * JD-Core Version:    0.6.0
 */