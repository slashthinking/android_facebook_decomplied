package com.facebook.background;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;

public abstract interface BackgroundTask
{
  public abstract Set<Class<? extends Annotation>> a();

  public abstract void a(BackgroundTaskRunnerCallback paramBackgroundTaskRunnerCallback);

  public abstract boolean b();

  public abstract ListenableFuture<BackgroundResult> c();

  public abstract String f();

  public abstract Set<String> g();

  public abstract long h();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.background.BackgroundTask
 * JD-Core Version:    0.6.0
 */