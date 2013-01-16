package com.facebook.task;

import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;

public class IncrementalCompositeTask<T extends IncrementalTask> extends IncrementalCollectionTask<T>
{
  public IncrementalCompositeTask(ImmutableCollection<T> paramImmutableCollection)
  {
    super(paramImmutableCollection);
  }

  public void a(T paramT)
  {
    b(paramT);
  }

  public void b()
  {
    super.b();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((IncrementalTask)localIterator.next()).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.task.IncrementalCompositeTask
 * JD-Core Version:    0.6.0
 */