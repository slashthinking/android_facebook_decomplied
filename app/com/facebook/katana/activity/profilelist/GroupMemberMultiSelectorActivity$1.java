package com.facebook.katana.activity.profilelist;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class GroupMemberMultiSelectorActivity$1
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0);
    for (int i = 17301594; ; i = 2130838326)
    {
      this.a.u.setImageResource(i);
      return;
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    GroupMemberMultiSelectorActivity.a(this.a, paramCharSequence.toString().trim());
    GroupMemberMultiSelectorActivity.b(this.a, GroupMemberMultiSelectorActivity.a(this.a));
    GroupMemberMultiSelectorActivity.a(this.a, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupMemberMultiSelectorActivity.1
 * JD-Core Version:    0.6.0
 */