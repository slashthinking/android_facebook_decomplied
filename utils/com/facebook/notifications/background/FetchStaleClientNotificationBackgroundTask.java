package com.facebook.notifications.background;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.notifications.intent.INotificationRenderer;
import com.facebook.notifications.prefs.NotificationsPrefs;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class FetchStaleClientNotificationBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = FetchStaleClientNotificationBackgroundTask.class;
  private final OrcaSharedPreferences b;
  private final OrcaServiceOperationFactory c;
  private final Clock d;
  private final Provider<Boolean> e;
  private final INotificationRenderer f;
  private final DeviceConditionHelper g;
  private final Provider<String> h;
  private final AnalyticsLogger i;
  private ListenableFuture<OperationResult> j;

  public FetchStaleClientNotificationBackgroundTask(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Clock paramClock, Provider<Boolean> paramProvider, INotificationRenderer paramINotificationRenderer, DeviceConditionHelper paramDeviceConditionHelper, Provider<String> paramProvider1, AnalyticsLogger paramAnalyticsLogger)
  {
    super("FETCH_STALE_CLIENT_NOTIFICATION");
    this.b = ((OrcaSharedPreferences)Preconditions.checkNotNull(paramOrcaSharedPreferences));
    this.c = ((OrcaServiceOperationFactory)Preconditions.checkNotNull(paramOrcaServiceOperationFactory));
    this.d = ((Clock)Preconditions.checkNotNull(paramClock));
    this.e = paramProvider;
    this.f = ((INotificationRenderer)Preconditions.checkNotNull(paramINotificationRenderer));
    this.g = ((DeviceConditionHelper)Preconditions.checkNotNull(paramDeviceConditionHelper));
    this.h = ((Provider)Preconditions.checkNotNull(paramProvider1));
    this.i = ((AnalyticsLogger)Preconditions.checkNotNull(paramAnalyticsLogger));
  }

  private void a(String paramString, Long paramLong)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramString).d("app");
    if (paramLong.longValue() != 0L)
      localHoneyClientEvent.a("notification_id", paramLong.longValue());
    this.i.b(localHoneyClientEvent);
  }

  public boolean b()
  {
    boolean bool1 = this.b.a();
    boolean bool2 = false;
    if (bool1)
    {
      Object localObject = this.h.b();
      bool2 = false;
      if (localObject != null)
        break label34;
    }
    while (true)
    {
      return bool2;
      label34: ListenableFuture localListenableFuture = this.j;
      bool2 = false;
      if (localListenableFuture == null)
      {
        long l1 = this.d.a();
        long l2 = this.b.a(NotificationsPrefs.e, 0L);
        if (l2 == 0L)
        {
          this.b.b().a(NotificationsPrefs.e, this.d.a()).a();
          bool2 = false;
        }
        else
        {
          boolean bool3 = l1 - l2 < 86400000L;
          bool2 = false;
          if (!bool3)
          {
            boolean bool4 = this.g.a(35);
            bool2 = false;
            if (bool4)
              bool2 = ((Boolean)this.e.b()).booleanValue();
          }
        }
      }
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    Bundle localBundle = new Bundle();
    this.j = this.c.a("fetchStaleClientNotification", localBundle).d();
    a("client_notification_fetch", Long.valueOf(0L));
    FetchStaleClientNotificationBackgroundTask.1 local1 = new FetchStaleClientNotificationBackgroundTask.1(this, a);
    Futures.a(this.j, local1);
    return local1;
  }

  public long h()
  {
    return 86400000L + this.d.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.background.FetchStaleClientNotificationBackgroundTask
 * JD-Core Version:    0.6.2
 */