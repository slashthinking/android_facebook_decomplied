package com.facebook.orca.cache;

import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.Set;

class SendMessageManager$3
  implements Runnable
{
  public void run()
  {
    if (!SendMessageManager.a(this.c).contains(this.a))
      return;
    MessagesCollection localMessagesCollection = SendMessageManager.b(this.c).b(this.b);
    ImmutableList localImmutableList;
    label43: Message localMessage;
    if (localMessagesCollection == null)
    {
      localImmutableList = ImmutableList.d();
      localMessage = (Message)Iterables.a(localImmutableList, new SendMessageManager.3.1(this), null);
      if (localMessage != null)
        break label92;
    }
    while (true)
    {
      SendMessageManager.a(this.c).remove(this.a);
      break;
      localImmutableList = localMessagesCollection.b();
      break label43;
      label92: if (localMessage.r() == 901)
      {
        SendMessageManager.c(this.c).a(this.b);
        continue;
      }
      if (localMessage.r() != 0)
        continue;
      this.c.c(this.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.SendMessageManager.3
 * JD-Core Version:    0.6.0
 */