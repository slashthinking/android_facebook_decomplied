package com.facebook.contacts.data;

import android.content.Context;
import com.facebook.contacts.service.AddressBookContactFetcher;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$AddressBookContactFetcherProvider extends AbstractProvider<AddressBookContactFetcher>
{
  private ContactsModule$AddressBookContactFetcherProvider(ContactsModule paramContactsModule)
  {
  }

  public AddressBookContactFetcher a()
  {
    return new AddressBookContactFetcher(ContactsModule.a(this.a).getContentResolver(), (ContactSerialization)b(ContactSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.AddressBookContactFetcherProvider
 * JD-Core Version:    0.6.0
 */