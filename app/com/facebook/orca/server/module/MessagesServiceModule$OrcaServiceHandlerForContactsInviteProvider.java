package com.facebook.orca.server.module;

import com.facebook.orca.contacts.invite.ContactsInviteServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class MessagesServiceModule$OrcaServiceHandlerForContactsInviteProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerForContactsInviteProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(ContactsInviteServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerForContactsInviteProvider
 * JD-Core Version:    0.6.0
 */