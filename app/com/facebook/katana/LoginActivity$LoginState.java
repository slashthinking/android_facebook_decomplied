package com.facebook.katana;

 enum LoginActivity$LoginState
{
  static
  {
    LOGIN_APPROVALS_CODE_ENTRY = new LoginState("LOGIN_APPROVALS_CODE_ENTRY", 1);
    LoginState[] arrayOfLoginState = new LoginState[2];
    arrayOfLoginState[0] = PASSWORD_ENTRY;
    arrayOfLoginState[1] = LOGIN_APPROVALS_CODE_ENTRY;
    $VALUES = arrayOfLoginState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.LoginState
 * JD-Core Version:    0.6.0
 */