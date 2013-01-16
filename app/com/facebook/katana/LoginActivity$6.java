package com.facebook.katana;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class LoginActivity$6
  implements View.OnFocusChangeListener
{
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((LoginActivity.f(this.a).isFocused()) || (LoginActivity.c(this.a).isFocused()) || (LoginActivity.b(this.a).isFocused()));
    for (boolean bool = true; ; bool = false)
    {
      if (LoginActivity.a(this.a) != bool)
        LoginActivity.a(this.a, bool);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.6
 * JD-Core Version:    0.6.0
 */