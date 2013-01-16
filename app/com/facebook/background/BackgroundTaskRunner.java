package com.facebook.background;

import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.app.UserActivityManager;
import com.facebook.common.collect.TopologicalSort;
import com.facebook.common.collect.TopologicalSort.Node;
import com.facebook.common.util.HandlerExecutorService;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.app.UserInteractionListener;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;

public class BackgroundTaskRunner
  implements BackgroundTaskRunnerCallback
{
  private static Class<?> a = BackgroundTaskRunner.class;
  private static final WtfToken b = new WtfToken();
  private final Handler c;
  private final Clock d;
  private final Executor e;
  private final UserInteractionController f;
  private final UserActivityManager g;
  private final LocalBroadcastManager h;
  private final ImmutableMap<String, BackgroundTaskRunner.TaskInfo> i;
  private final ImmutableList<BackgroundTaskRunner.TaskInfo> j;
  private final ConcurrentMap<Class<? extends Annotation>, Boolean> k;
  private final Object l = new Object();
  private final UserInteractionListener m;
  private final BackgroundTaskRunner.ReentrantLockWithUiThreadCheck n;
  private int o;
  private BackgroundTaskRunner.TaskInfo p;
  private Runnable q;
  private long r;
  private boolean s;
  private boolean t;

  public BackgroundTaskRunner(UserInteractionController paramUserInteractionController, UserActivityManager paramUserActivityManager, LocalBroadcastManager paramLocalBroadcastManager, Set<BackgroundTask> paramSet, AndroidThreadUtil paramAndroidThreadUtil, Handler paramHandler, Clock paramClock)
  {
    if (!paramSet.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.f = paramUserInteractionController;
      this.g = paramUserActivityManager;
      this.h = paramLocalBroadcastManager;
      this.c = paramHandler;
      this.d = paramClock;
      this.e = new HandlerExecutorService(paramHandler);
      this.k = Maps.c();
      this.n = new BackgroundTaskRunner.ReentrantLockWithUiThreadCheck(paramAndroidThreadUtil);
      this.j = a(paramSet);
      this.i = a(this.j);
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
        ((BackgroundTaskRunner.TaskInfo)localIterator.next()).a.a(this);
    }
    this.o = 0;
    this.r = 100L;
    this.m = new BackgroundTaskRunner.1(this);
    this.f.a(this.m);
    this.h.a(new BackgroundTaskRunner.2(this), new IntentFilter("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE"));
    this.t = this.g.a();
  }

  private static long a(long paramLong)
  {
    long l1;
    if (paramLong == 100L)
      l1 = 30000L;
    while (true)
    {
      return Math.min(l1, 300000L);
      l1 = 2L * paramLong;
    }
  }

  private ImmutableList<BackgroundTaskRunner.TaskInfo> a(Set<BackgroundTask> paramSet)
  {
    ImmutableList localImmutableList = TopologicalSort.a(b(paramSet));
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localImmutableList.iterator();
    while (localIterator.hasNext())
      localBuilder.b(new BackgroundTaskRunner.TaskInfo((BackgroundTask)((TopologicalSort.Node)localIterator.next()).a, null));
    return localBuilder.b();
  }

  private ImmutableMap<String, BackgroundTaskRunner.TaskInfo> a(ImmutableList<BackgroundTaskRunner.TaskInfo> paramImmutableList)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
    {
      BackgroundTaskRunner.TaskInfo localTaskInfo = (BackgroundTaskRunner.TaskInfo)localIterator.next();
      localBuilder.b(localTaskInfo.a.f(), localTaskInfo);
    }
    return localBuilder.b();
  }

  // ERROR //
  private void a(int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: getfield 64	com/facebook/background/BackgroundTaskRunner:l	Ljava/lang/Object;
    //   6: astore 4
    //   8: aload 4
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 246	com/facebook/background/BackgroundTaskRunner:s	Z
    //   15: ifeq +16 -> 31
    //   18: aload_0
    //   19: getfield 243	com/facebook/background/BackgroundTaskRunner:q	Ljava/lang/Runnable;
    //   22: ifnull +9 -> 31
    //   25: aload 4
    //   27: monitorexit
    //   28: goto +107 -> 135
    //   31: aload_0
    //   32: getfield 243	com/facebook/background/BackgroundTaskRunner:q	Ljava/lang/Runnable;
    //   35: ifnull +101 -> 136
    //   38: aload_0
    //   39: getfield 84	com/facebook/background/BackgroundTaskRunner:c	Landroid/os/Handler;
    //   42: aload_0
    //   43: getfield 243	com/facebook/background/BackgroundTaskRunner:q	Ljava/lang/Runnable;
    //   46: invokevirtual 252	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 243	com/facebook/background/BackgroundTaskRunner:q	Ljava/lang/Runnable;
    //   54: goto +82 -> 136
    //   57: new 254	java/lang/IllegalStateException
    //   60: dup
    //   61: invokespecial 255	java/lang/IllegalStateException:<init>	()V
    //   64: athrow
    //   65: astore 5
    //   67: aload 4
    //   69: monitorexit
    //   70: aload 5
    //   72: athrow
    //   73: aload_0
    //   74: getfield 148	com/facebook/background/BackgroundTaskRunner:r	J
    //   77: lstore_2
    //   78: aload_0
    //   79: new 257	com/facebook/background/BackgroundTaskRunner$3
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 258	com/facebook/background/BackgroundTaskRunner$3:<init>	(Lcom/facebook/background/BackgroundTaskRunner;)V
    //   87: putfield 243	com/facebook/background/BackgroundTaskRunner:q	Ljava/lang/Runnable;
    //   90: aload_0
    //   91: getfield 84	com/facebook/background/BackgroundTaskRunner:c	Landroid/os/Handler;
    //   94: aload_0
    //   95: getfield 243	com/facebook/background/BackgroundTaskRunner:q	Ljava/lang/Runnable;
    //   98: lload_2
    //   99: invokevirtual 262	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   102: pop
    //   103: aload 4
    //   105: monitorexit
    //   106: goto +29 -> 135
    //   109: lconst_0
    //   110: aload_0
    //   111: invokespecial 265	com/facebook/background/BackgroundTaskRunner:g	()J
    //   114: aload_0
    //   115: getfield 86	com/facebook/background/BackgroundTaskRunner:d	Lcom/facebook/orca/common/util/Clock;
    //   118: invokeinterface 269 1 0
    //   123: lsub
    //   124: invokestatic 272	java/lang/Math:max	(JJ)J
    //   127: lstore 6
    //   129: lload 6
    //   131: lstore_2
    //   132: goto -54 -> 78
    //   135: return
    //   136: iload_1
    //   137: tableswitch	default:+-80 -> 57, 1:+-59->78, 2:+-64->73, 3:+-28->109
    //
    // Exception table:
    //   from	to	target	type
    //   11	70	65	finally
    //   73	129	65	finally
  }

  private void a(BackgroundResult paramBackgroundResult)
  {
    boolean bool = true;
    this.n.a();
    try
    {
      BackgroundTaskRunner.TaskInfo localTaskInfo = this.p;
      this.p = null;
      BLog.b(a, "Task completed successfully");
      if (!paramBackgroundResult.a);
      while (true)
      {
        localTaskInfo.b = bool;
        synchronized (this.l)
        {
          if (paramBackgroundResult.a)
          {
            this.r = 100L;
            this.s = false;
            a(2);
            this.n.b();
            return;
            bool = false;
            continue;
          }
          this.r = a(this.r);
          this.s = true;
        }
      }
    }
    finally
    {
      this.n.b();
    }
    throw localObject1;
  }

  private void a(Throwable paramThrowable)
  {
    this.n.a();
    try
    {
      BackgroundTaskRunner.TaskInfo localTaskInfo = this.p;
      this.p = null;
      BLog.a(b, a, "Task " + localTaskInfo.a.f() + " threw exeption", paramThrowable);
      localTaskInfo.b = true;
      synchronized (this.l)
      {
        this.r = a(this.r);
        this.s = true;
        a(2);
        this.n.b();
        return;
      }
    }
    finally
    {
      this.n.b();
    }
    throw localObject1;
  }

  private boolean a(BackgroundTaskRunner.TaskInfo paramTaskInfo)
  {
    if (!b(paramTaskInfo));
    for (boolean bool = false; ; bool = paramTaskInfo.a.b())
      return bool;
  }

  private Collection<TopologicalSort.Node<BackgroundTask>> b(Set<BackgroundTask> paramSet)
  {
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      BackgroundTask localBackgroundTask = (BackgroundTask)localIterator1.next();
      localHashMap.put(localBackgroundTask.f(), new TopologicalSort.Node(localBackgroundTask));
    }
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      TopologicalSort.Node localNode1 = (TopologicalSort.Node)localIterator2.next();
      Iterator localIterator3 = ((BackgroundTask)localNode1.a).g().iterator();
      while (localIterator3.hasNext())
      {
        String str = (String)localIterator3.next();
        TopologicalSort.Node localNode2 = (TopologicalSort.Node)localHashMap.get(str);
        if (localNode2 == null)
          throw new IllegalArgumentException("Missing node for dependency: " + str);
        localNode2.a(localNode1);
      }
    }
    return localHashMap.values();
  }

  private boolean b(BackgroundTaskRunner.TaskInfo paramTaskInfo)
  {
    Iterator localIterator1 = paramTaskInfo.a.g().iterator();
    int i1;
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if (!((BackgroundTaskRunner.TaskInfo)this.i.get(str)).b)
        continue;
      i1 = 0;
    }
    while (true)
    {
      return i1;
      Iterator localIterator2 = paramTaskInfo.a.a().iterator();
      while (true)
        if (localIterator2.hasNext())
        {
          Class localClass = (Class)localIterator2.next();
          if (!this.k.containsKey(localClass))
            continue;
          i1 = 0;
          break;
        }
      i1 = 1;
    }
  }

  private void d()
  {
    this.n.a();
    try
    {
      BackgroundTaskRunner.TaskInfo localTaskInfo = this.p;
      if (localTaskInfo != null);
      while (true)
      {
        return;
        boolean bool = this.f.b();
        if (!bool)
          break;
        this.n.b();
      }
      ListenableFuture localListenableFuture = e();
      if (localListenableFuture != null)
        Futures.a(localListenableFuture, new BackgroundTaskRunner.4(this), this.e);
      while (true)
      {
        this.n.b();
        break;
        a(3);
      }
    }
    finally
    {
      this.n.b();
    }
    throw localObject;
  }

  private ListenableFuture<BackgroundResult> e()
  {
    Preconditions.checkState(this.n.c());
    int i1 = 0;
    BackgroundTaskRunner.TaskInfo localTaskInfo;
    Object localObject;
    if (i1 < this.j.size())
    {
      localTaskInfo = f();
      if (localTaskInfo == null)
      {
        BLog.b(a, "No more tasks to run");
        localObject = null;
      }
    }
    while (true)
    {
      while (true)
      {
        return localObject;
        Class localClass = a;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localTaskInfo.a.f();
        BLog.b(localClass, "Running %s", arrayOfObject);
        try
        {
          this.p = localTaskInfo;
          ListenableFuture localListenableFuture = this.p.a.c();
          if (localListenableFuture != null)
          {
            BLog.b(a, "Task started");
            localObject = localListenableFuture;
            continue;
          }
          this.p = null;
          i1++;
        }
        catch (Throwable localThrowable)
        {
          a(localThrowable);
          localObject = null;
        }
      }
      continue;
      localObject = null;
    }
  }

  private BackgroundTaskRunner.TaskInfo f()
  {
    Preconditions.checkState(this.n.c());
    int i1 = this.j.size();
    int i2 = 0;
    BackgroundTaskRunner.TaskInfo localTaskInfo;
    if (i2 < i1)
    {
      int i3 = (i2 + this.o) % i1;
      localTaskInfo = (BackgroundTaskRunner.TaskInfo)this.j.get(i3);
      if (a(localTaskInfo))
        this.o = ((i3 + 1) % i1);
    }
    while (true)
    {
      return localTaskInfo;
      i2++;
      break;
      localTaskInfo = null;
    }
  }

  private long g()
  {
    long l1 = 86400000L + this.d.a();
    int i1 = this.j.size();
    int i2 = 0;
    long l2;
    if (i2 < i1)
    {
      BackgroundTaskRunner.TaskInfo localTaskInfo = (BackgroundTaskRunner.TaskInfo)this.j.get(i2);
      if (!b(localTaskInfo))
        break label94;
      long l3 = localTaskInfo.a.h();
      if (l3 == -1L)
        break label94;
      l2 = Math.min(l1, l3);
    }
    while (true)
    {
      i2++;
      l1 = l2;
      break;
      return l1;
      label94: l2 = l1;
    }
  }

  public void a()
  {
    a(1);
  }

  public void a(Class<? extends Annotation> paramClass)
  {
    this.k.put(paramClass, Boolean.valueOf(true));
  }

  void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      a(2);
  }

  public void b()
  {
    a(1);
  }

  public void b(Class<? extends Annotation> paramClass)
  {
    this.k.remove(paramClass);
    a(1);
  }

  void c()
  {
    synchronized (this.l)
    {
      boolean bool = this.g.a();
      if (this.t != bool)
      {
        this.t = bool;
        if (!this.t)
          a(1);
      }
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.background.BackgroundTaskRunner
 * JD-Core Version:    0.6.0
 */