package com.facebook.contacts.contactcard;

import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.PhoneEntry;

class ContactCardFragment$7
  implements EntrySectionView.OnEntrySelectedListener
{
  public void a()
  {
    this.a.c();
  }

  public void a(Entry paramEntry)
  {
    ContactCardFragment.a(this.a, paramEntry);
  }

  public void b()
  {
    ContactCardFragment.i(this.a);
  }

  public void b(Entry paramEntry)
  {
    PhoneEntry localPhoneEntry = (PhoneEntry)paramEntry;
    ContactCardFragment.a(this.a, localPhoneEntry);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ContactCardFragment.7
 * JD-Core Version:    0.6.0
 */