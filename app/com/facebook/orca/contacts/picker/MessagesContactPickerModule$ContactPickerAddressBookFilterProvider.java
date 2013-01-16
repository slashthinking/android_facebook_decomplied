package com.facebook.orca.contacts.picker;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.PhoneUserIterator;

class MessagesContactPickerModule$ContactPickerAddressBookFilterProvider extends AbstractProvider<ContactPickerAddressBookFilter>
{
  private MessagesContactPickerModule$ContactPickerAddressBookFilterProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public ContactPickerAddressBookFilter a()
  {
    return new ContactPickerAddressBookFilter(a(PhoneUserIterator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.ContactPickerAddressBookFilterProvider
 * JD-Core Version:    0.6.0
 */