package com.facebook.contacts.data;

import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$DbInsertContactHandlerContactNameLookupBuilderProvider extends AbstractProvider<DbInsertContactHandler.ContactNameLookupBuilder>
{
  private ContactsModule$DbInsertContactHandlerContactNameLookupBuilderProvider(ContactsModule paramContactsModule)
  {
  }

  public DbInsertContactHandler.ContactNameLookupBuilder a()
  {
    return new DbInsertContactHandler.ContactNameLookupBuilder((ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (NameSplitter)b(NameSplitter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.DbInsertContactHandlerContactNameLookupBuilderProvider
 * JD-Core Version:    0.6.0
 */