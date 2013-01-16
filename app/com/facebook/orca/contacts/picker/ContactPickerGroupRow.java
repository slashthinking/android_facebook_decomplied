package com.facebook.orca.contacts.picker;

import com.facebook.orca.threads.ThreadSummary;

public class ContactPickerGroupRow
  implements ContactPickerRow
{
  private final ThreadSummary a;

  public ContactPickerGroupRow(ThreadSummary paramThreadSummary)
  {
    this.a = paramThreadSummary;
  }

  public ThreadSummary a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerGroupRow
 * JD-Core Version:    0.6.0
 */