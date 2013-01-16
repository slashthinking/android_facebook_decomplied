package com.facebook.katana.binding;

public enum ManagedDataStore$Mode
{
  static
  {
    SINGLE_REQUEST_BY_KEY = new Mode("SINGLE_REQUEST_BY_KEY", 1);
    SINGLE_REQUEST = new Mode("SINGLE_REQUEST", 2);
    Mode[] arrayOfMode = new Mode[3];
    arrayOfMode[0] = UNRESTRICTED;
    arrayOfMode[1] = SINGLE_REQUEST_BY_KEY;
    arrayOfMode[2] = SINGLE_REQUEST;
    $VALUES = arrayOfMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ManagedDataStore.Mode
 * JD-Core Version:    0.6.0
 */