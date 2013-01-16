package com.facebook.contacts.contactslist;

import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.users.Name;
import java.text.Collator;
import java.util.Comparator;

public class ContactComparatorByName
  implements Comparator<ContactSummary>
{
  private final Collator a = Collator.getInstance();

  public ContactComparatorByName()
  {
    this.a.setStrength(0);
  }

  public int a(ContactSummary paramContactSummary1, ContactSummary paramContactSummary2)
  {
    String str1 = StringUtil.b(paramContactSummary1.getName().f());
    String str2 = StringUtil.b(paramContactSummary2.getName().f());
    return this.a.compare(str1, str2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactComparatorByName
 * JD-Core Version:    0.6.0
 */