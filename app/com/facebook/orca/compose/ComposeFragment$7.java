package com.facebook.orca.compose;

import android.text.Editable;
import android.text.TextWatcher;

class ComposeFragment$7
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
    ComposeFragment.m(this.a);
    if (paramInt3 > 0)
      ComposeFragment.a(this.a, paramInt1, paramInt3);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.7
 * JD-Core Version:    0.6.0
 */