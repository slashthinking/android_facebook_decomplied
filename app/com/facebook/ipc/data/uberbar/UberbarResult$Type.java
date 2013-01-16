package com.facebook.ipc.data.uberbar;

public enum UberbarResult$Type
{
  static
  {
    PAGE = new Type("PAGE", 1);
    APP = new Type("APP", 2);
    GROUP = new Type("GROUP", 3);
    SHORTCUT = new Type("SHORTCUT", 4);
    PAGE_FAN = new Type("PAGE_FAN", 5);
    PAGE_ADMIN = new Type("PAGE_ADMIN", 6);
    Type[] arrayOfType = new Type[7];
    arrayOfType[0] = USER;
    arrayOfType[1] = PAGE;
    arrayOfType[2] = APP;
    arrayOfType[3] = GROUP;
    arrayOfType[4] = SHORTCUT;
    arrayOfType[5] = PAGE_FAN;
    arrayOfType[6] = PAGE_ADMIN;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.data.uberbar.UberbarResult.Type
 * JD-Core Version:    0.6.0
 */