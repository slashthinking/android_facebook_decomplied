package com.facebook.orca.notify;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.annotations.IsSmsNotifyEnabled;
import com.facebook.orca.annotations.MessagesForegroundProviderUri;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.push.c2dm.PushTokenHolder;

class MessageNotificationModule$OrcaNotificationManagerProvider extends AbstractProvider<OrcaNotificationManager>
{
  private MessageNotificationModule$OrcaNotificationManagerProvider(MessageNotificationModule paramMessageNotificationModule)
  {
  }

  public OrcaNotificationManager a()
  {
    return new OrcaNotificationManager(MessageNotificationModule.a(this.a), (NotificationSettingsUtil)b(NotificationSettingsUtil.class), (UserActivityManager)b(UserActivityManager.class), c(MessagingNotificationHandler.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (MeUserAuthDataStore)b(MeUserAuthDataStore.class), (String)b(String.class, MessagesForegroundProviderUri.class), (ReliabilityAnalyticsLogger)b(ReliabilityAnalyticsLogger.class), a(Boolean.class, IsSmsNotifyEnabled.class), (PushTokenHolder)b(PushTokenHolder.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule.OrcaNotificationManagerProvider
 * JD-Core Version:    0.6.0
 */