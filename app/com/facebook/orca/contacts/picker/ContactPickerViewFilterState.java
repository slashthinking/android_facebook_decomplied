package com.facebook.orca.contacts.picker;

public enum ContactPickerViewFilterState
{
  static
  {
    FILTERING = new ContactPickerViewFilterState("FILTERING", 2);
    FILTERED = new ContactPickerViewFilterState("FILTERED", 3);
    ContactPickerViewFilterState[] arrayOfContactPickerViewFilterState = new ContactPickerViewFilterState[4];
    arrayOfContactPickerViewFilterState[0] = NONE;
    arrayOfContactPickerViewFilterState[1] = UNFILTERED;
    arrayOfContactPickerViewFilterState[2] = FILTERING;
    arrayOfContactPickerViewFilterState[3] = FILTERED;
    $VALUES = arrayOfContactPickerViewFilterState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerViewFilterState
 * JD-Core Version:    0.6.0
 */