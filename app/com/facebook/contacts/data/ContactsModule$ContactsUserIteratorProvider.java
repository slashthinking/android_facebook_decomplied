package com.facebook.contacts.data;

import com.facebook.contacts.annotations.IsRolodexPickerEnabled;
import com.facebook.contacts.iterator.ContactsUserIterator;
import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.orca.annotations.ForMessages;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.FacebookUserIterator;

class ContactsModule$ContactsUserIteratorProvider extends AbstractProvider<FacebookUserIterator>
{
  private ContactsModule$ContactsUserIteratorProvider(ContactsModule paramContactsModule)
  {
  }

  public FacebookUserIterator a()
  {
    if (((Boolean)b(Boolean.class, IsRolodexPickerEnabled.class)).booleanValue());
    for (Object localObject = new ContactsUserIterator((ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (ContactSerialization)b(ContactSerialization.class), (ContactPicCropInfoGenerator)b(ContactPicCropInfoGenerator.class)); ; localObject = (FacebookUserIterator)b(FacebookUserIterator.class, ForMessages.class))
      return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactsUserIteratorProvider
 * JD-Core Version:    0.6.0
 */