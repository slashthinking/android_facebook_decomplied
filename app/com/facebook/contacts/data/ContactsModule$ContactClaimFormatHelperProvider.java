package com.facebook.contacts.data;

import com.facebook.contacts.protocol.ContactClaimFormatHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.core.JsonFactory;

class ContactsModule$ContactClaimFormatHelperProvider extends AbstractProvider<ContactClaimFormatHelper>
{
  private ContactsModule$ContactClaimFormatHelperProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactClaimFormatHelper a()
  {
    return new ContactClaimFormatHelper((JsonFactory)b(JsonFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactClaimFormatHelperProvider
 * JD-Core Version:    0.6.0
 */