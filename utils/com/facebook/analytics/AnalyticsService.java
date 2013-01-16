package com.facebook.analytics;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import java.util.concurrent.LinkedBlockingQueue;

public class AnalyticsService extends Service
{
  private static final Class<?> a = AnalyticsService.class;
  private AnalyticsService.AnalyticsServiceStub b;
  private LinkedBlockingQueue<AnalyticsEvent> c = new LinkedBlockingQueue();
  private AnalyticsEventProcessor d;

  private void a(AnalyticsServiceEvent paramAnalyticsServiceEvent)
  {
    this.c.offer(paramAnalyticsServiceEvent);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.b;
  }

  public void onCreate()
  {
    super.onCreate();
    BLog.c(a, "Creating service");
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = new AnalyticsService.AnalyticsServiceStub(this, null);
    this.d = ((AnalyticsEventProcessor)localFbInjector.a(AnalyticsEventProcessor.class));
    this.d.a(this.c);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsService
 * JD-Core Version:    0.6.2
 */