package com.facebook.orca.notify;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessageNotificationModule$NotificationSettingsUtilProvider extends AbstractProvider<NotificationSettingsUtil>
{
  private MessageNotificationModule$NotificationSettingsUtilProvider(MessageNotificationModule paramMessageNotificationModule)
  {
  }

  public NotificationSettingsUtil a()
  {
    return new NotificationSettingsUtil((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule.NotificationSettingsUtilProvider
 * JD-Core Version:    0.6.0
 */