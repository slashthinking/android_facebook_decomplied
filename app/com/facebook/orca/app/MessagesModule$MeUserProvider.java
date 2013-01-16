package com.facebook.orca.app;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.User;

class MessagesModule$MeUserProvider extends AbstractProvider<User>
{
  private MessagesModule$MeUserProvider(MessagesModule paramMessagesModule)
  {
  }

  public User a()
  {
    return ((DataCache)b(DataCache.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MeUserProvider
 * JD-Core Version:    0.6.0
 */