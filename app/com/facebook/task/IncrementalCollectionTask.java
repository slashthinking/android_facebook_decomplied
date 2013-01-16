package com.facebook.task;

import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;

public abstract class IncrementalCollectionTask<T> extends IncrementalTask
{
  private final ImmutableCollection<T> a;
  private Iterator<T> b;

  public IncrementalCollectionTask(ImmutableCollection<T> paramImmutableCollection)
  {
    this.a = paramImmutableCollection;
    this.b = this.a.b();
  }

  public ImmutableCollection<T> a()
  {
    return this.a;
  }

  public abstract void a(T paramT);

  public void b()
  {
    super.b();
    this.b = this.a.b();
  }

  public final void c()
  {
    a(this.b.next());
  }

  public boolean d()
  {
    return this.b.hasNext();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.task.IncrementalCollectionTask
 * JD-Core Version:    0.6.0
 */