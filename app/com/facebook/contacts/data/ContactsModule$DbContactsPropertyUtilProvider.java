package com.facebook.contacts.data;

import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$DbContactsPropertyUtilProvider extends AbstractProvider<DbContactsPropertyUtil>
{
  private ContactsModule$DbContactsPropertyUtilProvider(ContactsModule paramContactsModule)
  {
  }

  public DbContactsPropertyUtil a()
  {
    return new DbContactsPropertyUtil((ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.DbContactsPropertyUtilProvider
 * JD-Core Version:    0.6.0
 */