package com.facebook.contacts.models;

import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.Entry.Type;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class ContactUtils
{
  private final ContactsCache a;

  public ContactUtils(ContactsCache paramContactsCache)
  {
    this.a = paramContactsCache;
  }

  public PhoneEntry a(String paramString1, String paramString2)
  {
    UserKey localUserKey = new UserKey(User.Type.FACEBOOK_CONTACT, paramString1);
    ContactDetails localContactDetails = this.a.b(localUserKey);
    PhoneEntry localPhoneEntry;
    if (localContactDetails == null)
      localPhoneEntry = null;
    while (true)
    {
      return localPhoneEntry;
      Iterator localIterator = localContactDetails.getContactInfoSection().getEntries().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          Entry localEntry = (Entry)localIterator.next();
          if (localEntry.a() != Entry.Type.PHONE_NUMBER)
            continue;
          localPhoneEntry = (PhoneEntry)localEntry;
          if (!Objects.equal(paramString2, localPhoneEntry.getNumber()))
            continue;
          break;
        }
      localPhoneEntry = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactUtils
 * JD-Core Version:    0.6.0
 */