package com.facebook.contacts.cache;

import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactUserKey;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.MapMaker;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class ContactsCache
{
  private final ConcurrentMap<UserKey, ContactSummary> a = new MapMaker().b(600L, TimeUnit.SECONDS).b(100).n();
  private final ConcurrentMap<UserKey, ContactDetails> b = new MapMaker().b(600L, TimeUnit.SECONDS).b(100).n();

  public ContactSummary a(UserKey paramUserKey)
  {
    if (paramUserKey == null);
    for (ContactSummary localContactSummary = null; ; localContactSummary = (ContactSummary)this.a.get(paramUserKey))
      return localContactSummary;
  }

  public void a()
  {
    this.a.clear();
    this.b.clear();
  }

  public void a(ContactSummary paramContactSummary, ContactDetails paramContactDetails)
  {
    Iterator localIterator = ContactUserKey.b(paramContactSummary).iterator();
    while (localIterator.hasNext())
    {
      UserKey localUserKey = (UserKey)localIterator.next();
      this.a.put(localUserKey, paramContactSummary);
      if (paramContactDetails == null)
        continue;
      this.b.put(localUserKey, paramContactDetails);
    }
  }

  public ContactDetails b(UserKey paramUserKey)
  {
    if (paramUserKey == null);
    for (ContactDetails localContactDetails = null; ; localContactDetails = (ContactDetails)this.b.get(paramUserKey))
      return localContactDetails;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.cache.ContactsCache
 * JD-Core Version:    0.6.0
 */