package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter.FilterListener;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilteringState;
import com.facebook.orca.debug.BLog;

class ContactPickerMergedFilter$2
  implements CustomFilter.FilterListener
{
  public void a(int paramInt)
  {
  }

  public void a(CustomFilter.FilteringState paramFilteringState)
  {
    BLog.a(ContactPickerMergedFilter.a(), "Received friends filtering state: %s", new Object[] { paramFilteringState });
    this.a.a(paramFilteringState);
    ContactPickerMergedFilter.a(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerMergedFilter.2
 * JD-Core Version:    0.6.0
 */