package com.facebook.nearby.places;

 enum NearbyPlacesAdapter$StateType
{
  static
  {
    DISPLAY_RESULTS = new StateType("DISPLAY_RESULTS", 2);
    StateType[] arrayOfStateType = new StateType[3];
    arrayOfStateType[0] = DETECTING_LOCATION;
    arrayOfStateType[1] = LOADING_PLACES;
    arrayOfStateType[2] = DISPLAY_RESULTS;
    $VALUES = arrayOfStateType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesAdapter.StateType
 * JD-Core Version:    0.6.0
 */