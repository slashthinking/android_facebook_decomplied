package com.facebook.contacts.pictures;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class ContactPictureSizes
{
  private static final ImmutableMap<ContactPictureSizes.Size, Integer> a = new ImmutableMap.Builder().b(ContactPictureSizes.Size.SMALL, Integer.valueOf(100)).b(ContactPictureSizes.Size.BIG, Integer.valueOf(200)).b();

  public int a(ContactPictureSizes.Size paramSize)
  {
    return ((Integer)a.get(paramSize)).intValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.pictures.ContactPictureSizes
 * JD-Core Version:    0.6.0
 */