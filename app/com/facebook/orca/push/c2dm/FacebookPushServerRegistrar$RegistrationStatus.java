package com.facebook.orca.push.c2dm;

public enum FacebookPushServerRegistrar$RegistrationStatus
{
  static
  {
    NONE = new RegistrationStatus("NONE", 3);
    RegistrationStatus[] arrayOfRegistrationStatus = new RegistrationStatus[4];
    arrayOfRegistrationStatus[0] = CURRENT;
    arrayOfRegistrationStatus[1] = EXPIRED;
    arrayOfRegistrationStatus[2] = WRONG_USER;
    arrayOfRegistrationStatus[3] = NONE;
    $VALUES = arrayOfRegistrationStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.FacebookPushServerRegistrar.RegistrationStatus
 * JD-Core Version:    0.6.0
 */