package com.facebook.orca.app;

import com.facebook.app.UserActivityManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.MessagesServiceManager;

class MessagesModule$MessagesServiceManagerProvider extends AbstractProvider<MessagesServiceManager>
{
  private MessagesModule$MessagesServiceManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessagesServiceManager a()
  {
    return new MessagesServiceManager(MessagesModule.a(this.a), (UserActivityManager)b(UserActivityManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessagesServiceManagerProvider
 * JD-Core Version:    0.6.0
 */