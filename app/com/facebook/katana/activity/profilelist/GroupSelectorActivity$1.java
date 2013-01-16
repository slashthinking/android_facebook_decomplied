package com.facebook.katana.activity.profilelist;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;

class GroupSelectorActivity$1
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ((GroupSelectorAdapter)this.a.B).getFilter().filter(paramCharSequence);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupSelectorActivity.1
 * JD-Core Version:    0.6.0
 */