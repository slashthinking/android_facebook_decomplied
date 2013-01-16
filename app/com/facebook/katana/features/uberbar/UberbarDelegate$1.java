package com.facebook.katana.features.uberbar;

import android.text.Editable;
import android.text.TextWatcher;

class UberbarDelegate$1
  implements TextWatcher
{
  private boolean b = false;

  public void afterTextChanged(Editable paramEditable)
  {
    UberbarDelegate.a(this.a, paramEditable);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!UberbarDelegate.a(this.a));
    while (true)
    {
      return;
      if ((paramInt1 == 0) && (paramInt2 > 1) && (paramInt3 == 0))
      {
        UberbarDelegate.b(this.a).b(paramCharSequence.toString());
        continue;
      }
      if ((paramInt1 + paramInt2 == paramCharSequence.length()) && (paramInt2 < paramInt3));
      for (boolean bool = true; ; bool = false)
      {
        if (!Boolean.valueOf(bool).booleanValue())
          break label88;
        this.b = false;
        break;
      }
      label88: if (this.b)
        continue;
      UberbarDelegate.b(this.a).a(paramCharSequence.toString(), paramInt1, paramInt2, paramInt3);
      this.b = true;
    }
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarDelegate.1
 * JD-Core Version:    0.6.0
 */