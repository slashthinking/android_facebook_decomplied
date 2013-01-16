package com.facebook.orca.creation;

import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.orca.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserWithIdentifier;

class CreateThreadActivity$5
  implements ContactPickerListFilter.RowCreator
{
  public ContactPickerRow a(Object paramObject)
  {
    if (!(paramObject instanceof UserWithIdentifier))
    {
      BLog.d(CreateThreadActivity.i(), "unexpected rowData of type: " + paramObject.getClass());
      throw new IllegalArgumentException();
    }
    UserWithIdentifier localUserWithIdentifier = (UserWithIdentifier)paramObject;
    User localUser = localUserWithIdentifier.a();
    boolean bool;
    if (UserIdentifier.IdentifierType.FBID == localUserWithIdentifier.b().e())
      bool = CreateThreadActivity.b(this.a).a(localUser.c());
    for (ContactPickerUserRow localContactPickerUserRow = new ContactPickerUserRowBuilder().a(localUserWithIdentifier).a(ContactPickerUserRow.RowStyle.TWO_LINE).a(bool).c(true).a(); ; localContactPickerUserRow = new ContactPickerUserRowBuilder().a(localUserWithIdentifier).a(ContactPickerUserRow.RowStyle.TWO_LINE).a())
      return localContactPickerUserRow;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.creation.CreateThreadActivity.5
 * JD-Core Version:    0.6.0
 */