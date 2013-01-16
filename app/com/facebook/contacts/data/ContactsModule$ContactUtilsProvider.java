package com.facebook.contacts.data;

import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.models.ContactUtils;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactUtilsProvider extends AbstractProvider<ContactUtils>
{
  private ContactsModule$ContactUtilsProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactUtils a()
  {
    return new ContactUtils((ContactsCache)b(ContactsCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactUtilsProvider
 * JD-Core Version:    0.6.0
 */