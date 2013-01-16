package com.facebook.katana.binding;

public enum ManagedDataStore$ClearType
{
  static
  {
    CLEAR_DISK = new ClearType("CLEAR_DISK", 1);
    CLEAR_ALL = new ClearType("CLEAR_ALL", 2);
    ClearType[] arrayOfClearType = new ClearType[3];
    arrayOfClearType[0] = CLEAR_MEMORY;
    arrayOfClearType[1] = CLEAR_DISK;
    arrayOfClearType[2] = CLEAR_ALL;
    $VALUES = arrayOfClearType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ManagedDataStore.ClearType
 * JD-Core Version:    0.6.0
 */