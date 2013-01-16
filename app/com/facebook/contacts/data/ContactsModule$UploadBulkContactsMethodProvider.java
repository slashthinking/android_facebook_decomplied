package com.facebook.contacts.data;

import com.facebook.contacts.protocol.UploadBulkContactsMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.core.JsonFactory;

class ContactsModule$UploadBulkContactsMethodProvider extends AbstractProvider<UploadBulkContactsMethod>
{
  private ContactsModule$UploadBulkContactsMethodProvider(ContactsModule paramContactsModule)
  {
  }

  public UploadBulkContactsMethod a()
  {
    return new UploadBulkContactsMethod((JsonFactory)b(JsonFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.UploadBulkContactsMethodProvider
 * JD-Core Version:    0.6.0
 */