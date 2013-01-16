package com.facebook.task;

import com.google.common.collect.Lists;
import java.util.LinkedList;

public abstract class IncrementalTask
{
  private LinkedList<IncrementalTask> a;

  public void b()
  {
    if (this.a != null)
      this.a.clear();
  }

  protected void b(IncrementalTask paramIncrementalTask)
  {
    if (this.a == null)
      this.a = Lists.b();
    this.a.addLast(paramIncrementalTask);
  }

  protected abstract void c();

  protected abstract boolean d();

  public final boolean e()
  {
    if ((!d()) && ((this.a == null) || (this.a.isEmpty())));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void f()
  {
    while (!e())
    {
      if ((this.a != null) && (!this.a.isEmpty()))
      {
        ((IncrementalTask)this.a.getFirst()).f();
        this.a.removeFirst();
        continue;
      }
      c();
    }
  }

  LinkedList<IncrementalTask> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.task.IncrementalTask
 * JD-Core Version:    0.6.0
 */