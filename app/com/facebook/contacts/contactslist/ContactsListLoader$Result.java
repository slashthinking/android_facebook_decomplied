package com.facebook.contacts.contactslist;

import com.facebook.contacts.models.ContactSummary;
import com.google.common.collect.ImmutableList;

public class ContactsListLoader$Result
{
  private final ImmutableList<ContactSummary> a;
  private final boolean b;

  public ContactsListLoader$Result(ImmutableList<ContactSummary> paramImmutableList)
  {
    this(paramImmutableList, false);
  }

  public ContactsListLoader$Result(ImmutableList<ContactSummary> paramImmutableList, boolean paramBoolean)
  {
    this.a = paramImmutableList;
    this.b = paramBoolean;
  }

  public ImmutableList<ContactSummary> a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactsListLoader.Result
 * JD-Core Version:    0.6.0
 */