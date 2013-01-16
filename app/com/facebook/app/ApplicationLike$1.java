package com.facebook.app;

import com.facebook.orca.debug.ActivityTracer;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.FbInjector;
import com.google.common.util.concurrent.FutureCallback;

class ApplicationLike$1
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
  }

  public void a(Void paramVoid)
  {
    ((ActivityTracer)ApplicationLike.a(this.b).a(ActivityTracer.class)).a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.ApplicationLike.1
 * JD-Core Version:    0.6.0
 */