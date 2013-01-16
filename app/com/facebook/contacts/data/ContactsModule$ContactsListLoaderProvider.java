package com.facebook.contacts.data;

import android.content.Context;
import com.facebook.contacts.contactslist.ContactsListLoader;
import com.facebook.contacts.iterator.DbContactIteratorFactory;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactsListLoaderProvider extends AbstractProvider<ContactsListLoader>
{
  private ContactsModule$ContactsListLoaderProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactsListLoader a()
  {
    return new ContactsListLoader((Context)b(Context.class), (DbContactIteratorFactory)b(DbContactIteratorFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactsListLoaderProvider
 * JD-Core Version:    0.6.0
 */