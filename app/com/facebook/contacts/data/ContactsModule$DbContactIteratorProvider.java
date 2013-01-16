package com.facebook.contacts.data;

import com.facebook.contacts.iterator.DbContactIterator;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$DbContactIteratorProvider extends AbstractProvider<DbContactIterator>
{
  private ContactsModule$DbContactIteratorProvider(ContactsModule paramContactsModule)
  {
  }

  public DbContactIterator a()
  {
    return new DbContactIterator((ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (ContactSerialization)b(ContactSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.DbContactIteratorProvider
 * JD-Core Version:    0.6.0
 */