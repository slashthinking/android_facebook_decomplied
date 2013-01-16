package com.facebook.orca.threads;

import com.google.common.collect.Maps;
import java.util.Map;

class MessagesCollectionMerger$MessageMap
{
  private Map<String, Message> a = Maps.a();

  void a(Message paramMessage)
  {
    this.a.put(paramMessage.a(), paramMessage);
    if (paramMessage.u())
      this.a.put(paramMessage.t(), paramMessage);
  }

  boolean b(Message paramMessage)
  {
    if (c(paramMessage) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  Message c(Message paramMessage)
  {
    Message localMessage = (Message)this.a.get(paramMessage.a());
    if (localMessage != null);
    while (true)
    {
      return localMessage;
      if (!paramMessage.u())
        continue;
      localMessage = (Message)this.a.get(paramMessage.t());
    }
  }

  void d(Message paramMessage)
  {
    this.a.remove(paramMessage.a());
    if (paramMessage.u())
      this.a.remove(paramMessage.t());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessagesCollectionMerger.MessageMap
 * JD-Core Version:    0.6.0
 */