package com.facebook.contacts.data;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactGraphQLProvider extends AbstractProvider<ContactGraphQL>
{
  private ContactsModule$ContactGraphQLProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactGraphQL a()
  {
    return new ContactGraphQL((ContactPictureSizes)b(ContactPictureSizes.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactGraphQLProvider
 * JD-Core Version:    0.6.0
 */