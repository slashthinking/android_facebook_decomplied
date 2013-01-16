package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter.FilteringState;

class ContactPickerMergedFilter$ContactPickerFilterInstance
{
  private final ContactPickerListFilter a;
  private final String b;
  private final boolean c;
  private ContactPickerFilterResult d;
  private CustomFilter.FilteringState e = CustomFilter.FilteringState.FINISHED;

  public ContactPickerMergedFilter$ContactPickerFilterInstance(ContactPickerMergedFilter.ContactPickerSubFilterConfig paramContactPickerSubFilterConfig)
  {
    this.a = paramContactPickerSubFilterConfig.a();
    this.b = paramContactPickerSubFilterConfig.c();
    this.c = paramContactPickerSubFilterConfig.b();
  }

  public ContactPickerListFilter a()
  {
    return this.a;
  }

  public void a(CustomFilter.FilteringState paramFilteringState)
  {
    this.e = paramFilteringState;
  }

  public void a(ContactPickerFilterResult paramContactPickerFilterResult)
  {
    this.d = paramContactPickerFilterResult;
  }

  public String b()
  {
    return this.b;
  }

  public ContactPickerFilterResult c()
  {
    return this.d;
  }

  public CustomFilter.FilteringState d()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerMergedFilter.ContactPickerFilterInstance
 * JD-Core Version:    0.6.0
 */