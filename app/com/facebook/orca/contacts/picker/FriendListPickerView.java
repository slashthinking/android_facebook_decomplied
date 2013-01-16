package com.facebook.orca.contacts.picker;

import com.facebook.widget.CustomViewGroup;

public class FriendListPickerView extends CustomViewGroup
{
  private final ContactPickerView a;
  private ContactPickerViewListener b;

  public String getSearchBoxText()
  {
    return this.a.getSearchBoxText();
  }

  public void setContactPickerViewListener(ContactPickerViewListener paramContactPickerViewListener)
  {
    this.b = paramContactPickerViewListener;
  }

  public void setOnFilterStateChangedListener(ContactPickerView.OnFilterStateChangedListener paramOnFilterStateChangedListener)
  {
    this.a.setOnFilterStateChangedListener(paramOnFilterStateChangedListener);
  }

  public void setSearchBoxText(String paramString)
  {
    this.a.setSearchBoxText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.FriendListPickerView
 * JD-Core Version:    0.6.0
 */