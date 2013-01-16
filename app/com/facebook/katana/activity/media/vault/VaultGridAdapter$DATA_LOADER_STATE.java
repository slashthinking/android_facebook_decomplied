package com.facebook.katana.activity.media.vault;

 enum VaultGridAdapter$DATA_LOADER_STATE
{
  static
  {
    FETCHING = new DATA_LOADER_STATE("FETCHING", 1);
    FETCHED_ALL = new DATA_LOADER_STATE("FETCHED_ALL", 2);
    DATA_LOADER_STATE[] arrayOfDATA_LOADER_STATE = new DATA_LOADER_STATE[3];
    arrayOfDATA_LOADER_STATE[0] = IDLE;
    arrayOfDATA_LOADER_STATE[1] = FETCHING;
    arrayOfDATA_LOADER_STATE[2] = FETCHED_ALL;
    $VALUES = arrayOfDATA_LOADER_STATE;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultGridAdapter.DATA_LOADER_STATE
 * JD-Core Version:    0.6.0
 */