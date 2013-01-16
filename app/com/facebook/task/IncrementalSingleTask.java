package com.facebook.task;

public abstract class IncrementalSingleTask extends IncrementalTask
{
  private boolean a = false;

  protected abstract void a();

  public void b()
  {
    super.b();
    this.a = false;
  }

  protected void c()
  {
    if (!this.a)
    {
      a();
      this.a = true;
    }
  }

  protected boolean d()
  {
    if (!this.a);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.task.IncrementalSingleTask
 * JD-Core Version:    0.6.0
 */