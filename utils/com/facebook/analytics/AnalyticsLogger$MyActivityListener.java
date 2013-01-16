package com.facebook.analytics;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.activity.FbActivityish;
import com.facebook.orca.common.util.Clock;

public class AnalyticsLogger$MyActivityListener extends AbstractFbActivityListener
{
  public AnalyticsLogger$MyActivityListener(AnalyticsLogger paramAnalyticsLogger)
  {
  }

  public void a(Activity paramActivity)
  {
    AnalyticsLogger.a(this.a, (FbActivityish)paramActivity);
  }

  public void a(Activity paramActivity, Configuration paramConfiguration)
  {
    int i = AnalyticsLogger.e(this.a).getDefaultDisplay().getRotation();
    if (AnalyticsLogger.f(this.a) != i)
      AnalyticsLogger.a(this.a, i);
  }

  public void a(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    long l = AnalyticsLogger.g(this.a).a();
    if (l - AnalyticsLogger.h(this.a) > 500L)
    {
      AnalyticsLogger.b(this.a, l);
      AnalyticsLogger.c(this.a, l);
    }
  }

  public void b(Activity paramActivity)
  {
    AnalyticsLogger.b(this.a, (FbActivityish)paramActivity);
    AnalyticsLogger.a(this.a, paramActivity);
    AnalyticsLogger.b(this.a, paramActivity.getApplicationContext());
  }

  public void c(Activity paramActivity)
  {
    AnalyticsLogger.a(this.a, TimeSpentAnalyticsClientEvent.Dispatch.FORCE);
    AnalyticsLogger.c(this.a, (FbActivityish)paramActivity);
  }

  public void d(Activity paramActivity)
  {
    AnalyticsLogger.d(this.a, (FbActivityish)paramActivity);
  }

  public void e(Activity paramActivity)
  {
    long l = AnalyticsLogger.g(this.a).a();
    if (l - AnalyticsLogger.h(this.a) > 500L)
    {
      AnalyticsLogger.b(this.a, l);
      AnalyticsLogger.c(this.a, l);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger.MyActivityListener
 * JD-Core Version:    0.6.2
 */