package com.facebook.orca.app;

import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.orca.annotations.PhoneIsoCountryCode;
import com.facebook.orca.contacts.invite.ContactsInviteServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.UsersInviteMethod;
import com.facebook.orca.users.PhoneUserIterator;

class MessagesModule$ContactsInviteServiceHandlerProvider extends AbstractProvider<ContactsInviteServiceHandler>
{
  private MessagesModule$ContactsInviteServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ContactsInviteServiceHandler a()
  {
    return new ContactsInviteServiceHandler(a(PhoneUserIterator.class), a(SingleMethodRunner.class), a(String.class, PhoneIsoCountryCode.class), (DbContactsPropertyUtil)b(DbContactsPropertyUtil.class), (UsersInviteMethod)b(UsersInviteMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ContactsInviteServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */