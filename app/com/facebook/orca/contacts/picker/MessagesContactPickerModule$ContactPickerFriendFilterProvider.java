package com.facebook.orca.contacts.picker;

import com.facebook.contacts.annotations.WithContacts;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.FacebookUserIterator;

class MessagesContactPickerModule$ContactPickerFriendFilterProvider extends AbstractProvider<ContactPickerFriendFilter>
{
  private MessagesContactPickerModule$ContactPickerFriendFilterProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public ContactPickerFriendFilter a()
  {
    return new ContactPickerFriendFilter(a(FacebookUserIterator.class, WithContacts.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.ContactPickerFriendFilterProvider
 * JD-Core Version:    0.6.0
 */