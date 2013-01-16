package com.facebook.contacts.data;

import com.facebook.contacts.protocol.BulkContactsDeleteMethod;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$BulkDeleteContactsMethodProvider extends AbstractProvider<BulkContactsDeleteMethod>
{
  private ContactsModule$BulkDeleteContactsMethodProvider(ContactsModule paramContactsModule)
  {
  }

  public BulkContactsDeleteMethod a()
  {
    return new BulkContactsDeleteMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.BulkDeleteContactsMethodProvider
 * JD-Core Version:    0.6.0
 */