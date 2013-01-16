package com.facebook.katana;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.debug.Assert;

class LoginActivity$2
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.a.findViewById(2131296670).requestFocus();
      if (LoginActivity.a(this.a))
        LoginActivity.a(this.a, false);
      if (paramTextView != LoginActivity.b(this.a))
        break label61;
      LoginActivity.a(this.a, LoginActivity.LoginState.LOGIN_APPROVALS_CODE_ENTRY);
    }
    while (true)
    {
      return false;
      label61: if (paramTextView == LoginActivity.c(this.a))
      {
        LoginActivity.a(this.a, LoginActivity.LoginState.PASSWORD_ENTRY);
        continue;
      }
      Assert.b(false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.2
 * JD-Core Version:    0.6.0
 */