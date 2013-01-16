package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.AddMembersMethod;
import com.facebook.orca.protocol.methods.PickedUserUtils;

class MessagesModule$AddMembersMethodProvider extends AbstractProvider<AddMembersMethod>
{
  private MessagesModule$AddMembersMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public AddMembersMethod a()
  {
    return new AddMembersMethod((PickedUserUtils)b(PickedUserUtils.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AddMembersMethodProvider
 * JD-Core Version:    0.6.0
 */