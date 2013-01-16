package com.facebook.orca.contacts.picker;

import com.google.common.collect.ImmutableList;

public class ContactPickerFilterResult
{
  private final ContactPickerFilterResult.Type a;
  private final CharSequence b;
  private final ImmutableList<ContactPickerRow> c;

  private ContactPickerFilterResult(ContactPickerFilterResult.Type paramType, CharSequence paramCharSequence, ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.a = paramType;
    this.b = paramCharSequence;
    this.c = paramImmutableList;
  }

  public static ContactPickerFilterResult a(CharSequence paramCharSequence)
  {
    return new ContactPickerFilterResult(ContactPickerFilterResult.Type.EMPTY_CONSTRAINT, paramCharSequence, null);
  }

  public static ContactPickerFilterResult a(CharSequence paramCharSequence, ImmutableList<ContactPickerRow> paramImmutableList)
  {
    return new ContactPickerFilterResult(ContactPickerFilterResult.Type.OK, paramCharSequence, paramImmutableList);
  }

  public static ContactPickerFilterResult b(CharSequence paramCharSequence)
  {
    return new ContactPickerFilterResult(ContactPickerFilterResult.Type.EXCEPTION, paramCharSequence, null);
  }

  public ContactPickerFilterResult.Type a()
  {
    return this.a;
  }

  public CharSequence b()
  {
    return this.b;
  }

  public int c()
  {
    if (this.c != null);
    for (int i = this.c.size(); ; i = 0)
      return i;
  }

  public ImmutableList<ContactPickerRow> d()
  {
    return this.c;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("State: ").append(this.a).append(", ");
    localStringBuilder.append("Constraints: ").append(this.b);
    if (this.c != null)
      localStringBuilder.append(", ").append("Count: ").append(this.c.size());
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerFilterResult
 * JD-Core Version:    0.6.0
 */