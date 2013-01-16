package com.facebook.orca.app;

import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.RemoveMemberMethod;

class MessagesModule$RemoveMemberMethodProvider extends AbstractProvider<RemoveMemberMethod>
{
  private MessagesModule$RemoveMemberMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public RemoveMemberMethod a()
  {
    return new RemoveMemberMethod((MeUserAuthDataStore)b(MeUserAuthDataStore.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.RemoveMemberMethodProvider
 * JD-Core Version:    0.6.0
 */