package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

class ContactPickerView$7
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.g();
    ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput(ContactPickerView.b(this.a), 1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerView.7
 * JD-Core Version:    0.6.0
 */