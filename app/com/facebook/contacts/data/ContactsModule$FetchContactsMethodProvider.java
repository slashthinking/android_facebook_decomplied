package com.facebook.contacts.data;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.protocol.FetchContactsMethod;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$FetchContactsMethodProvider extends AbstractProvider<FetchContactsMethod>
{
  private ContactsModule$FetchContactsMethodProvider(ContactsModule paramContactsModule)
  {
  }

  public FetchContactsMethod a()
  {
    return new FetchContactsMethod((ContactGraphQL)b(ContactGraphQL.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.FetchContactsMethodProvider
 * JD-Core Version:    0.6.0
 */