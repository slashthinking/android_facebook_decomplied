package com.facebook.analytics.performance;

import android.app.Activity;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.inject.FbInjector;

public class PerformanceLoggingActivityListener extends AbstractFbActivityListener
{
  private PerformanceLogger a;

  public void f(Activity paramActivity)
  {
    if (this.a == null)
      this.a = ((PerformanceLogger)FbInjector.a(paramActivity).a(PerformanceLogger.class));
    this.a.a();
    this.a.a(paramActivity);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.PerformanceLoggingActivityListener
 * JD-Core Version:    0.6.2
 */