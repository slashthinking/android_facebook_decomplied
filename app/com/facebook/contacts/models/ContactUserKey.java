package com.facebook.contacts.models;

import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet.Builder;

public class ContactUserKey
{
  public static UserKey a(ContactSummary paramContactSummary)
  {
    UserKey localUserKey;
    if ((paramContactSummary.getProfileFbid() == null) && (paramContactSummary.getContactId() == null))
    {
      String str3 = paramContactSummary.getLookupKey();
      localUserKey = null;
      if (str3 != null)
        localUserKey = new UserKey(User.Type.ADDRESS_BOOK, paramContactSummary.getLookupKey());
    }
    while (true)
    {
      return localUserKey;
      String str1 = paramContactSummary.getProfileFbid();
      if (str1 != null)
      {
        localUserKey = new UserKey(User.Type.FACEBOOK, str1);
        continue;
      }
      String str2 = paramContactSummary.getContactId();
      localUserKey = null;
      if (str2 == null)
        continue;
      localUserKey = new UserKey(User.Type.FACEBOOK_CONTACT, str2);
    }
  }

  public static ImmutableCollection<UserKey> b(ContactSummary paramContactSummary)
  {
    if ((paramContactSummary.getProfileFbid() != null) || (paramContactSummary.getContactId() != null));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      ImmutableSet.Builder localBuilder = new ImmutableSet.Builder();
      String str1 = paramContactSummary.getProfileFbid();
      if (str1 != null)
        localBuilder.b(new UserKey(User.Type.FACEBOOK, str1));
      String str2 = paramContactSummary.getContactId();
      if (str2 != null)
        localBuilder.b(new UserKey(User.Type.FACEBOOK_CONTACT, str2));
      return localBuilder.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactUserKey
 * JD-Core Version:    0.6.0
 */