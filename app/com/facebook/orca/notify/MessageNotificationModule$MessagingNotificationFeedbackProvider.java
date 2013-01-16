package com.facebook.orca.notify;

import android.os.Vibrator;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class MessageNotificationModule$MessagingNotificationFeedbackProvider extends AbstractProvider<MessagingNotificationFeedback>
{
  private MessageNotificationModule$MessagingNotificationFeedbackProvider(MessageNotificationModule paramMessageNotificationModule)
  {
  }

  public MessagingNotificationFeedback a()
  {
    return new MessagingNotificationFeedback(MessageNotificationModule.a(this.a), (Vibrator)b(Vibrator.class, FromApplication.class), (MessagingNotificationPreferences)b(MessagingNotificationPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule.MessagingNotificationFeedbackProvider
 * JD-Core Version:    0.6.0
 */