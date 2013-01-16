package com.facebook.orca.contacts.picker;

import com.facebook.orca.users.User;
import java.util.Comparator;

class ContactPickerAddressBookFilter$1
  implements Comparator<User>
{
  public int a(User paramUser1, User paramUser2)
  {
    float f1 = paramUser1.v();
    float f2 = paramUser2.v();
    int i;
    if (f1 > f2)
      i = -1;
    while (true)
    {
      return i;
      if (f1 < f2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerAddressBookFilter.1
 * JD-Core Version:    0.6.0
 */