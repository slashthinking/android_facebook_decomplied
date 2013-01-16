package com.facebook.orca.app;

import com.facebook.orca.database.UsersDatabaseSupplier;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.FacebookUsersDbUserIterator;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$FacebookUserIteratorProvider extends AbstractProvider<FacebookUserIterator>
{
  private MessagesModule$FacebookUserIteratorProvider(MessagesModule paramMessagesModule)
  {
  }

  public FacebookUserIterator a()
  {
    return new FacebookUsersDbUserIterator((UsersDatabaseSupplier)b(UsersDatabaseSupplier.class), (UserSerialization)b(UserSerialization.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FacebookUserIteratorProvider
 * JD-Core Version:    0.6.0
 */