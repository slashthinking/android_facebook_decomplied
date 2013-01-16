package com.facebook.katana;

import android.text.Editable;
import android.text.TextWatcher;

class UsersTabHostActivity$1
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
    String str = paramCharSequence.toString().trim();
    if ((UsersTabHostActivity.a(this.a) instanceof UsersTabProgressSource))
      ((UsersTabProgressSource)UsersTabHostActivity.a(this.a)).a(str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.UsersTabHostActivity.1
 * JD-Core Version:    0.6.0
 */