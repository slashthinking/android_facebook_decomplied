package com.facebook.contacts.data;

import com.facebook.contacts.contactslist.ContactsListAdapter;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactsListAdapterProvider extends AbstractProvider<ContactsListAdapter>
{
  private ContactsModule$ContactsListAdapterProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactsListAdapter a()
  {
    return new ContactsListAdapter(ContactsModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactsListAdapterProvider
 * JD-Core Version:    0.6.0
 */