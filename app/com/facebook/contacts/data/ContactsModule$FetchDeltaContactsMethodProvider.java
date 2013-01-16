package com.facebook.contacts.data;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.protocol.FetchDeltaContactsMethod;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$FetchDeltaContactsMethodProvider extends AbstractProvider<FetchDeltaContactsMethod>
{
  private ContactsModule$FetchDeltaContactsMethodProvider(ContactsModule paramContactsModule)
  {
  }

  public FetchDeltaContactsMethod a()
  {
    return new FetchDeltaContactsMethod((ContactGraphQL)b(ContactGraphQL.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.FetchDeltaContactsMethodProvider
 * JD-Core Version:    0.6.0
 */