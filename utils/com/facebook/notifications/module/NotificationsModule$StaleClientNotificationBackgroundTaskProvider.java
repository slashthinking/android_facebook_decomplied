package com.facebook.notifications.module;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.notifications.annotations.IsStaleClientNotificationEnabled;
import com.facebook.notifications.background.FetchStaleClientNotificationBackgroundTask;
import com.facebook.notifications.intent.INotificationRenderer;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class NotificationsModule$StaleClientNotificationBackgroundTaskProvider extends AbstractProvider<FetchStaleClientNotificationBackgroundTask>
{
  private NotificationsModule$StaleClientNotificationBackgroundTaskProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public FetchStaleClientNotificationBackgroundTask a()
  {
    return new FetchStaleClientNotificationBackgroundTask((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (Clock)b(Clock.class), a(Boolean.class, IsStaleClientNotificationEnabled.class), (INotificationRenderer)b(INotificationRenderer.class), (DeviceConditionHelper)b(DeviceConditionHelper.class), a(String.class, MeUserId.class), (AnalyticsLogger)b(AnalyticsLogger.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.StaleClientNotificationBackgroundTaskProvider
 * JD-Core Version:    0.6.2
 */