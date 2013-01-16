package com.facebook.orca.app;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadview.MessageDeliveredReadStateDisplayUtil;

class MessagesModule$MessageDeliveredReadStateDisplayUtilProvider extends AbstractProvider<MessageDeliveredReadStateDisplayUtil>
{
  private MessagesModule$MessageDeliveredReadStateDisplayUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessageDeliveredReadStateDisplayUtil a()
  {
    return new MessageDeliveredReadStateDisplayUtil((DataCache)b(DataCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessageDeliveredReadStateDisplayUtilProvider
 * JD-Core Version:    0.6.0
 */