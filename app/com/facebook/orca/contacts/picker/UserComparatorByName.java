package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.users.User;
import java.text.Collator;
import java.util.Comparator;

public class UserComparatorByName
  implements Comparator<User>
{
  private final Collator a = Collator.getInstance();

  public UserComparatorByName()
  {
    this.a.setStrength(0);
  }

  public int a(User paramUser1, User paramUser2)
  {
    String str1 = StringUtil.b(paramUser1.g());
    String str2 = StringUtil.b(paramUser2.g());
    return this.a.compare(str1, str2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.UserComparatorByName
 * JD-Core Version:    0.6.0
 */