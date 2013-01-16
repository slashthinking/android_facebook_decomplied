package com.facebook.orca.app;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.MessagesUiReorderer;
import com.facebook.orca.users.User;

class MessagesModule$MessagesUiReordererProvider extends AbstractProvider<MessagesUiReorderer>
{
  private MessagesModule$MessagesUiReordererProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessagesUiReorderer a()
  {
    return new MessagesUiReorderer(a(User.class, MeUser.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessagesUiReordererProvider
 * JD-Core Version:    0.6.0
 */