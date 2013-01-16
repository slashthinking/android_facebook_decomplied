package com.facebook.orca.app;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UserInteractionController
{
  private static final Class<?> a = UserInteractionController.class;
  private final AndroidThreadUtil b;
  private final UserInteractionController.ActivityListener c;
  private final WeakHashMap<View, Boolean> d;
  private final WeakHashMap<UserInteractionListener, Boolean> e;
  private Handler f;
  private boolean g;
  private Object h = new Object();
  private Object i = new Object();
  private List<UserInteractionListener> j;

  public UserInteractionController(AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = paramAndroidThreadUtil;
    this.c = new UserInteractionController.ActivityListener(this);
    this.d = new WeakHashMap();
    this.e = new WeakHashMap();
    this.f = new Handler(Looper.getMainLooper(), new UserInteractionController.1(this));
    this.j = Lists.a();
  }

  private void d()
  {
    synchronized (this.h)
    {
      if (b() != this.g)
        this.f.sendEmptyMessageDelayed(0, 100L);
      return;
    }
  }

  // ERROR //
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/facebook/orca/app/UserInteractionController:b	Lcom/facebook/orca/common/util/AndroidThreadUtil;
    //   4: invokeinterface 96 1 0
    //   9: aload_0
    //   10: getfield 36	com/facebook/orca/app/UserInteractionController:h	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: invokevirtual 84	com/facebook/orca/app/UserInteractionController:b	()Z
    //   20: istore_3
    //   21: iload_3
    //   22: aload_0
    //   23: getfield 86	com/facebook/orca/app/UserInteractionController:g	Z
    //   26: if_icmpeq +155 -> 181
    //   29: aload_0
    //   30: iload_3
    //   31: putfield 86	com/facebook/orca/app/UserInteractionController:g	Z
    //   34: iconst_1
    //   35: istore 4
    //   37: iload_3
    //   38: istore 5
    //   40: aload_1
    //   41: monitorexit
    //   42: iload 4
    //   44: ifeq +136 -> 180
    //   47: aload_0
    //   48: getfield 77	com/facebook/orca/app/UserInteractionController:j	Ljava/util/List;
    //   51: invokeinterface 101 1 0
    //   56: aload_0
    //   57: getfield 38	com/facebook/orca/app/UserInteractionController:i	Ljava/lang/Object;
    //   60: astore 6
    //   62: aload 6
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 54	com/facebook/orca/app/UserInteractionController:e	Ljava/util/WeakHashMap;
    //   69: invokevirtual 105	java/util/WeakHashMap:keySet	()Ljava/util/Set;
    //   72: invokeinterface 111 1 0
    //   77: astore 8
    //   79: aload 8
    //   81: invokeinterface 116 1 0
    //   86: ifeq +43 -> 129
    //   89: aload 8
    //   91: invokeinterface 120 1 0
    //   96: checkcast 122	com/facebook/orca/app/UserInteractionListener
    //   99: astore 10
    //   101: aload_0
    //   102: getfield 77	com/facebook/orca/app/UserInteractionController:j	Ljava/util/List;
    //   105: aload 10
    //   107: invokeinterface 126 2 0
    //   112: pop
    //   113: goto -34 -> 79
    //   116: astore 7
    //   118: aload 6
    //   120: monitorexit
    //   121: aload 7
    //   123: athrow
    //   124: astore_2
    //   125: aload_1
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: aload 6
    //   131: monitorexit
    //   132: aload_0
    //   133: getfield 77	com/facebook/orca/app/UserInteractionController:j	Ljava/util/List;
    //   136: invokeinterface 127 1 0
    //   141: astore 9
    //   143: aload 9
    //   145: invokeinterface 116 1 0
    //   150: ifeq +21 -> 171
    //   153: aload 9
    //   155: invokeinterface 120 1 0
    //   160: checkcast 122	com/facebook/orca/app/UserInteractionListener
    //   163: iload 5
    //   165: invokevirtual 130	com/facebook/orca/app/UserInteractionListener:a	(Z)V
    //   168: goto -25 -> 143
    //   171: aload_0
    //   172: getfield 77	com/facebook/orca/app/UserInteractionController:j	Ljava/util/List;
    //   175: invokeinterface 101 1 0
    //   180: return
    //   181: iconst_0
    //   182: istore 4
    //   184: iconst_0
    //   185: istore 5
    //   187: goto -147 -> 40
    //
    // Exception table:
    //   from	to	target	type
    //   65	121	116	finally
    //   129	132	116	finally
    //   16	42	124	finally
    //   125	127	124	finally
  }

  public UserInteractionController.ActivityListener a()
  {
    return this.c;
  }

  public void a(long paramLong)
  {
    this.b.b();
    Semaphore localSemaphore = new Semaphore(0);
    UserInteractionController.2 local2 = new UserInteractionController.2(this, localSemaphore);
    try
    {
      long l1 = System.currentTimeMillis();
      a(local2);
      if (!localSemaphore.tryAcquire(paramLong, TimeUnit.MILLISECONDS))
        BLog.b(a, "User is interacting with UI. Unblock data processing anyway.");
      long l2 = System.currentTimeMillis() - l1;
      if (l2 > 10L)
        BLog.b(a, "User interaction blocked data processing for " + l2 + " ms.");
      b(local2);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        BLog.e(a, "Exception when the user interaction to be finished.", localInterruptedException);
    }
  }

  public void a(View paramView)
  {
    this.b.a();
    synchronized (this.h)
    {
      this.d.put(paramView, Boolean.TRUE);
      e();
      return;
    }
  }

  public void a(UserInteractionListener paramUserInteractionListener)
  {
    synchronized (this.i)
    {
      this.e.put(paramUserInteractionListener, Boolean.TRUE);
      paramUserInteractionListener.a(b());
      return;
    }
  }

  public void b(View paramView)
  {
    this.b.a();
    synchronized (this.h)
    {
      this.d.remove(paramView);
      d();
      return;
    }
  }

  public void b(UserInteractionListener paramUserInteractionListener)
  {
    synchronized (this.i)
    {
      this.e.remove(paramUserInteractionListener);
      return;
    }
  }

  public boolean b()
  {
    while (true)
    {
      synchronized (this.h)
      {
        if (!this.d.isEmpty())
        {
          k = 1;
          return k;
        }
      }
      int k = 0;
    }
  }

  public void c()
  {
    a(10000L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.UserInteractionController
 * JD-Core Version:    0.6.0
 */