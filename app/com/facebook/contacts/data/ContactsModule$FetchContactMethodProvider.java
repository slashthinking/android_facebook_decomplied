package com.facebook.contacts.data;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.protocol.FetchContactMethod;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$FetchContactMethodProvider extends AbstractProvider<FetchContactMethod>
{
  private ContactsModule$FetchContactMethodProvider(ContactsModule paramContactsModule)
  {
  }

  public FetchContactMethod a()
  {
    return new FetchContactMethod((ContactGraphQL)b(ContactGraphQL.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.FetchContactMethodProvider
 * JD-Core Version:    0.6.0
 */