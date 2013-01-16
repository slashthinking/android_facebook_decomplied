package com.facebook.orca.common.ui.titlebar;

import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.users.UserWithIdentifier;
import java.util.Iterator;
import java.util.Set;

class DivebarController$3
  implements DivebarViewListener
{
  public boolean a(UserWithIdentifier paramUserWithIdentifier, boolean paramBoolean, ContactPickerRow paramContactPickerRow)
  {
    boolean bool = false;
    Iterator localIterator = DivebarController.i(this.a).iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      bool = ((DivebarViewListener)localIterator.next()).a(paramUserWithIdentifier, paramBoolean, paramContactPickerRow);
    }
    while (!bool);
    while (true)
    {
      return true;
      if (bool)
        continue;
      DivebarController.a(this.a, paramUserWithIdentifier, paramBoolean, paramContactPickerRow);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.DivebarController.3
 * JD-Core Version:    0.6.0
 */