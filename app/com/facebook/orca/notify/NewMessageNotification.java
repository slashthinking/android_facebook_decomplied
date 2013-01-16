package com.facebook.orca.notify;

import com.facebook.orca.push.PushSource;
import com.facebook.orca.threads.Message;

public class NewMessageNotification
{
  private final String a;
  private final Message b;
  private final NewMessageNotification.PresenceLevel c;
  private final PushSource d;
  private final AlertDisposition e;

  public NewMessageNotification(String paramString, Message paramMessage, NewMessageNotification.PresenceLevel paramPresenceLevel, PushSource paramPushSource, AlertDisposition paramAlertDisposition)
  {
    this.a = paramString;
    this.b = paramMessage;
    this.c = paramPresenceLevel;
    this.d = paramPushSource;
    this.e = paramAlertDisposition;
  }

  public String a()
  {
    return this.a;
  }

  public Message b()
  {
    return this.b;
  }

  public NewMessageNotification.PresenceLevel c()
  {
    return this.c;
  }

  public PushSource d()
  {
    return this.d;
  }

  public AlertDisposition e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.NewMessageNotification
 * JD-Core Version:    0.6.0
 */