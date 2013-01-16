package com.facebook.orca.app;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$MeUserIdProvider extends AbstractProvider<String>
{
  private MessagesModule$MeUserIdProvider(MessagesModule paramMessagesModule)
  {
  }

  public String a()
  {
    return ((DataCache)b(DataCache.class)).c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MeUserIdProvider
 * JD-Core Version:    0.6.0
 */