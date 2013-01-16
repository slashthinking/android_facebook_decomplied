package com.facebook.contacts.data;

import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class ContactsModule$DbFetchContactHandlerProvider extends AbstractProvider<DbFetchContactHandler>
{
  private ContactsModule$DbFetchContactHandlerProvider(ContactsModule paramContactsModule)
  {
  }

  public DbFetchContactHandler a()
  {
    return new DbFetchContactHandler((ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.DbFetchContactHandlerProvider
 * JD-Core Version:    0.6.0
 */