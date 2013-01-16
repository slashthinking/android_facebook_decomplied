package com.facebook.orca.notify;

import java.util.Iterator;
import java.util.Set;

class OrcaNotificationManager$2
  implements Runnable
{
  public void run()
  {
    FailedToSendMessageNotification localFailedToSendMessageNotification = new FailedToSendMessageNotification(this.a);
    Iterator localIterator = OrcaNotificationManager.a(this.b).iterator();
    while ((localIterator.hasNext()) && (!((MessagingNotificationHandler)localIterator.next()).a(localFailedToSendMessageNotification)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.OrcaNotificationManager.2
 * JD-Core Version:    0.6.0
 */