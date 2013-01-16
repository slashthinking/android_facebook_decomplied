package com.facebook.orca.push.c2dm;

public enum C2DMRegistrar$RegistrationStatus
{
  static
  {
    EXPIRED = new RegistrationStatus("EXPIRED", 2);
    NONE = new RegistrationStatus("NONE", 3);
    RegistrationStatus[] arrayOfRegistrationStatus = new RegistrationStatus[4];
    arrayOfRegistrationStatus[0] = CURRENT;
    arrayOfRegistrationStatus[1] = WRONG_TYPE;
    arrayOfRegistrationStatus[2] = EXPIRED;
    arrayOfRegistrationStatus[3] = NONE;
    $VALUES = arrayOfRegistrationStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMRegistrar.RegistrationStatus
 * JD-Core Version:    0.6.0
 */