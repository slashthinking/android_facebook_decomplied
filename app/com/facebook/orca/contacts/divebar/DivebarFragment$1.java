package com.facebook.orca.contacts.divebar;

import com.facebook.orca.contacts.picker.ContactPickerGroupRow;
import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.UserWithIdentifier;

class DivebarFragment$1
  implements ContactPickerListFilter.RowCreator
{
  public ContactPickerRow a(Object paramObject)
  {
    if ((paramObject instanceof UserWithIdentifier));
    for (Object localObject = DivebarFragment.a(this.a, (UserWithIdentifier)paramObject, ContactPickerUserRow.ContactRowSectionType.SEARCH_RESULT); ; localObject = new ContactPickerGroupRow((ThreadSummary)paramObject))
    {
      return localObject;
      if (!(paramObject instanceof ThreadSummary))
        break;
    }
    BLog.d(DivebarFragment.c(), "unexpected rowData of type: " + paramObject.getClass());
    throw new IllegalArgumentException();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarFragment.1
 * JD-Core Version:    0.6.0
 */