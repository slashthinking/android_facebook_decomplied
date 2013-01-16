package com.facebook.orca.app;

import com.facebook.orca.database.DbMessageCache;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$DbMessageCacheProvider extends AbstractProvider<DbMessageCache>
{
  private MessagesModule$DbMessageCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbMessageCache a()
  {
    return new DbMessageCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbMessageCacheProvider
 * JD-Core Version:    0.6.0
 */