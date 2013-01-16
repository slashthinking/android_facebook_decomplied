package com.facebook.orca.contacts.picker;

import com.facebook.orca.users.User;
import com.facebook.orca.users.UserWithIdentifier;

public class ContactPickerUserRow
  implements ContactPickerRow
{
  private final UserWithIdentifier a;
  private final ContactPickerUserRow.RowStyle b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final String f;
  private final ContactPickerUserRow.ContactRowSectionType g;

  public ContactPickerUserRow(ContactPickerUserRowBuilder paramContactPickerUserRowBuilder)
  {
    this.a = paramContactPickerUserRowBuilder.b();
    this.b = paramContactPickerUserRowBuilder.c();
    this.c = paramContactPickerUserRowBuilder.d();
    this.d = paramContactPickerUserRowBuilder.e();
    this.e = paramContactPickerUserRowBuilder.f();
    this.f = paramContactPickerUserRowBuilder.g();
    this.g = paramContactPickerUserRowBuilder.h();
  }

  public UserWithIdentifier a()
  {
    return this.a;
  }

  public User b()
  {
    return this.a.a();
  }

  public ContactPickerUserRow.RowStyle c()
  {
    return this.b;
  }

  public boolean d()
  {
    return this.c;
  }

  public boolean e()
  {
    return this.d;
  }

  public String f()
  {
    return this.f;
  }

  public boolean g()
  {
    return this.e;
  }

  public ContactPickerUserRow.ContactRowSectionType h()
  {
    return this.g;
  }

  public String toString()
  {
    return b().f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerUserRow
 * JD-Core Version:    0.6.0
 */