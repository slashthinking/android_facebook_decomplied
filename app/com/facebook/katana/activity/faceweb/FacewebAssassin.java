package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FacewebAssassin
  implements Runnable
{
  private static List<FacewebAssassin.FacewebFragmentRecord> a = new ArrayList();
  private final Handler b;
  private final FacewebAssassin.AssassinFilter c;

  protected FacewebAssassin(Handler paramHandler, FacewebAssassin.AssassinFilter paramAssassinFilter)
  {
    this.b = paramHandler;
    this.c = paramAssassinFilter;
  }

  public static FacewebAssassin a(Handler paramHandler, FacewebAssassin.AssassinFilter paramAssassinFilter, int paramInt)
  {
    FacewebAssassin localFacewebAssassin;
    if (paramAssassinFilter.a(a.size()))
    {
      localFacewebAssassin = new FacewebAssassin(paramHandler, paramAssassinFilter);
      paramHandler.postDelayed(localFacewebAssassin, paramInt);
    }
    while (true)
    {
      return localFacewebAssassin;
      localFacewebAssassin = null;
    }
  }

  public static final void a()
  {
    new Handler(Looper.getMainLooper()).post(new FacewebAssassin.1());
  }

  static final void a(FacewebFragment paramFacewebFragment)
  {
    synchronized (a)
    {
      a.add(new FacewebAssassin.FacewebFragmentRecord(paramFacewebFragment));
      return;
    }
  }

  // ERROR //
  static final void b(FacewebFragment paramFacewebFragment)
  {
    // Byte code:
    //   0: getstatic 22	com/facebook/katana/activity/faceweb/FacewebAssassin:a	Ljava/util/List;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 22	com/facebook/katana/activity/faceweb/FacewebAssassin:a	Ljava/util/List;
    //   9: invokeinterface 77 1 0
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 83 1 0
    //   21: ifeq +48 -> 69
    //   24: aload_3
    //   25: invokeinterface 87 1 0
    //   30: checkcast 67	com/facebook/katana/activity/faceweb/FacewebAssassin$FacewebFragmentRecord
    //   33: getfield 90	com/facebook/katana/activity/faceweb/FacewebAssassin$FacewebFragmentRecord:a	Ljava/lang/ref/WeakReference;
    //   36: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   39: checkcast 97	com/facebook/katana/activity/faceweb/FacewebFragment
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +9 -> 55
    //   49: aload 4
    //   51: aload_0
    //   52: if_acmpne -37 -> 15
    //   55: aload_3
    //   56: invokeinterface 100 1 0
    //   61: goto -46 -> 15
    //   64: astore_2
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    //   69: aload_1
    //   70: monitorexit
    //   71: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	67	64	finally
    //   69	71	64	finally
  }

  public void b()
  {
    this.b.removeCallbacks(this);
  }

  public void run()
  {
    while (true)
    {
      Object localObject2;
      FacewebFragment localFacewebFragment;
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        localObject2 = null;
        if ((!localIterator.hasNext()) || (localObject2 != null))
          continue;
        localObject4 = (FacewebAssassin.FacewebFragmentRecord)localIterator.next();
        if (((FacewebAssassin.FacewebFragmentRecord)localObject4).a == null)
          break label173;
        if (!this.c.a(SystemClock.elapsedRealtime() - ((FacewebAssassin.FacewebFragmentRecord)localObject4).b))
          continue;
        localIterator.remove();
        localObject2 = localObject4;
        continue;
        if (localObject2 != null)
          continue;
      }
      if (localFacewebFragment == null)
        break;
      localFacewebFragment.L();
      synchronized (a)
      {
        int i = a.size();
        if (i <= 3)
          break;
        this.b.postDelayed(this, 1000L);
      }
      label173: Object localObject4 = localObject2;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebAssassin
 * JD-Core Version:    0.6.0
 */