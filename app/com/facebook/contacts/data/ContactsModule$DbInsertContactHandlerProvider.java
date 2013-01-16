package com.facebook.contacts.data;

import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

class ContactsModule$DbInsertContactHandlerProvider extends AbstractProvider<DbInsertContactHandler>
{
  private ContactsModule$DbInsertContactHandlerProvider(ContactsModule paramContactsModule)
  {
  }

  public DbInsertContactHandler a()
  {
    return new DbInsertContactHandler((ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (ContactSerialization)b(ContactSerialization.class), (DbInsertContactHandler.ContactNameLookupBuilder)b(DbInsertContactHandler.ContactNameLookupBuilder.class), (NameSplitter)b(NameSplitter.class), (DbContactsPropertyUtil)b(DbContactsPropertyUtil.class), (PhoneNumberUtil)b(PhoneNumberUtil.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.DbInsertContactHandlerProvider
 * JD-Core Version:    0.6.0
 */