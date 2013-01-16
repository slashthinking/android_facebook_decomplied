package com.facebook.orca.notify;

public abstract interface MessagingNotificationHandler
{
  public abstract void a();

  public abstract void a(NewMessageNotification paramNewMessageNotification);

  public abstract void a(String paramString);

  public abstract boolean a(FailedToSendMessageNotification paramFailedToSendMessageNotification);

  public abstract boolean a(LoggedOutMessageNotification paramLoggedOutMessageNotification);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessagingNotificationHandler
 * JD-Core Version:    0.6.0
 */