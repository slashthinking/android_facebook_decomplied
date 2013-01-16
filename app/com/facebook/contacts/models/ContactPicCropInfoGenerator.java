package com.facebook.contacts.models;

import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.contacts.pictures.ContactPictureSizes.Size;
import com.facebook.orca.users.PicCropInfo;
import javax.inject.Inject;

public final class ContactPicCropInfoGenerator
{
  private ContactPictureSizes a;

  @Inject
  public ContactPicCropInfoGenerator(ContactPictureSizes paramContactPictureSizes)
  {
    this.a = paramContactPictureSizes;
  }

  private PicCropInfo a(String paramString, ContactPictureSizes.Size paramSize)
  {
    return PicCropInfo.a(paramString, this.a.a(paramSize));
  }

  public PicCropInfo a(ContactSummary paramContactSummary)
  {
    return a(paramContactSummary.getSmallPictureUrl(), ContactPictureSizes.Size.SMALL);
  }

  public PicCropInfo b(ContactSummary paramContactSummary)
  {
    return a(paramContactSummary.getBigPictureUrl(), ContactPictureSizes.Size.BIG);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactPicCropInfoGenerator
 * JD-Core Version:    0.6.0
 */