package com.facebook.orca.debug;

import android.os.Looper;
import android.os.MessageQueue;
import com.facebook.orca.common.util.AndroidThreadUtil;

public class ActivityTracer
{
  private static Class<?> a = ActivityTracer.class;
  private final AndroidThreadUtil b;
  private Tracer c;

  public ActivityTracer(AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = paramAndroidThreadUtil;
    paramAndroidThreadUtil.a();
  }

  private void b()
  {
    Looper.myQueue().addIdleHandler(new ActivityTracer.1(this));
  }

  public void a(Tracer paramTracer)
  {
    this.b.a();
    this.c = paramTracer;
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.ActivityTracer
 * JD-Core Version:    0.6.0
 */