package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$UserSerializationProvider extends AbstractProvider<UserSerialization>
{
  private MessagesModule$UserSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public UserSerialization a()
  {
    return new UserSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.UserSerializationProvider
 * JD-Core Version:    0.6.0
 */