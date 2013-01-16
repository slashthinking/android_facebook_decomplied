package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Set;

public class FbAppInitializer
{
  private final Class<?> a = FbAppInitializer.class;
  private final AndroidThreadUtil b;
  private final Set<INeedInit> c;
  private final Set<INeedInit> d;
  private final Set<INeedInit> e;

  public FbAppInitializer(AndroidThreadUtil paramAndroidThreadUtil, Set<INeedInit> paramSet1, Set<INeedInit> paramSet2, Set<INeedInit> paramSet3)
  {
    this.b = paramAndroidThreadUtil;
    this.c = paramSet1;
    this.d = paramSet2;
    this.e = paramSet3;
  }

  private void b()
  {
    Tracer.b(10L);
    Tracer localTracer1 = Tracer.a("FbAppInitializer");
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      INeedInit localINeedInit = (INeedInit)localIterator.next();
      Tracer localTracer2 = Tracer.a("#" + localINeedInit.getClass().getSimpleName());
      localINeedInit.i_();
      localTracer2.a();
    }
    localTracer1.a();
    BLog.c(this.a, "High priority worker thread app initialization complete");
    Tracer.a(this.a);
  }

  private void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((INeedInit)localIterator.next()).i_();
    BLog.c(this.a, "Low priority main thread app initialization complete");
  }

  private void d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((INeedInit)localIterator.next()).i_();
    BLog.c(this.a, "Low priority worker thread app initialization complete");
  }

  public ListenableFuture<Void> a()
  {
    SettableFuture localSettableFuture = SettableFuture.c();
    this.b.a("FbAppInit", new FbAppInitializer.1(this, localSettableFuture));
    return localSettableFuture;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbAppInitializer
 * JD-Core Version:    0.6.0
 */