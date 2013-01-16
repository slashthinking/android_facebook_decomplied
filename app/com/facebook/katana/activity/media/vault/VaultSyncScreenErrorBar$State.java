package com.facebook.katana.activity.media.vault;

 enum VaultSyncScreenErrorBar$State
{
  static
  {
    REQUIRES_WIFI = new State("REQUIRES_WIFI", 1);
    LOW_BATTERY = new State("LOW_BATTERY", 2);
    NO_INTERNET = new State("NO_INTERNET", 3);
    INVISIBLE = new State("INVISIBLE", 4);
    State[] arrayOfState = new State[5];
    arrayOfState[0] = SYNC_IS_OFF;
    arrayOfState[1] = REQUIRES_WIFI;
    arrayOfState[2] = LOW_BATTERY;
    arrayOfState[3] = NO_INTERNET;
    arrayOfState[4] = INVISIBLE;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenErrorBar.State
 * JD-Core Version:    0.6.0
 */