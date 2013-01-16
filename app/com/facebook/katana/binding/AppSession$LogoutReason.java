package com.facebook.katana.binding;

public enum AppSession$LogoutReason
{
  static
  {
    ACCOUNT_REMOVED = new LogoutReason("ACCOUNT_REMOVED", 1);
    USER_INITIATED = new LogoutReason("USER_INITIATED", 2);
    FORCED_ERROR_102_INVALID_SESSION = new LogoutReason("FORCED_ERROR_102_INVALID_SESSION", 3);
    FORCED_FACEWEB_AUTHENTICATION_FAILED = new LogoutReason("FORCED_FACEWEB_AUTHENTICATION_FAILED", 4);
    FORCED_FACEWEB_COMPONENTS_STORE_ERROR = new LogoutReason("FORCED_FACEWEB_COMPONENTS_STORE_ERROR", 5);
    FORCED_SYNC_ADAPTER_SERVICE_SESSION_ERROR = new LogoutReason("FORCED_SYNC_ADAPTER_SERVICE_SESSION_ERROR", 6);
    LogoutReason[] arrayOfLogoutReason = new LogoutReason[7];
    arrayOfLogoutReason[0] = FACEWEB_NONSPECIFIC;
    arrayOfLogoutReason[1] = ACCOUNT_REMOVED;
    arrayOfLogoutReason[2] = USER_INITIATED;
    arrayOfLogoutReason[3] = FORCED_ERROR_102_INVALID_SESSION;
    arrayOfLogoutReason[4] = FORCED_FACEWEB_AUTHENTICATION_FAILED;
    arrayOfLogoutReason[5] = FORCED_FACEWEB_COMPONENTS_STORE_ERROR;
    arrayOfLogoutReason[6] = FORCED_SYNC_ADAPTER_SERVICE_SESSION_ERROR;
    $VALUES = arrayOfLogoutReason;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.LogoutReason
 * JD-Core Version:    0.6.0
 */