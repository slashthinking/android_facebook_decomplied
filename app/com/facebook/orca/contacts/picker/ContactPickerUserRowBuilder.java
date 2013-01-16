package com.facebook.orca.contacts.picker;

import com.facebook.orca.users.UserWithIdentifier;

public class ContactPickerUserRowBuilder
{
  private UserWithIdentifier a;
  private ContactPickerUserRow.RowStyle b;
  private boolean c;
  private boolean d;
  private boolean e;
  private String f;
  private ContactPickerUserRow.ContactRowSectionType g = ContactPickerUserRow.ContactRowSectionType.UNKNOWN;

  public ContactPickerUserRow a()
  {
    return new ContactPickerUserRow(this);
  }

  public ContactPickerUserRowBuilder a(ContactPickerUserRow.ContactRowSectionType paramContactRowSectionType)
  {
    this.g = paramContactRowSectionType;
    return this;
  }

  public ContactPickerUserRowBuilder a(ContactPickerUserRow.RowStyle paramRowStyle)
  {
    this.b = paramRowStyle;
    return this;
  }

  public ContactPickerUserRowBuilder a(UserWithIdentifier paramUserWithIdentifier)
  {
    this.a = paramUserWithIdentifier;
    return this;
  }

  public ContactPickerUserRowBuilder a(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public ContactPickerUserRowBuilder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public ContactPickerUserRowBuilder b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public UserWithIdentifier b()
  {
    return this.a;
  }

  public ContactPickerUserRow.RowStyle c()
  {
    return this.b;
  }

  public ContactPickerUserRowBuilder c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public boolean d()
  {
    return this.c;
  }

  public boolean e()
  {
    return this.d;
  }

  public boolean f()
  {
    return this.e;
  }

  public String g()
  {
    return this.f;
  }

  public ContactPickerUserRow.ContactRowSectionType h()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerUserRowBuilder
 * JD-Core Version:    0.6.0
 */