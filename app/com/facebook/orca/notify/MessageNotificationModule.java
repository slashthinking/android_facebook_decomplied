package com.facebook.orca.notify;

import android.content.Context;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.annotations.IsInAppNotificationsEnabled;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class MessageNotificationModule extends AbstractModule
{
  private final Context a;

  public MessageNotificationModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(Boolean.class).a(IsInAppNotificationsEnabled.class).c(InAppNotificationEnabledProvider.class);
    a(MessagingNotificationFeedback.class).a(new MessageNotificationModule.MessagingNotificationFeedbackProvider(this, null)).a();
    a(DefaultMessagingNotificationHandler.class).a(new MessageNotificationModule.DefaultMessagingNotificationRendererProvider(this, null)).a();
    a(InAppMessagingNotificationHandler.class).a(new MessageNotificationModule.InAppNotificationControllerProvider(this, null)).a();
    a(InAppMessagingNotificationHandler.MyActivityListener.class).a(new MessageNotificationModule.InAppNotificationControllerActivityListenerProvider(this, null)).a();
    a(OrcaForegroundActivityListener.class).a(new MessageNotificationModule.OrcaForegroundActivityListenerProvider(this, null)).a();
    a(OrcaNotificationManager.class).a(new MessageNotificationModule.OrcaNotificationManagerProvider(this, null)).d();
    a(NotificationSettingsUtil.class).a(new MessageNotificationModule.NotificationSettingsUtilProvider(this, null));
    c(MessagingNotificationHandler.class).a(InAppMessagingNotificationHandler.class).a(DefaultMessagingNotificationHandler.class);
    c(FbActivityListener.class).a(OrcaForegroundActivityListener.class).a(InAppMessagingNotificationHandler.MyActivityListener.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule
 * JD-Core Version:    0.6.0
 */