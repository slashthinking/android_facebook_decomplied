package com.facebook.contacts.data;

import com.facebook.contacts.iterator.DbContactIterator;
import com.facebook.contacts.iterator.DbContactIteratorFactory;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$DbContactIteratorFactoryProvider extends AbstractProvider<DbContactIteratorFactory>
{
  private ContactsModule$DbContactIteratorFactoryProvider(ContactsModule paramContactsModule)
  {
  }

  public DbContactIteratorFactory a()
  {
    return new DbContactIteratorFactory(a(DbContactIterator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.DbContactIteratorFactoryProvider
 * JD-Core Version:    0.6.0
 */