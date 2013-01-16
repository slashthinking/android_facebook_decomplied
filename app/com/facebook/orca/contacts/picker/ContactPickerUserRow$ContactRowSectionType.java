package com.facebook.orca.contacts.picker;

public enum ContactPickerUserRow$ContactRowSectionType
{
  static
  {
    FAVORITES = new ContactRowSectionType("FAVORITES", 1);
    TOP_FRIENDS = new ContactRowSectionType("TOP_FRIENDS", 2);
    ACTIVE_FRIENDS = new ContactRowSectionType("ACTIVE_FRIENDS", 3);
    SEARCH_RESULT = new ContactRowSectionType("SEARCH_RESULT", 4);
    ContactRowSectionType[] arrayOfContactRowSectionType = new ContactRowSectionType[5];
    arrayOfContactRowSectionType[0] = UNKNOWN;
    arrayOfContactRowSectionType[1] = FAVORITES;
    arrayOfContactRowSectionType[2] = TOP_FRIENDS;
    arrayOfContactRowSectionType[3] = ACTIVE_FRIENDS;
    arrayOfContactRowSectionType[4] = SEARCH_RESULT;
    $VALUES = arrayOfContactRowSectionType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerUserRow.ContactRowSectionType
 * JD-Core Version:    0.6.0
 */