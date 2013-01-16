package com.facebook.katana.binding;

public enum AppSession$LoginStatus
{
  static
  {
    STATUS_LOGGED_IN = new LoginStatus("STATUS_LOGGED_IN", 2);
    STATUS_LOGGING_OUT = new LoginStatus("STATUS_LOGGING_OUT", 3);
    LoginStatus[] arrayOfLoginStatus = new LoginStatus[4];
    arrayOfLoginStatus[0] = STATUS_LOGGED_OUT;
    arrayOfLoginStatus[1] = STATUS_LOGGING_IN;
    arrayOfLoginStatus[2] = STATUS_LOGGED_IN;
    arrayOfLoginStatus[3] = STATUS_LOGGING_OUT;
    $VALUES = arrayOfLoginStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.LoginStatus
 * JD-Core Version:    0.6.0
 */