package com.facebook.background;

import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Annotation;
import java.util.Set;

public abstract class AbstractBackgroundTask
  implements BackgroundTask
{
  private final String a;
  private BackgroundTaskRunnerCallback b;

  public AbstractBackgroundTask(String paramString)
  {
    this.a = paramString;
  }

  public Set<Class<? extends Annotation>> a()
  {
    return ImmutableSet.d();
  }

  public void a(BackgroundTaskRunnerCallback paramBackgroundTaskRunnerCallback)
  {
    this.b = paramBackgroundTaskRunnerCallback;
  }

  protected BackgroundTaskRunnerCallback e()
  {
    return this.b;
  }

  public String f()
  {
    return this.a;
  }

  public Set<String> g()
  {
    return ImmutableSet.d();
  }

  public long h()
  {
    return -1L;
  }

  protected void i()
  {
    if (this.b != null)
      this.b.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.background.AbstractBackgroundTask
 * JD-Core Version:    0.6.0
 */