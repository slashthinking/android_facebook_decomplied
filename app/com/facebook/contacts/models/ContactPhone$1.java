package com.facebook.contacts.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ContactPhone$1
  implements Parcelable.Creator<ContactPhone>
{
  public ContactPhone a(Parcel paramParcel)
  {
    return new ContactPhone(paramParcel, null);
  }

  public ContactPhone[] a(int paramInt)
  {
    return new ContactPhone[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactPhone.1
 * JD-Core Version:    0.6.0
 */