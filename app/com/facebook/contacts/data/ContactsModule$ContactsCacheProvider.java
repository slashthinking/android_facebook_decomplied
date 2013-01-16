package com.facebook.contacts.data;

import com.facebook.contacts.cache.ContactsCache;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactsCacheProvider extends AbstractProvider<ContactsCache>
{
  private ContactsModule$ContactsCacheProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactsCache a()
  {
    return new ContactsCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactsCacheProvider
 * JD-Core Version:    0.6.0
 */