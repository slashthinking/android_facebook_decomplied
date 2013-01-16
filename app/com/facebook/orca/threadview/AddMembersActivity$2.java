package com.facebook.orca.threadview;

import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.orca.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserWithIdentifier;

class AddMembersActivity$2
  implements ContactPickerListFilter.RowCreator
{
  public ContactPickerRow a(Object paramObject)
  {
    if (!(paramObject instanceof UserWithIdentifier))
    {
      BLog.d(AddMembersActivity.i(), "unexpected rowData of type: " + paramObject.getClass());
      throw new IllegalArgumentException();
    }
    UserWithIdentifier localUserWithIdentifier = (UserWithIdentifier)paramObject;
    User localUser = localUserWithIdentifier.a();
    boolean bool = AddMembersActivity.b(this.a).a(localUser.c());
    return new ContactPickerUserRowBuilder().a(localUserWithIdentifier).a(ContactPickerUserRow.RowStyle.TWO_LINE).a(bool).c(true).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.AddMembersActivity.2
 * JD-Core Version:    0.6.0
 */