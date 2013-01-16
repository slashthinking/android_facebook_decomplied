package com.facebook.orca.contacts.picker;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.SearchUsersMethod;

class MessagesContactPickerModule$ContactPickerFriendsOfFriendsFilterProvider extends AbstractProvider<ContactPickerFriendsOfFriendsFilter>
{
  private MessagesContactPickerModule$ContactPickerFriendsOfFriendsFilterProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public ContactPickerFriendsOfFriendsFilter a()
  {
    return new ContactPickerFriendsOfFriendsFilter((SingleMethodRunner)b(SingleMethodRunner.class), (SearchUsersMethod)b(SearchUsersMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.ContactPickerFriendsOfFriendsFilterProvider
 * JD-Core Version:    0.6.0
 */