package com.facebook.orca.notify;

import com.facebook.orca.inject.AbstractProvider;

class MessageNotificationModule$InAppNotificationControllerActivityListenerProvider extends AbstractProvider<InAppMessagingNotificationHandler.MyActivityListener>
{
  private MessageNotificationModule$InAppNotificationControllerActivityListenerProvider(MessageNotificationModule paramMessageNotificationModule)
  {
  }

  public InAppMessagingNotificationHandler.MyActivityListener a()
  {
    return ((InAppMessagingNotificationHandler)b(InAppMessagingNotificationHandler.class)).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule.InAppNotificationControllerActivityListenerProvider
 * JD-Core Version:    0.6.0
 */