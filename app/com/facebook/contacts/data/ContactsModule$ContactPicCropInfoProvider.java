package com.facebook.contacts.data;

import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.orca.inject.AbstractProvider;

class ContactsModule$ContactPicCropInfoProvider extends AbstractProvider<ContactPicCropInfoGenerator>
{
  private ContactsModule$ContactPicCropInfoProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactPicCropInfoGenerator a()
  {
    return new ContactPicCropInfoGenerator((ContactPictureSizes)b(ContactPictureSizes.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactPicCropInfoProvider
 * JD-Core Version:    0.6.0
 */