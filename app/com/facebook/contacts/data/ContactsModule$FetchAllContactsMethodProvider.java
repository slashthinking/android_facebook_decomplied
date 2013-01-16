package com.facebook.contacts.data;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.protocol.FetchAllContactsMethod;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$FetchAllContactsMethodProvider extends AbstractProvider<FetchAllContactsMethod>
{
  private ContactsModule$FetchAllContactsMethodProvider(ContactsModule paramContactsModule)
  {
  }

  public FetchAllContactsMethod a()
  {
    return new FetchAllContactsMethod((ContactGraphQL)b(ContactGraphQL.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.FetchAllContactsMethodProvider
 * JD-Core Version:    0.6.0
 */