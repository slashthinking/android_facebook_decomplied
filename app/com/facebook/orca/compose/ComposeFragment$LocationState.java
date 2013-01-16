package com.facebook.orca.compose;

 enum ComposeFragment$LocationState
{
  static
  {
    HAS_LOCATION = new LocationState("HAS_LOCATION", 1);
    FINDING_LOCATION = new LocationState("FINDING_LOCATION", 2);
    NO_LOCATION = new LocationState("NO_LOCATION", 3);
    LOCATION_ERROR = new LocationState("LOCATION_ERROR", 4);
    LocationState[] arrayOfLocationState = new LocationState[5];
    arrayOfLocationState[0] = INIT;
    arrayOfLocationState[1] = HAS_LOCATION;
    arrayOfLocationState[2] = FINDING_LOCATION;
    arrayOfLocationState[3] = NO_LOCATION;
    arrayOfLocationState[4] = LOCATION_ERROR;
    $VALUES = arrayOfLocationState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.LocationState
 * JD-Core Version:    0.6.0
 */