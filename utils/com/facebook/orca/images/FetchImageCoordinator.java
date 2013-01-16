package com.facebook.orca.images;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class FetchImageCoordinator
  implements Executor
{
  private static final Class<?> a = FetchImageCoordinator.class;
  private final AndroidThreadUtil b;
  private final List<Runnable> c = Lists.a();

  public FetchImageCoordinator(AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = paramAndroidThreadUtil;
  }

  private void a()
  {
    try
    {
      ArrayList localArrayList = Lists.a(this.c);
      this.c.clear();
      Class localClass = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localArrayList.size());
      BLog.a(localClass, "Running %d runnables", arrayOfObject);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
        ((Runnable)localIterator.next()).run();
    }
    finally
    {
    }
  }

  public void execute(Runnable paramRunnable)
  {
    try
    {
      if (this.c.isEmpty())
        this.b.a(new FetchImageCoordinator.1(this), 50L);
      this.c.add(paramRunnable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageCoordinator
 * JD-Core Version:    0.6.2
 */