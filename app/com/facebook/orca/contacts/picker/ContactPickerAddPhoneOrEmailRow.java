package com.facebook.orca.contacts.picker;

import com.facebook.orca.users.UserIdentifier.IdentifierType;

public class ContactPickerAddPhoneOrEmailRow
  implements ContactPickerRow
{
  private final String a;
  private final UserIdentifier.IdentifierType b;

  ContactPickerAddPhoneOrEmailRow(String paramString, UserIdentifier.IdentifierType paramIdentifierType)
  {
    this.a = paramString;
    this.b = paramIdentifierType;
  }

  public String a()
  {
    return this.a;
  }

  public UserIdentifier.IdentifierType b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerAddPhoneOrEmailRow
 * JD-Core Version:    0.6.0
 */