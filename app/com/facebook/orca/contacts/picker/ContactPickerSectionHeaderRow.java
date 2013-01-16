package com.facebook.orca.contacts.picker;

public class ContactPickerSectionHeaderRow
  implements ContactPickerRow
{
  private final String a;

  public ContactPickerSectionHeaderRow(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public String toString()
  {
    return "header: " + this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerSectionHeaderRow
 * JD-Core Version:    0.6.0
 */