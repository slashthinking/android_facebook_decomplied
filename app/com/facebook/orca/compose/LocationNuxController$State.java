package com.facebook.orca.compose;

 enum LocationNuxController$State
{
  static
  {
    LOCATION_NUX_SHOWING = new State("LOCATION_NUX_SHOWING", 1);
    LOCATION_DISABLED_NUX_SHOWING = new State("LOCATION_DISABLED_NUX_SHOWING", 2);
    State[] arrayOfState = new State[3];
    arrayOfState[0] = OFF;
    arrayOfState[1] = LOCATION_NUX_SHOWING;
    arrayOfState[2] = LOCATION_DISABLED_NUX_SHOWING;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.LocationNuxController.State
 * JD-Core Version:    0.6.0
 */