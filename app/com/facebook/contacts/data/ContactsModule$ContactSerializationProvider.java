package com.facebook.contacts.data;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class ContactsModule$ContactSerializationProvider extends AbstractProvider<ContactSerialization>
{
  private ContactsModule$ContactSerializationProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactSerialization a()
  {
    return new ContactSerialization((Resources)b(Resources.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactSerializationProvider
 * JD-Core Version:    0.6.0
 */